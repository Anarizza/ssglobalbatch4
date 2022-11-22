package CODES.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CODES.Employee;
import CODES.EmployeeRepository;

public class TestEmployeeRepository {
	
	 private EmployeeRepository empRepo;
	
	 @BeforeEach
	public void setup() {
		 Employee emp1 = new Employee(101, "Maria", "Cruz", 50000.0);
		 Employee emp2 = new Employee(102, "Juan", "Luna", 50000.0);
		 
		List<Employee> records = Arrays.asList(emp1, emp2);
		empRepo = new EmployeeRepository(new ArrayList<>(records));
	}
	 
	 @AfterEach
	public void TearDown() {
		empRepo = null;
	}
	
	@Test
	 public void testGetEmployees() {
		 
		 List<Employee> actualRec = empRepo.getEmployee();
		 List<String> expectListNames = Arrays.asList("Clara", "Juan");
		 double ExpectedAvgSalary = 50000.0;
		 
		 assertAll(() -> {
			 assertIterableEquals(expectListNames, actualRec.stream()
					 .map((rec) -> {return rec.firstname();})
					 .collect(Collectors.toList()));
		 }, 
				   () -> {
			assertEquals(ExpectedAvgSalary,  actualRec.stream()
					 .map((rec) -> {return rec.salary();})
					 .mapToDouble(Double::doubleValue)
					 .average()
					 .getAsDouble()); 
		});
		 			
	 }

}
