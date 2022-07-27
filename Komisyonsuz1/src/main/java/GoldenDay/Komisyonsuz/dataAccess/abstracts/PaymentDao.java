package GoldenDay.Komisyonsuz.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import GoldenDay.Komisyonsuz.entites.concretes.Payment;


public interface PaymentDao  extends JpaRepository<Payment,Integer>{

	Payment getById(int id);
	
	List<Payment> findById(int id); 
	List<Payment> findByCreateDay_id(int id); 
	
	List<Payment> getByuserİd(int id);
	List<Payment> getByStateTrue();
	//List<Payment> getByUser_id();
	
}
 