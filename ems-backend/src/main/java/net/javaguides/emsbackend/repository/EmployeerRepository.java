package net.javaguides.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.emsbackend.entity.Employee;

public interface EmployeerRepository extends JpaRepository<Employee, Long>{

}
