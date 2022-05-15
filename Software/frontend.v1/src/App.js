import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/layout/Header";
import Homepage from "./components/layout/Homepage";
import { Footer } from "./components/layout/Footer";
import Error from "./components/errorHandling/Error";
import { KiteLessonsList } from "./components/admin/KiteLessonsList";
import { AddUpdateKiteLesson } from "./components/admin/AddUpdateKiteLesson";
import Book from "./components/booking/Book";
import Register from "./components/register&login/Register";
import Login from "./components/register&login/Login";

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
            <Route path="/api/v1/register" element={<Register />} />
            <Route path="/api/v1/login" element={<Login />} />
            <Route path="*" element={<Error />} />
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
};

export default App;
