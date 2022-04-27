import React from "react";
import { Link } from "react-router-dom";

const Login = () => {
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
              <label for="username"> Username </label> :
              <input
                type="text"
                className="form-control"
                id="username"
                name="username"
                placeholder="Enter Email ID"
              />
            </div>

            <br />
            <div className="form-group">
              <label for="password">Password</label>:
              <input
                type="password"
                id="password"
                name="password"
                className="form-control"
                placeholder="Enter Password"
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
