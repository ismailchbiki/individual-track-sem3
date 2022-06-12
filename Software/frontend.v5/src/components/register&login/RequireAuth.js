import { Navigate, Outlet, useLocation } from "react-router-dom";
import UseAuth from "../../hooks/useAuth";

const RequireAuth = ({ allowedRoles }) => {
  const { auth } = UseAuth();
  const { location } = useLocation();

  if (auth?.payload?.roles?.find((role) => allowedRoles?.includes(role))) {
    return <Outlet />;
  }
  return auth?.username ? (
    <Navigate to={"/unauthorized"} state={{ from: location }} replace />
  ) : (
    <Navigate to="/login" state={{ from: location }} replace />
  );
};

export default RequireAuth;
