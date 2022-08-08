package GoldenDay.Komisyonsuz.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import GoldenDay.Komisyonsuz.entites.concretes.User;

public interface UserDao extends JpaRepository<User,Integer> {

	User findById(int id);
	boolean existsByemail(String email);
	boolean existsByidentityNumber(String identityNumber);
	List<User> getById(int id);
	//List<User> getByCreateDay_id(int id);
	//User findByCreateDay_id(int id);
	List<User> findByName(String name);
//	User getByName(String name);
	User findByEmail(String mail);
}
 