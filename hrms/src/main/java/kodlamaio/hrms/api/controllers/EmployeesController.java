package kodlamaio.hrms.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
    public DataResult<List<Employee>> getAll() {

        return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EmployeeDto employeeDto) {
		return this.employeeService.add(employeeDto);
	}

	@PutMapping("/update")
	public Result update(@RequestBody EmployeeDto employeeDto) {
		return this.employeeService.update(employeeDto);
	}

	@GetMapping("/getbyuserid")
	public Result getByUserId(@RequestParam int userId) {
		return this.employeeService.getByUserId(userId);
	}
	/*@PostMapping("/add")
    @ApiOperation(value = "ADD Method")
    public ResponseEntity<?> add(@RequestBody @Valid Employee employee) {

        return ResponseEntity.ok(this.employeeService.add(employee));
        
	}
	@PostMapping("/verifyUser")
    @ApiOperation(value = "Verify Method")
    public ResponseEntity<?> verifiedUser(@Valid @RequestParam("id")int employerId,@RequestParam("verified")boolean
    		verified) {

        return ResponseEntity.ok(this.employeeService.verifyEmployer(employerId,verified));


    }
	*/
	
}