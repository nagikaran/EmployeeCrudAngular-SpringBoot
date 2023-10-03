package com.example.demo.serviceinterface;

import org.springframework.http.ResponseEntity;
import com.example.demo.dto.EmployeeDTO;

public interface EmployeeServiceIn {

	ResponseEntity<String> saveEmployeeDetails(EmployeeDTO employDto);
}
