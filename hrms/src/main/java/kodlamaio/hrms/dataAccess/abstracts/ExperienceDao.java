package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Experience;

@Repository
public interface ExperienceDao extends JpaRepository<Experience,Integer>{
	
	List<Experience> findAllByCvIdOrderByEndAtDesc(int cvId);
}