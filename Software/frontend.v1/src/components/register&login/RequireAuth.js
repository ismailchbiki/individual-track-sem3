import {Navigate, Outlet, useLocation} from "react-router-dom";
import UseAuth from "../../hooks/useAuth";

//first version: whether the user is logged in or not
//second version: (comes later) that supports roles
const RequireAuth = ({allowedRoles}) => {
    const {auth} = UseAuth();
    const {location} = useLocation();

    //if the user has the right role -> grant access
    return auth?.payload?.roles?.find((role) => allowedRoles?.includes(role)) ? (
            <Outlet/>
        ) : //else if the user is logged in but doesn't have the role -> don't grant access
        auth?.username ? (
            <Navigate to={"/unauthorized"} state={{from: location}} replace/>
        ) : (
            //else if the user is not logged in -> request user to log in
            <Navigate to="/api/v1/login" state={{from: location}} replace/>
        );
};

export default RequireAuth;
