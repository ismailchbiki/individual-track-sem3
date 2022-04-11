import "./App.css";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import { Header } from "./components/Layout/Header";
import { Footer } from "./components/Layout/Footer";
import Error from "./components/ErrorHandling/Error";
import { KiteLessonsList } from "./components/Managing/KiteLessonsList";
import { AddUpdateKiteLesson } from "./components/Managing/AddUpdateKiteLesson";

const App = () => {
  return (
    <div>
      <Router>
        <Header />
        <div className="container">
          <Routes>
            <Route exact path="/" element={<KiteLessonsList />} />
            <Route
              exact
              path="/api/v1/kite-lessons"
              element={<KiteLessonsList />}
            />
            <Route
              path="/api/v1/add-kite-lesson"
              element={<AddUpdateKiteLesson />}
            />
            <Route
              path="/api/v1/update-kite-lesson/:id"
              element={<AddUpdateKiteLesson />}
            />
            <Route path="*" element={<Error />} />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
};

export default App;
