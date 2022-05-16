import { useContext } from "react";
import AuthContext from "../context/AuthProvider";

const useAuth = () => {
  return useContext(AuthContext);
};

export default useAuth;

// Cleaner way (using this custom hook):
// This prevents me from putting Auth inside of the protected routes,
// To keep the routing component clean without any conditional logic and if statments

// now, No need to import useContext and AuthContext from React in every component
