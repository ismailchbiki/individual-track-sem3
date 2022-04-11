import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/Layout/Header";
import Homepage from "./components/Layout/Homepage";
import { Footer } from "./components/Layout/Footer";
import Error from "./components/ErrorHandling/Error";
import { KiteLessonsList } from "./components/Admin/KiteLessonsList";
import { AddUpdateKiteLesson } from "./components/Admin/AddUpdateKiteLesson";
import Book from "./components/Booking/Book";

const App = () => {
  return (
    <div>
      <Router>
        <Header />
        <div className="container">
          <Routes>
            <Route exact path="/" element={<Homepage />} />
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
            <Route path="/api/v1/book" element={<Book />} />
            <Route path="*" element={<Error />} />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
};

export default App;
