package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	Result add(EmployeeDto employeeDto);
	Result update(EmployeeDto employeeDto);

	DataResult<Employee> getByUserId(int userId);
   }
