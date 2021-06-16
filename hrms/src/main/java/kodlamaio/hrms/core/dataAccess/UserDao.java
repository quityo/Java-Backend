package kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.core.entities.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
	User findUserByEmail(String email);
	User getById(int id);
	boolean existsByEmail(String email);
}