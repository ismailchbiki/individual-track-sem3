import React, { useRef, useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { createUser } from "../../services/user/UserAPI";

const Registration = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [roles, setRoles] = useState([]);

  //for login (not registration)
  const userRef = useRef();
  const errRef = useRef();
  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    setErrMsg("");
  }, [email, password]);

  const handleSubmit = (e) => {
    e.preventDefault();

    const user = { firstName, lastName, email, password, roles };

    createUser(user)
      .then((res) => {
        console.log(user);
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });

    console.log(firstName, lastName, email, password);
  };

  return (
    <>
      <div
        className="container"
        style={{
          marginTop: "6%",
        }}
      >
        <div className="row">
          <div className="col-md-6 col-md-offset-3">
            {/* <!-- success message --> */}
            {/* <div th:if="${param.success}">
              <div class="alert alert-info">
                You've successfully registered to our awesome app!
              </div>
            </div> */}

            <section>
              <p
                ref={errRef}
                className={errMsg ? "errmsg" : "offscreen"}
                aria-live="assertive"
              >
                {errMsg}
              </p>
            </section>

            <h1>Registration</h1>
            <br />

            <form>
              <div className="form-group">
                <label className="control-label">First Name</label>
                <input
                  id="firstName"
                  className="form-control"
                  type="text"
                  value={firstName}
                  onChange={(e) => setFirstName(e.target.value)}
                  required
                />
              </div>

              <br />
              <div className="form-group">
                <label className="control-label">Last Name</label>
                <input
                  id="lastName"
                  className="form-control"
                  type="text"
                  value={lastName}
                  onChange={(e) => setLastName(e.target.value)}
                  required
                />
              </div>

              <br />
              <div className="form-group">
                <label className="control-label">Email</label>
                <input
                  id="email"
                  className="form-control"
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
              </div>

              <br />
              <div className="form-group">
                <label className="control-label">Password</label>
                <input
                  id="password"
                  className="form-control"
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  required
                />
              </div>

              <br />
              <div className="form-group">
                <button
                  onClick={(e) => handleSubmit(e)}
                  className="btn btn-success"
                >
                  Register
                </button>
                <span style={{ marginLeft: "3px" }}>
                  &nbsp; Already registered?
                  {/* <a href="/" th:href="@{/login}">
                    Login here
                  </a> */}
                  &nbsp;&nbsp;<Link to={"/api/v1/login"}>Login here</Link>
                </span>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default Registration;
