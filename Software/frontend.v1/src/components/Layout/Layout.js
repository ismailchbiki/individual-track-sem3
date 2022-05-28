import {Outlet} from "react-router-dom";

const Layout = () => {
    return (
        <main className="App">
            {/* Outlet component represents all the children of the layout components.
      Anything nested inside the layout component is represented by the Outlet */}
            <Outlet/>
        </main>
    );
};

export default Layout;
