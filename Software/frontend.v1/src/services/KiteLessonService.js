import axios from "axios";

const GetKiteLessons = () => {
  return axios.get("http://localhost:8080/api/v1/kitelessons");
};

export default GetKiteLessons;
