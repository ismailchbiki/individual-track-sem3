import React, { useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import "./Navbar.css";

const Header = () => {
  const [active, setActive] = useState("nav__menu");
  const [icon, setIcon] = useState("nav__toggler");
  const navigate = useNavigate();

  const navToggle = () => {
    if (active === "nav__menu") {
      setActive("nav__menu nav__active");
    } else setActive("nav__menu");

    // Icon Toggler
    if (icon === "nav__toggler") {
      setIcon("nav__toggler toggle");
    } else setIcon("nav__toggler");
  };
  return (
    <nav className="nav">
      <Link to="/">Kitesurf experience</Link>

      <ul className={active}>
        <Link to="/">Home</Link>

        <Link to="/api/v1/book">Book</Link>
        <Link to="/api/v1/kite-lessons">Admin</Link>

        <Link to="/">About</Link>
        <Link to="/">Contact</Link>
      </ul>
      <div onClick={navToggle} className={icon}>
        <div className="line1"></div>
        <div className="line2"></div>
        <div className="line3"></div>
      </div>
    </nav>
  );
};

export default Header;
