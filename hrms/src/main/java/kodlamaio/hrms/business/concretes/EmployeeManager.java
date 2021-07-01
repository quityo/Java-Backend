package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;
@Service
public class EmployeeManager implements EmployeeService {
    private EmployeeDao employeeDao;
    
    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>( this.employeeDao.findAll(),"Sistem Kullanıcıları Listelendi");
    }
    @Override
	public Result add(EmployeeDto employeeDto) {
		Employee employee = new Employee();

		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPassword(employeeDto.getPassword());

		this.employeeDao.save(employee);
		return new SuccessResult("Sistem Personeli Kayıt Olundu");
	}
    
    @Override
	public Result update(EmployeeDto employeeDto) {
    	Employee employeeToUpdate = this.employeeDao.getByUserId(employeeDto.getUserId());

		employeeToUpdate.setFirstName(employeeDto.getFirstName());
		employeeToUpdate.setLastName(employeeDto.getLastName());
		employeeToUpdate.setEmail(employeeDto.getEmail());

		this.employeeDao.save(employeeToUpdate);
		return new SuccessResult("Sistem Personel Bilgileri Güncellendi");
	}

	@Override
	public DataResult<Employee> getByUserId(int userId) {
		return new SuccessDataResult<Employee>(this.employeeDao.getByUserId(userId));
	}

}