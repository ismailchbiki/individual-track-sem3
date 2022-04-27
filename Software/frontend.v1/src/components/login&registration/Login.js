import React, { useEffect, useRef, useState } from "react";
import { Link } from "react-router-dom";

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  //msg to show when success or fail login
  const userRef = useRef();
  const errRef = useRef();
  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  //show error msg when login fails
  useEffect(() => {
    setErrMsg("");
  }, [email, password]);

  //on log in click
  const handleSubmit = (e) => {
    e.preventDefault();

    const user = { email, password };
    console.log(user);
    // loginUser(user)
    //   .then((res) => {
    //     console.log(user);
    //     console.log(res);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });

    console.log(email, password);
  };

  return (
    <div style={{ marginTop: "15vh" }} className="container">
      <div className="row">
        <div className="col-md-6 col-md-offset-3">
          <h1> User Login Page </h1>
          {/* <form th:action="@{/login}" method="post"> */}
          <form>
            {/* <!-- error message --> */}
            {/* <div th:if="${param.error}">
                    <div className="alert alert-danger">Invalid username or
                        password.</div>
                </div> */}

            {/* <!-- logout message --> */}
            {/* <div th:if="${param.logout}">
                    <div className="alert alert-info">You have been logged out.</div>
                </div> */}

            <br />
            <div className="form-group">
              <label> Email </label> :
              <input
                className="form-control"
                id="email"
                type="email"
                name="email"
                placeholder="Enter Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
            </div>

            <br />
            <div className="form-group">
              <label>Password</label>:
              <input
                className="form-control"
                id="password"
                type="password"
                name="password"
                placeholder="Enter Password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
            </div>

            <br />
            <div className="form-group">
              <div className="row">
                <div className="col-sm-6 col-sm-offset-3">
                  <input
                    type="submit"
                    name="login-submit"
                    id="login-submit"
                    className="form-control btn btn-primary"
                    value="Log In"
                    onClick={(e) => handleSubmit(e)}
                  />
                </div>
              </div>
            </div>
          </form>
          <br />
          <div className="form-group">
            <span>
              New user? &nbsp;<Link to={"/api/v1/register"}>Register here</Link>
            </span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
