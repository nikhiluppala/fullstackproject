package net.javaguides.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.emsbackend.dto.EmployeeDto;
import net.javaguides.emsbackend.entity.Employee;
import net.javaguides.emsbackend.exception.ResourceNotFoundException;
import net.javaguides.emsbackend.mapper.EmployeeMapper;
import net.javaguides.emsbackend.repository.EmployeerRepository;
import net.javaguides.emsbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeerRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public List<EmployeeDto> getEmployees() {
		List<Employee> listOfEmployees = employeeRepository.findAll();
		
		return listOfEmployees.stream().map(emp -> EmployeeMapper.mapToEmployeeDto(emp)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not found with Id : " + id));
		
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployeeDto) {
		
		Employee employee =  employeeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found with Id : " + id));
		
		
		employee.setFirstName(updatedEmployeeDto.getFirstName());
		employee.setLastName(updatedEmployeeDto.getLastName());
		employee.setEmail(updatedEmployeeDto.getEmail());
		
		Employee updatedEmployeeObj = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long id) {
		
		employeeRepository.deleteById(id);;
	}

}
