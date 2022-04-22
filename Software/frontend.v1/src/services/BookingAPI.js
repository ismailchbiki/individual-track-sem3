import axios from "axios";

const BOOKING_BASE_REST_API_URL = "http://localhost:8000/kite-lessons";

export const GetBooking = () => {
  return axios.get(BOOKING_BASE_REST_API_URL);
};

export const makeBooking = (booking) => {
  return axios.post(BOOKING_BASE_REST_API_URL, booking);
};

export const getBookingById = (id) => {
  return axios.get(BOOKING_BASE_REST_API_URL + "/" + id);
};

export const updateBooking = (id, booking) => {
  return axios.put(BOOKING_BASE_REST_API_URL + "/" + id, booking);
};

export const deleteBooking = (id) => {
  return axios.delete(BOOKING_BASE_REST_API_URL + "/" + id);
};
