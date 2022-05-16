import { useEffect, useRef, useState } from "react";
import { loginUser } from "../../services/user/UserAPI";
import { Link, useNavigate, useLocation } from "react-router-dom";
import useAuth from "../../hooks/useAuth";
import jwt from "jwt-decode";

const Login = () => {
  //when we successfully authenticate when we login,
  //we set the new auth state and store it in the global context
  const { setAuth } = useAuth();

  const navigate = useNavigate();
  const location = useLocation();

  //where the user came from
  const from = location.state?.from?.pathname || "/";

  const userRef = useRef();
  const errRef = useRef();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errMsg, setErrMsg] = useState("");

  //set the focus on the first input when the component loads
  useEffect(() => {
    userRef.current.focus();
  }, []);

  //Empty out any error msg that occurs if the user changes one of the inputs
  useEffect(() => {
    setErrMsg("");
  }, [username, password]);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const user = { username, password };
    try {
      const response = await loginUser(user);
      const accessToken = response?.data.access_token;

      //decoding the token
      const payload = jwt(accessToken);

      //get roles from the payload
      console.log(payload.roles);
      // storing the authenticated user in the context api
      setAuth({ username, password, payload, accessToken });

      setUsername("");
      setPassword("");
      // where the user was headed fefore being sent to the login page
      navigate(from, { replace: true });
    } catch (err) {
      if (err.message === "Network Error") {
        setErrMsg("No server response");
      } else if (err.response?.status === 400) {
        setErrMsg("Missing username or password");
      } else if (err.response?.status === 403) {
        setErrMsg("Unauthorized");
      } else {
        setErrMsg("Login failed");
      }
      errRef.current.focus();
      console.log(err);
    }
  };

  return (
    <>
      <section>
        <p
          ref={errRef}
          className={errMsg ? "errmsg" : "offscreen"}
          aria-live="assertive"
        >
          {errMsg}
        </p>
        <h1>Sign In</h1>
        {/* No need to pass the event to the created method above */}
        {/* (It gets passed by the default) */}
        <form onSubmit={handleSubmit}>
          {/* "htmlFor" needs to match the id attribute of the input */}
          <label htmlFor="username">Username:</label>
          {/* userRef to set the focuss on this input */}
          <input
            type="text"
            id="username"
            ref={userRef}
            autoComplete="off"
            onChange={(e) => setUsername(e.target.value)}
            value={username}
            required
          />
          {/* "htmlFor" needs to match the id attribute of the input */}
          <label htmlFor="password">Password:</label>
          {/* userRef to set the focuss on this input */}
          <input
            type="password"
            id="password"
            //ref={userRef} I will never set the focuss directly on the password
            //(a reference for it is not created)
            //autoComplete="off" this is not supported by the type password
            onChange={(e) => setPassword(e.target.value)}
            value={password}
            required
          />
          {/* onClick={handleSubmit} is not needed here because it's the only button on the form */}
          <button>Sign In</button>
        </form>
        <p>
          Need an Account? <br />
          <span className="line">
            <Link to={"/api/v1/register"}>Sign Up</Link>
          </span>
        </p>
      </section>
    </>
  );
};

export default Login;
