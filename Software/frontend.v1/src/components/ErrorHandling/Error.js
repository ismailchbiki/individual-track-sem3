import { Link } from "react-router-dom";

const Error = () => {
  return (
    <h2
      style={{
        marginTop: "30px",
        textAlign: "center",
        font: "icon",
        fontSize: "27px",
      }}
    >
      Oups! Deadend. press here to go back to the&nbsp;
      <Link style={{ color: "blue" }} to={"./"}>
        Homepage
      </Link>
      .
    </h2>
  );
};

export default Error;
