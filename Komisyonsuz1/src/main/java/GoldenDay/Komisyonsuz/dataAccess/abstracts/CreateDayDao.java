package GoldenDay.Komisyonsuz.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import GoldenDay.Komisyonsuz.entites.concretes.CreateDay;

public interface CreateDayDao extends JpaRepository<CreateDay,Integer>{
	CreateDay getById(int id);
	List<CreateDay> getByMonth(int id);
	CreateDay getByuserId(int id);
	boolean existsByuserId(int id);

}
  