package CODES;

import java.util.List;
import java.util.stream.Stream;

public class EmployeeRepository {
	
	private List<Employee> employeetbl;
	
	public EmployeeRepository(List<Employee> employeeTbl) {
		this.employeetbl = employeeTbl;
	}
	
	public List<Employee> getEmployee(){
		return this.employeetbl;
	}

	public Stream<Employee> getEmployeeStream(){
		return this.employeetbl.stream();
	}
}
