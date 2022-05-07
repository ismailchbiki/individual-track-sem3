import { useState } from "react";
import { Link } from "react-router-dom";
import { loginUser } from "../../services/user/UserAPI";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  //on log in click
  const handleSubmit = (e) => {
    e.preventDefault();

    const user = { username, password };
    console.log(user);
    loginUser(user)
      .then((res) => {
        console.log(user);
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <div style={{ marginTop: "15vh" }} className="container">
        <div className="row">
          <div className="col-md-6 col-md-offset-3">
            <h1> User Login Page </h1>

            <br />
            <div className="form-group">
              <label htmlFor="email"> Email :</label>
              <input
                className="form-control"
                id="email"
                type="email"
                name="email"
                placeholder="Enter Email"
                onChange={(e) => setUsername(e.target.value)}
                value={username}
                required
              />
            </div>

            <br />
            <div className="form-group">
              <label htmlFor="password">Password :</label>
              <input
                className="form-control"
                id="password"
                type="password"
                name="password"
                placeholder="Enter Password"
                onChange={(e) => setPassword(e.target.value)}
                value={password}
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

            <br />
            <div className="form-group">
              <span>
                New user? &nbsp;
                <Link to={"/api/v1/register"}>Register here</Link>
              </span>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
