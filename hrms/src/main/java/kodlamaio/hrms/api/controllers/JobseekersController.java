package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobseekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Jobseeker;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/jobseekers")
@CrossOrigin
public class JobseekersController {

	private JobseekerService jobseekerService;

	@Autowired
	public JobseekersController(JobseekerService jobseekerService) {
		super();
		this.jobseekerService = jobseekerService;
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody Jobseeker jobseeker) {
		return this.jobseekerService.add(jobseeker);
	}

	@GetMapping("/getall")
	public DataResult<List<Jobseeker>> getAll() {
		return this.jobseekerService.getAll();
	}
	@GetMapping("/getJobseekerCvByUserId")
	public DataResult<CvDto> getJobseekerCvByUserId(@RequestParam int userId){
		return this.jobseekerService.getJobseekerCvByUserId(userId);
	}
	
	
}