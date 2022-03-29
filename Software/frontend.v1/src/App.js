import "./App.css";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { HeaderComponent } from "./components/HeaderComponent";
import { FooterComponent } from "./components/FooterComponent";
import ErrorComponent from "./components/ErrorComponent";
import { KiteLessonsListComponent } from "./components/KiteLessonsListComponent";
import { AddUpdateKiteLessonComponent } from "./components/AddUpdateKiteLessonComponent";

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
            <Route
              path="/api/v1/add-kite-lesson"
              element={<AddUpdateKiteLessonComponent />}
            />
            <Route
              path="/api/v1/update-kite-lesson/:id"
              element={<AddUpdateKiteLessonComponent />}
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
