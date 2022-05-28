import {useNavigate} from "react-router-dom";

const UnauthorizedAccess = () => {
    const navigate = useNavigate();
    const goBack = () => navigate(-1);

    return (
        <div>
            <h1
                style={{
                    marginTop: "30px",
                    textAlign: "center",
                    font: "icon",
                    fontSize: "37px",
                }}
            >
                Unauthorized
            </h1>
            <p style={{textAlign: "center", marginTop: "4vh", fontSize: "3vh"}}>
                You are not allowed to access this page
                <br/>
                <button onClick={goBack}>Go Back</button>
            </p>
        </div>
    );
};

export default UnauthorizedAccess;
