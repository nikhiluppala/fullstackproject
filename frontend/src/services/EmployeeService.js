import axios from "axios"

const RESR_API_BASE_URL = 'http://localhost:8080/api/employees';

export const listEmployees = () =>  axios.get(RESR_API_BASE_URL);

export const createEmployee = (employee) => axios.post(RESR_API_BASE_URL, employee);

export const getEmployee = (id) => axios.get(RESR_API_BASE_URL + '/' + id);

export const updateEmployee = (id, employee) => axios.put(RESR_API_BASE_URL + "/" + id, employee);

export const deleteEmployee = (id) => axios.delete(RESR_API_BASE_URL + '/' + id);