import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import {
  createKiteLesson,
  getKiteLessonById,
  updateKiteLesson,
} from "../../services/KiteLessonAPI";

export const AddUpdateKiteLesson = () => {
  //fields must match fields from the api (Springboot)
  const [type, setType] = useState("");
  const [persons, setPersons] = useState("");
  const [hours, setHours] = useState("");
  const [price, setPrice] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const saveOrUpdateKiteLesson = (e) => {
    //prevent the page from reloading/refreshing
    e.preventDefault();

    const kiteLesson = { type, persons, hours, price };

    if (id) {
      updateKiteLesson(id, kiteLesson)
        .then((response) => {
          navigate("/api/v1/kite-lessons");
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      createKiteLesson(kiteLesson)
        .then((response) => {
          console.log(response.data);
          navigate("/api/v1/kite-lessons");
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  useEffect(() => {
    getKiteLessonById(id)
      .then((response) => {
        setType(response.data.type);
        setPersons(response.data.persons);
        setHours(response.data.hours);
        setPrice(response.data.price);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  //   const cancel = () => {
  //     navigate("/api/v1/kite-lessons");
  //   };

  const title = () => {
    if (id) {
      return <h2 className="text-center">Update Kite Lesson</h2>;
    } else {
      return <h2 className="text-center">Add Kite Lesson</h2>;
    }
  };

  return (
    <div>
      <br />
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {title()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">Lesson Type :</label>
                  <input
                    type="text"
                    placeholder="Enter Lesson Type"
                    name="type"
                    className="form-control"
                    value={type}
                    onChange={(e) => setType(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">Number of Persons :</label>
                  <input
                    type="number"
                    placeholder="Enter Number of Persons"
                    name="persons"
                    className="form-control"
                    value={persons}
                    onChange={(e) => setPersons(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">Duration :</label>
                  <input
                    type="number"
                    placeholder="Enter Lesson Duration"
                    name="hours"
                    className="form-control"
                    value={hours}
                    onChange={(e) => setHours(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">Price :</label>
                  <input
                    type="number"
                    placeholder="Enter Lesson Price"
                    name="price"
                    className="form-control"
                    value={price}
                    onChange={(e) => setPrice(e.target.value)}
                  ></input>
                </div>

                <button
                  className="btn btn-success"
                  onClick={(e) => saveOrUpdateKiteLesson(e)}
                >
                  Submit
                </button>

                {/* <button onClick={() => cancel()} className="btn btn-danger m-2">
                  Cancel
                </button> */}

                {/* same as previous code */}
                <Link to="/api/v1/kite-lessons" className="btn btn-danger m-2">
                  Cancel
                </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
