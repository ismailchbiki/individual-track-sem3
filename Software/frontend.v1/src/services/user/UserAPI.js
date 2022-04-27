import axios from "axios";

const USER_BASE_REST_API_URL = "http://localhost:8080/api/v1";

export const getUsers = () => {
  return axios.get(USER_BASE_REST_API_URL + "/users");
};

export const createUser = (user) => {
  return axios.post(USER_BASE_REST_API_URL + "/user/save", user);
};

export const getUserById = (id) => {
  return axios.get(USER_BASE_REST_API_URL + "/" + id);
};

export const updateUser = (id, user) => {
  return axios.put(USER_BASE_REST_API_URL + "/" + id, user);
};

export const deleteUser = (id) => {
  return axios.delete(USER_BASE_REST_API_URL + "/" + id);
};
