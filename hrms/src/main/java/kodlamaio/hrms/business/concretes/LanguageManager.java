package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.helpers.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{

	 private LanguageDao languageDao;
	    private DtoConverterService dtoConverterService;

	    @Autowired
	    public LanguageManager(LanguageDao languageDao,DtoConverterService dtoConverterService) {
	        this.languageDao = languageDao;
	        this.dtoConverterService = dtoConverterService;
	    }

	    @Override
	    public DataResult<LanguageDto> add(LanguageDto languageDto) {
	        this.languageDao.save((Language) dtoConverterService.dtoClassConverter(languageDto, Language.class));
	        return new SuccessDataResult<LanguageDto>(languageDto, "Dil Eklendi");
	    }

	
	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	
}
