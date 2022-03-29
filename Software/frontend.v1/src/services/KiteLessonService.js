import axios from "axios";

const EMPLOYEE_BASE_REST_API_URL = "http://localhost:8080/api/v1/kitelessons";

export const GetKiteLessons = () => {
  return axios.get(EMPLOYEE_BASE_REST_API_URL);
};

export const createKiteLesson = (kiteLesson) => {
  return axios.post(EMPLOYEE_BASE_REST_API_URL, kiteLesson);
};

export const getKiteLessonById = (id) => {
  return axios.get(EMPLOYEE_BASE_REST_API_URL + "/" + id);
};

export const updateKiteLesson = (id, kiteLesson) => {
  return axios.put(EMPLOYEE_BASE_REST_API_URL + "/" + id, kiteLesson);
};

export const deleteEmployee = (id) => {
  return axios.delete(EMPLOYEE_BASE_REST_API_URL + "/" + id);
};
