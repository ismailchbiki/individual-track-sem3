import axios from "axios";

const USER_BASE_REST_API_URL = "http://localhost:8080/users";

export const getUsers = () => {
  return axios.get(USER_BASE_REST_API_URL + "/users");
};

export const createUser = (newUser) => {
  return axios.post(USER_BASE_REST_API_URL + "/user/save", newUser);
};

export const addRoleToUser = (userRole) => {
  return axios.post(USER_BASE_REST_API_URL + "/role/add-to-user", userRole);
};

export const loginUser = (user) => {
  const params = new URLSearchParams();

  params.append("username", user.username);
  params.append("password", user.password);

  return axios.post(USER_BASE_REST_API_URL + "/user/login", params);
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
