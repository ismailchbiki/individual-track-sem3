import { useState } from "react";
import { makeBooking } from "../../services/booking/BookingAPI";
import "./styles/Book.css";

function Book() {
  const [form, setForm] = useState();
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");

  const [lessonType, setLessonType] = useState("Private");
  const [hours, setHours] = useState("");
  const [location, setLocation] = useState("");
  const [date, setDate] = useState("");
  const [time, setTime] = useState("");

  const [count, setCount] = useState(1);

  const increment = (e) => {
    e.preventDefault();

    count === 1 && firstName && lastName && email && setCount(count + 1);
    count === 2 && hours && location && setCount(count + 1);
  };

  const processBooking = async (e) => {
    e.preventDefault();

    const booking = {
      firstName,
      lastName,
      email,
      lessonType,
      hours,
      location,
      date,
      time,
    };

    date &&
      time &&
      makeBooking(booking)
        .then((response) => {
          console.log(response.data);
          // navigate("/kite-lessons");

          alert(
            `\nBooking made successfully.\n\nYour booking number: ${response.data.id}`
          );
          setCount(1);
        })
        .catch((error) => {
          console.log(error);
        });
  };

  const updateForm = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <div className="Book">
      <h1>Step {count} of 3</h1>
      <form className="col-4 form">
        {/* Form 1 - contact details */}

        {count === 1 ? (
          <div className="form-group">
            <br />
            <label>First name</label>
            <input
              type="text"
              className="form-control"
              name="firstName"
              onChange={(e) => setFirstName(e.target.value)}
              value={firstName}
            />
            <br />
            <label>Last Name</label>
            <input
              type="text"
              className="form-control"
              name="lastName"
              onChange={(e) => {
                setLastName(e.target.value);
                updateForm();
              }}
              value={lastName}
            />
            <br />
            <label>Email</label>
            <input
              type="email"
              className="form-control"
              name="email"
              onChange={(e) => {
                setEmail(e.target.value);
                updateForm();
              }}
              value={email}
            />
          </div>
        ) : null}

        {/* Form 2 - kite lesson details */}

        {count === 2 ? (
          <div className="form-group">
            <br />
            <label>Type</label>
            <select
              style={{ width: "100%", height: "5vh" }}
              onChange={(e) => {
                setLessonType(e.target.value);
                updateForm();
              }}
              name=""
              id=""
            >
              {lessonType && (
                <option selected value={lessonType}>
                  {lessonType}
                </option>
              )}
              {lessonType !== "Private" && (
                <option value="Private">Private</option>
              )}
              {lessonType !== "Semi-private" && (
                <option value="Semi-private">Semi-private</option>
              )}
              {lessonType !== "Group" && <option value="Group">Group</option>}
            </select>
            <br />

            <br />
            <label>Hours</label>
            <input
              type="number"
              className="form-control"
              name="hours"
              onChange={(e) => {
                setHours(e.target.value);
                updateForm();
              }}
              value={hours}
            />
            <br />

            <label>Location</label>
            <input
              type="text"
              className="form-control"
              name="location"
              onChange={(e) => {
                setLocation(e.target.value);
                updateForm();
              }}
              value={location}
            />
          </div>
        ) : null}

        {/* Form 3 - date and time */}

        {count === 3 ? (
          <div className="form-group">
            <br />
            <label>Date</label>
            <input
              type="date"
              className="form-control"
              name="date"
              onChange={(e) => {
                setDate(e.target.value);
                updateForm();
              }}
              value={date}
            />
            <br />
            <label>Time</label>
            <input
              type="time"
              className="form-control"
              name="time"
              onChange={(e) => {
                setTime(e.target.value);
                updateForm();
              }}
              value={time}
            />
          </div>
        ) : null}
        {count === 3 ? (
          <button
            onClick={(e) => processBooking(e)}
            className="btn btn-primary"
            type="submit"
          >
            Submit
          </button>
        ) : null}
      </form>
      <div style={{ margin: "20px" }}>
        <button
          className="btn btn-dark"
          type="submit"
          onClick={() => setCount(count - 1)}
          disabled={count < 2}
        >
          Back
        </button>
        &nbsp;&nbsp;&nbsp;
        <button
          className="btn btn-light"
          type="submit"
          onClick={(e) => increment(e)}
          disabled={count > 2}
        >
          Next
        </button>
      </div>
    </div>
  );
}

export default Book;
