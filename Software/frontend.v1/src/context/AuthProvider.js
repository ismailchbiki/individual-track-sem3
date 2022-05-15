//The context is used to provide
import { createContext, useState } from "react";

//An empty object inside create context
const AuthContext = createContext({});

//the components that are going to be nested inside of the auth provider
export const AuthProvider = ({ children }) => {
  const [auth, setAuth] = useState({});

  return (
    <AuthContext.Provider value={{ auth, setAuth }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
