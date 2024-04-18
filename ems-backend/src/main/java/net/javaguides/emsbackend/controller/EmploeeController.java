package net.javaguides.emsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmploeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//get all users
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> listOfEmployees = employeeService.getEmployees();
		return new ResponseEntity<>(listOfEmployees, HttpStatus.OK);
	}
	
	//get user by id
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeId(@PathVariable("id") Long id){
		return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable("id") Long id,@RequestBody EmployeeDto updatedEmployeeDto){
		EmployeeDto employeeDto =  employeeService.updateEmployee(id, updatedEmployeeDto);
		return ResponseEntity.ok(employeeDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee with "+id+" deleted successfully",HttpStatus.OK);
	}
}
