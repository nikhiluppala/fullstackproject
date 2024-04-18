package net.javaguides.emsbackend.service;

import java.util.List;

import net.javaguides.emsbackend.dto.EmployeeDto;


public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	//get all users
	List<EmployeeDto> getEmployees();
	
	//get employee by id
	EmployeeDto getEmployee(Long id);
	
	//update employee
	EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
	
	//Delete Employee By Id
	void deleteEmployee(Long id);
}
