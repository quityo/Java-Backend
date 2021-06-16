package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkTimeDao;
import kodlamaio.hrms.entities.concretes.WorkTime;

@Service
public class WorkTimeManager implements WorkTimeService {
	private WorkTimeDao workTimeDao;

    @Autowired
    public WorkTimeManager(WorkTimeDao workTimeDao) {
        this.workTimeDao = workTimeDao;
    }

    @Override
    public DataResult<List<WorkTime>> getAll() {
        return new SuccessDataResult<List<WorkTime>>(workTimeDao.findAll(),"Çalışma Zamanları Listelendi");
    }

    @Override
    public DataResult<WorkTime> getById(int id) {
        return new SuccessDataResult<WorkTime>(workTimeDao.getById(id));
    }

    @Override
    public DataResult<WorkTime> add(WorkTime workTime) {
        return new SuccessDataResult<WorkTime>(workTimeDao.save(workTime),"Ekleme Başarılı");
    }
}

