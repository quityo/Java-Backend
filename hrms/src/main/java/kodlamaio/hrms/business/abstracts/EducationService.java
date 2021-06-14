package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	Result add(Education education);
	Result update(Education education);
	Result delete(int id);
	DataResult<Education> getById(int id);	
	DataResult<List<Education>> getAll();
	DataResult<List<Education>> getAllByJobseekerIdOrderByEndAtDesc(int id);
	DataResult<List<Education>> getAllByJobseekerId(int id);}
