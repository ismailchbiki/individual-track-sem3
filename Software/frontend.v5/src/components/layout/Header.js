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
              <Link to={"/book"} className="nav-link">
                Book
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/kite-lessons"} className="nav-link">
                Admin
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/register"} className="nav-link">
                Register
              </Link>
            </li>
            <li className="nav-item"></li>
          </ul>
          <Link to={"/chatroom"} className="nav-link">
            Chatroom
          </Link>
          <Link to={"/login"} className="nav-link">
            Login
          </Link>
          {/* <span className="navbar-text">Item or button</span> */}
        </div>
      </div>
    </nav>
  );
};

export default Header;
