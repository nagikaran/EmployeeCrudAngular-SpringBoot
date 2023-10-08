package com.example.demo.constants;

public interface URLConstants {
	
	final String APPLICATION_BASE_VERSION="/api/v1";
	
	final String EMPLOYEE_URL=APPLICATION_BASE_VERSION+"/employee";
	
	/*url to save the details of the employee*/
	final String SAVE_EMPLOYEE_DETAILS="/saveEmployeeDetails";
	
	/*API to get the list of the data*/
	final String GET_LIST_OF_EMPLOYEE_DETAILS="/getEmployeeData";
	
	final String DELETE_THE_EMPLOYEE_AS_PER_ID="/delete";
}
