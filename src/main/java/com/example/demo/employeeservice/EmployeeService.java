package com.example.demo.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.SuccessMessage;
import com.example.demo.dto.Employee01DTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.employeerepository.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.serviceinterface.EmployeeServiceIn;
@Service
public class EmployeeService implements EmployeeServiceIn {
	
	@Autowired EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<String> saveEmployeeDetails(EmployeeDTO employDto) {
		// TODO Auto-generated method stub
		 try {
	            Employee dtoToEmployeeClass = dtoToEmployeeClass(employDto);
	            System.out.println(dtoToEmployeeClass.getCompany()+" : "+dtoToEmployeeClass.getDob()+" : "+dtoToEmployeeClass.getEducation()+" : "+dtoToEmployeeClass.getEmail()+" : "+dtoToEmployeeClass.getExperience()+" : "+dtoToEmployeeClass.getFirstName()+" : "+dtoToEmployeeClass.getGender()+" : "+
	            dtoToEmployeeClass.getLastName()+" : "+dtoToEmployeeClass.getAnnualPackage());
	            employeeRepository.saveEmployeeDetails(
	                dtoToEmployeeClass.getCompany(),
	                dtoToEmployeeClass.getDob(),
	                dtoToEmployeeClass.getEducation(),
	                dtoToEmployeeClass.getEmail(),
	                dtoToEmployeeClass.getExperience(),
	                dtoToEmployeeClass.getFirstName(),
	                dtoToEmployeeClass.getGender(),
	                dtoToEmployeeClass.getLastName(),
	                dtoToEmployeeClass.getAnnualPackage()
	            );
	            // If the data is saved successfully, return a success response
	            return ResponseEntity.status(HttpStatus.OK).body(SuccessMessage.DATA_SAVED_SUCCESSFULLY);
	        } catch (Exception e) {
	            // Handle the exception and return a failure response
	        	e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessage.SERVER_SIDE_ERROR_WHILE_SAVING_THE_DATA + e.getMessage());
	        }
	}
	
	/*create the methods to create the dto to the entity and the entity to the dto*/
	private Employee dtoToEmployeeClass(EmployeeDTO dto) {
		ModelMapper mm = new ModelMapper();
		return mm.map(dto, Employee.class);
	}

	private EmployeeDTO entityToMoviesClassDto(Employee entity) {
		ModelMapper mm = new ModelMapper();
		return mm.map(entity, EmployeeDTO.class);
	}

	

}
