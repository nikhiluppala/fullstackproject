import React, { useEffect, useState } from "react";
import { deleteEmployee, listEmployees } from "../services/EmployeeService";
import { useNavigate, useParams } from "react-router-dom";

const ListEmployeeCompnent = () => {
  
 const [employees, setEmployees] = useState([]);
 const navigator = useNavigate(); 

 useEffect(() => {
    getAllEmployees()
 },[]);

 const getAllEmployees = () => {
  listEmployees().then(res => setEmployees(res.data))
  .catch(err => console.log(err))
 }

 const addNewEmployee = () => {
  navigator('/addEmployee')
 }

 const updateEmployee = (id) => {
  navigator(`/updateEmployee/${id}`)
 }

 const removeEmployee = (id) => {
  deleteEmployee(id).then(res => {
    console.log(res.data);
    getAllEmployees()
  }).catch(err => {
    console.error(err);
  });
 }

  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <button type="button" className="btn btn-primary mb-2" onClick={addNewEmployee}>Add Employee</button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Adress</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((emp) => (
            <tr key={emp.id}>
                <td>{emp.id}</td>
                <td>{emp.firstName}</td>
                <td>{emp.lastName}</td>
                <td>{emp.email}</td>
                <td>
                  <button className="btn btn-info" onClick={() => updateEmployee(emp.id)}>Update</button>
                  <button className="btn btn-danger" onClick={() => removeEmployee(emp.id)}
                    style={{marginLeft: "10px"}}
                  >Delete</button>
                </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeCompnent;
