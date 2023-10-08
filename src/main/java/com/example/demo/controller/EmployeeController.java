package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.ApiResponse;
import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.SuccessMessage;
import com.example.demo.constants.URLConstants;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.serviceinterface.EmployeeServiceIn;

@CrossOrigin("*")
@RestController
@RequestMapping(value = URLConstants.EMPLOYEE_URL)
public class EmployeeController {
	
	@Autowired EmployeeServiceIn employeeServiceIn;
	
	 @PostMapping(value = URLConstants.SAVE_EMPLOYEE_DETAILS, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ApiResponse> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
	        ApiResponse response;
	        ResponseEntity<String> result=null;
	        try {
	        	if(employeeDTO!=null) {
	        		result  = employeeServiceIn.saveEmployeeDetails(employeeDTO);
	        	}
	            if (result.getStatusCode() == HttpStatus.OK && result!=null) {
	                response = new ApiResponse(SuccessMessage.DATA_SAVED_SUCCESSFULLY);
	                return ResponseEntity.status(HttpStatus.CREATED).body(response);
	            } else {
	                response = new ApiResponse(ErrorMessage.SOMETHING_WENT_WRONG_WHILE_SAVING_THE_DATA);
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	            }
	        } catch (Exception e) {
	            response = new ApiResponse(ErrorMessage.SERVER_SIDE_ERROR_WHILE_SAVING_THE_DATA + e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }
	 
	 @GetMapping(value = URLConstants.GET_LIST_OF_EMPLOYEE_DETAILS)
	 public ResponseEntity<List<EmployeeDTO>> getAllEmployeeData(){
		 List<EmployeeDTO> allEmployeeData = employeeServiceIn.getAllEmployeeData();
		 return ResponseEntity.ok(allEmployeeData);
		  
		 
	 }
	 
	 @DeleteMapping(value = URLConstants.DELETE_THE_EMPLOYEE_AS_PER_ID + "/{employeeId}",produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Integer employeeId) {
	        boolean deleted = employeeServiceIn.deleteEmployee(employeeId);
	        ApiResponse response;
	        if (deleted) {
	        	response = new ApiResponse(SuccessMessage.EMPLOYEE_DELETED_SUCCESSFULLY);
	            return ResponseEntity.ok(response);
	        } else {
	        	response = new ApiResponse(ErrorMessage.SOMETHING_WENT_WRONG_WHILE_DELETING_THE_DATA);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	    } 
	 
	 
	

}
