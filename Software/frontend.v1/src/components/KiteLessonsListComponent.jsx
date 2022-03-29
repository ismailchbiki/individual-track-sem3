import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import { GetKiteLessons } from "../services/KiteLessonService";

export const KiteLessonsListComponent = () => {
  const [KiteLessons, setKiteLessons] = useState([]);

  useEffect(() => {
    getAllKiteLessons();
  }, []);

  const getAllKiteLessons = () => {
    GetKiteLessons()
      .then((response) => {
        setKiteLessons(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteKiteLesson = (id) => {
    deleteKiteLesson(id)
      .then((response) => {
        getAllKiteLessons();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <h2 className="text-center">Kite Lessons List</h2>
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
          {KiteLessons.map((lesson) => (
            <tr key={lesson.id}>
              <td>{lesson.id}</td>
              <td>{lesson.type}</td>
              <td>{lesson.persons}</td>
              <td>{lesson.hours}</td>
              <td>{lesson.price}</td>
              <td>
                <Link
                  className="btn btn-info"
                  to={`/edit-kite_lesson/${lesson.id}`}
                >
                  Update
                </Link>
                <button
                  className="btn btn-danger "
                  onClick={() => {
                    deleteKiteLesson(lesson.id);
                  }}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};
