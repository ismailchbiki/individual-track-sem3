import "./App.css";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import ListKiteLessonsComponent from "./components/ListKiteLessonsComponent";
import { HeaderComponent } from "./components/HeaderComponent";
import { FooterComponent } from "./components/FooterComponent";
import ErrorComponent from "./components/ErrorComponent";

function App() {
  return (
    <div>
      <Router>
        <HeaderComponent />
        <div className="container">
          <Routes>
            <Route exact path="/" element={<ListKiteLessonsComponent />} />
            <Route
              exact
              path="/api/v1/kite-lessons"
              element={<ListKiteLessonsComponent />}
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
