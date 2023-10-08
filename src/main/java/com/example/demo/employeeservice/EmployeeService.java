package com.example.demo.employeeservice;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.constants.ErrorMessage;
import com.example.demo.constants.SuccessMessage;
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
	           int experience=0;int annualpacKage=0;
	            if(dtoToEmployeeClass.getExperience()!=null && dtoToEmployeeClass.getAnnualPackage()!=null) {
	            	experience=dtoToEmployeeClass.getExperience();
	            	annualpacKage=dtoToEmployeeClass.getAnnualPackage();
	            }
	            if(        dtoToEmployeeClass.getFirstName()!=null 
	            		&& !dtoToEmployeeClass.getFirstName().trim().equals("")
	            		&& dtoToEmployeeClass.getCompany()!=null 
	            		&& !dtoToEmployeeClass.getCompany().trim().equals("")
	            		&& dtoToEmployeeClass.getDob()!=null 
	            		&& dtoToEmployeeClass.getEducation()!=null 
	            		&& !dtoToEmployeeClass.getEducation().trim().equals("")
	            		&& dtoToEmployeeClass.getEmail()!=null 
	            		&& !dtoToEmployeeClass.getEmail().trim().equals("") 
	            		&& !dtoToEmployeeClass.getLastName().trim().equals("")
	            		&& dtoToEmployeeClass.getLastName()!=null 
	            		&& !dtoToEmployeeClass.getGender().trim().equals("")
	            		&& dtoToEmployeeClass.getGender()!=null
	            		&& dtoToEmployeeClass.getExperience()!=null
	            		&& dtoToEmployeeClass.getExperience()!=0
	            		&& dtoToEmployeeClass.getAnnualPackage()!=null
	            		&& dtoToEmployeeClass.getAnnualPackage()!=0) {
	                        employeeRepository.saveEmployeeDetails(
	    	                dtoToEmployeeClass.getCompany(),
	    	                dtoToEmployeeClass.getDob(),
	    	                dtoToEmployeeClass.getEducation(),
	    	                dtoToEmployeeClass.getEmail(),
	    	                experience,
	    	                dtoToEmployeeClass.getFirstName(),
	    	                dtoToEmployeeClass.getGender(),
	    	                dtoToEmployeeClass.getLastName(),
	    	                annualpacKage
	    	            );
	    	            // If the data is saved successfully, return a success response
	    	            return ResponseEntity.status(HttpStatus.OK).body(SuccessMessage.DATA_SAVED_SUCCESSFULLY);
	            }
	            else {
	            	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorMessage.SOMETHING_WENT_WRONG_WHILE_SAVING_THE_DATA);
	            }
	            	
	       
	        } catch (Exception e) {
	            // Handle the exception and return a failure response
	        	e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorMessage.SERVER_SIDE_ERROR_WHILE_SAVING_THE_DATA + e.getMessage());
	        }
	}
	@Override
	public List<EmployeeDTO> getAllEmployeeData() {
		// TODO Auto-generated method stub
		List<Employee> allEmployeeData = employeeRepository.getAllEmployeeData();
		List<EmployeeDTO> listOfEmployeeData = allEmployeeData.stream().map((entity)->entityToMoviesClassDto(entity)).collect(Collectors.toList());
		return listOfEmployeeData;
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
	
	
	@Override
	public boolean deleteEmployee(Integer employeeId) {
	    return employeeRepository.findById(employeeId)
	            .map(employee -> {
	                employeeRepository.delete(employee);
	                return true;
	            })
	            .orElse(false);
	}

	

	

}
