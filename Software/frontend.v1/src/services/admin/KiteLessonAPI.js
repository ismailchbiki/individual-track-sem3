import axios from "axios";

const KITELESSON_BASE_REST_API_URL =
  "http://localhost:8080/api/v1/kite-lessons";

export const GetKiteLessons = () => {
  return axios.get(KITELESSON_BASE_REST_API_URL);
};

export const createKiteLesson = (kiteLesson) => {
  return axios.post(KITELESSON_BASE_REST_API_URL, kiteLesson);
};

export const getKiteLessonById = (id) => {
  return axios.get(KITELESSON_BASE_REST_API_URL + "/" + id);
};

export const updateKiteLesson = (id, kiteLesson) => {
  return axios.put(KITELESSON_BASE_REST_API_URL + "/" + id, kiteLesson);
};

export const deleteKiteLesson = (id) => {
  return axios.delete(KITELESSON_BASE_REST_API_URL + "/" + id);
};
