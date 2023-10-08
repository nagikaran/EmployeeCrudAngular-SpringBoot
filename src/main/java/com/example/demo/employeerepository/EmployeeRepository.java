package com.example.demo.employeerepository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	 @Modifying
	@Query(value="INSERT INTO employee(company,dob,education,email,experience,first_name,gender,last_name,annual_package)"
			+ "values(:company,:dob,:education,:email,:experience,:first_name,:gender,:last_name,:annual_package)",nativeQuery = true)
	 @Transactional
	void saveEmployeeDetails(@Param("company") String company,@Param("dob") Date dob,@Param("education") String education,@Param("email") String email,
			@Param("experience") int experience,@Param("first_name") String first_name,@Param("gender") String gender,
			@Param("last_name") String last_name,@Param("annual_package") int annual_package);

	 @Query(value = "SELECT * FROM employee",nativeQuery = true)
	List<Employee> getAllEmployeeData();
	
}
