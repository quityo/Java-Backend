package kodlamaio.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvDao;
import kodlamaio.hrms.entities.concretes.Cv;
@Service
public class CvManager implements CvService {

	private CvDao cvDao;

	@Autowired
	public CvManager(CvDao cvDao) {
		this.cvDao = cvDao;
				}
	@Override
	public Result add(Cv cv) {
		var result = this.cvDao.save(cv);
		if (result != null) {
			return new SuccessResult("cv added ok");
		}
		return new ErrorResult("cv added NOT ok");
	}
	

	@Override
	public DataResult<List<Cv>> getAll() {
		var result = this.cvDao.findAll();
		if (result != null) {
			return new SuccessDataResult<List<Cv>>(result,"OK");
		}
		return new ErrorDataResult<List<Cv>>("Not ok");
	}
	
	
	

//	@Override
//	public DataResult<List<CurriculumVitaeDto>> getCurriculumVitaeDetails() {
//		return new SuccessDataResult<List<CurriculumVitaeDto>>(this.curriculumVitaeDao.getCurriculumVitaeDetails());
//	}

}