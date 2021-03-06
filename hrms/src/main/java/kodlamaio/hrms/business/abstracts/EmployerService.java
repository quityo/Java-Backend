package kodlamaio.hrms.business.abstracts;

import java.util.List;



//import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

//public interface EmployerService extends BaseService<Employer> 

public interface EmployerService {

	Result add(Employer employer);

	DataResult<List<Employer>> getAll();
	DataResult<Employer> getByUserId(int userId);
}