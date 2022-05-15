import { Link } from "react-router-dom";

const Header = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container-fluid">
        <Link to={"/"} className="navbar-brand">
          Booking Site
        </Link>

        <div className="collapse navbar-collapse" id="navbarText">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <Link to={"/"} className="nav-link active" aria-current="page">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/api/v1/book"} className="nav-link">
                Book
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/api/v1/kite-lessons"} className="nav-link">
                Admin
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/api/v1/register"} className="nav-link">
                Register
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/api/v1/login"} className="nav-link">
                Login
              </Link>
            </li>
          </ul>
          {/* <span className="navbar-text">Item or button</span> */}
        </div>
      </div>
    </nav>
  );
};

export default Header;
