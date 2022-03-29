import "./App.css";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { HeaderComponent } from "./components/HeaderComponent";
import { FooterComponent } from "./components/FooterComponent";
import ErrorComponent from "./components/ErrorComponent";
import { KiteLessonsListComponent } from "./components/KiteLessonsListComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route exact path="/" element={<KiteLessonsListComponent />} />
            <Route
              exact
              path="/api/v1/kite-lessons"
              element={<KiteLessonsListComponent />}
            />
            <Route path="*" element={<ErrorComponent />} />
          </Routes>
        </div>
        <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
