import React, { Component } from "react";
import { GetKiteLessons } from "../services/KiteLessonService";

class ListKiteLessonsComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      KiteLessons: [],
    };
  }
  /* Every component must have a render() method which returns HTML */
  componentDidMount() {
    /* called immediately after a component is mounted */
    GetKiteLessons().then((res) => {
      this.setState({ KiteLessons: res.data });
    });
  }
  render() {
    return (
      <div>
        <h2 className="text-center">KiteLessons List</h2>
        <div className="row">
          <table className="table table-striped table-bordered">
            {/* Table Header */}
            <thead>
              <tr>
                <th> Kite Lesson Type</th>
                <th> Kite Lesson Hours</th>
                <th> Kite Lesson Persons</th>
                <th> Kite Lesson Price</th>
              </tr>
            </thead>

            {/* Table Body */}
            <tbody>
              {this.state.KiteLessons.map((KiteLessons) => (
                <tr key={KiteLessons.type}>
                  <td>{KiteLessons.type}</td>
                  <td>{KiteLessons.hours}</td>
                  <td>{KiteLessons.people}</td>
                  <td>{KiteLessons.price}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListKiteLessonsComponent;
