package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.SuccessMessage;
import com.example.demo.constants.URLConstants;
import com.example.demo.dto.Employee01DTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.serviceinterface.EmployeeServiceIn;

@RestController
@RequestMapping(value = URLConstants.EMPLOYEE_URL)
public class EmployeeController {
	
	@Autowired EmployeeServiceIn employeeServiceIn;
	
	@PostMapping(value=URLConstants.SAVE_EMPLOYEE_DETAILS)
    public ResponseEntity<String> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        ResponseEntity<String> response;
        try {
            ResponseEntity<String> result = employeeServiceIn.saveEmployeeDetails(employeeDTO);
            System.out.println("the value of the status code "+result.getStatusCodeValue());
            // Check if the result indicates success
            if (result.getStatusCode() == HttpStatus.OK) {
                response = ResponseEntity.status(HttpStatus.CREATED).body(SuccessMessage.DATA_SAVED_SUCCESSFULLY);
            } else {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessage.SOMETHING_WENT_WRONG_WHILE_SAVING_THE_DATA);
            }
        } catch (Exception e) {
            // Handle exceptions and return a failure response
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessage.SERVER_SIDE_ERROR_WHILE_SAVING_THE_DATA + e.getMessage());
        }
        return response;
    }
	

}
