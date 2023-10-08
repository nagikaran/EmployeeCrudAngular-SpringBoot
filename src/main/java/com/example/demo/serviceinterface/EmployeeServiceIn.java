package com.example.demo.serviceinterface;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.example.demo.dto.EmployeeDTO;

public interface EmployeeServiceIn {

	ResponseEntity<String> saveEmployeeDetails(EmployeeDTO employDto);

	List<EmployeeDTO> getAllEmployeeData();

	boolean deleteEmployee(Integer employeeId);
}
