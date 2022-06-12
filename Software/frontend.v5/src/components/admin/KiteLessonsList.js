import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import {
  deleteKiteLesson,
  GetKiteLessons,
} from "../../services/admin/KiteLessonAPI";

export const KiteLessonsList = () => {
  const [KiteLessons, setKiteLessons] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllKiteLessons();
  }, []);

  const getAllKiteLessons = async () => {
    GetKiteLessons()
      .then((response) => {
        setKiteLessons(response.data.kiteLessons);
        console.log(response.data.kiteLessons);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteLesson = async (id) => {
    deleteKiteLesson(id)
      .then(() => {
        getAllKiteLessons();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <h2 className="text-center" style={{ marginTop: "15px" }}>
        Kite Lessons List
      </h2>
      <Link to="/add-kite-lesson" className="btn btn-primary mb-2">
        Add Kite Lesson
      </Link>
      <table className="table table-bordered table-striped">
        {/* Columns' names */}
        <thead>
          <th>Kite Lesson ID</th>
          <th>Kite Lesson Type</th>
          <th>Number of Persons</th>
          <th>Kite Lesson Duration</th>
          <th>Kite Lesson Price</th>
          <th>Actions</th>
        </thead>

        {/* Columns' data */}
        {/* Fields name must have the same names as the Json response from the backend */}
        <tbody>
          {KiteLessons && console.log(KiteLessons.length)}
          {KiteLessons.length >= 1
            ? KiteLessons.map((lesson) => (
                <tr key={lesson.id}>
                  <td>{lesson.id}</td>
                  <td>{lesson.type}</td>
                  <td>{lesson.persons}</td>
                  <td>{lesson.hours}</td>
                  <td>{lesson.price}</td>
                  <td
                    style={{
                      display: "flex",
                      justifyContent: "center",
                      margin: "auto",
                    }}
                  >
                    <button
                      className="btn btn-info"
                      onClick={() =>
                        navigate(`/update-kite-lesson/${lesson.id}`)
                      }
                    >
                      Update
                    </button>
                    <button
                      className="btn btn-danger "
                      onClick={() => {
                        deleteLesson(lesson.id);
                      }}
                      style={{ marginLeft: "10px" }}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))
            : ""}
        </tbody>
      </table>
    </div>
  );
};
