import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/layout/Header";
import Homepage from "./components/layout/Homepage";
import { Footer } from "./components/layout/Footer";
import Error from "./components/errorHandling/Error";
import { KiteLessonsList } from "./components/admin/KiteLessonsList";
import { AddUpdateKiteLesson } from "./components/admin/AddUpdateKiteLesson";
import Book from "./components/booking/Book";
import Register from "./components/register&login/Register";
import Login from "./components/register&login/Login";
import RequireAuth from "./components/register&login/RequireAuth";
import UnauthorizedAccess from "./components/errorHandling/UnauthorizedAccess";
import Layout from "./components/layout/Layout";
import ChatRoom from "./components/chatroom/Chatroom";

const App = () => {
  return (
    <div>
      <Router>
        <Header />
        <div className="container">
          <Routes>
            {/* All the bellow components are inside of the Layout */}
            <Route path="/" element={<Layout />}>
              <Route exact path="/" element={<Homepage />} />

              {/* Protected routes */}
              <Route
                element={
                  <RequireAuth allowedRoles={["SUPER_ADMIN", "ADMIN"]} />
                }
              >
                {/* Manager Route */}
                <Route path="/kite-lessons" element={<KiteLessonsList />} />
              </Route>

              {/* Manager Route */}
              <Route element={<RequireAuth allowedRoles={["SUPER_ADMIN"]} />}>
                <Route
                  path="/add-kite-lesson"
                  element={<AddUpdateKiteLesson />}
                />
              </Route>

              {/* Manager Route */}
              <Route element={<RequireAuth allowedRoles={["SUPER_ADMIN"]} />}>
                <Route
                  path="/update-kite-lesson/:id"
                  element={<AddUpdateKiteLesson />}
                />
              </Route>

              {/* Public routes */}
              <Route path="/book" element={<Book />} />
              <Route path="/register" element={<Register />} />
              <Route path="/login" element={<Login />} />
              <Route path="/chatroom" element={<ChatRoom />} />

              {/* Unauthorized access */}
              <Route path="/unauthorized" element={<UnauthorizedAccess />} />

              {/* Error Page */}
              <Route path="*" element={<Error />} />
            </Route>
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
};

export default App;
