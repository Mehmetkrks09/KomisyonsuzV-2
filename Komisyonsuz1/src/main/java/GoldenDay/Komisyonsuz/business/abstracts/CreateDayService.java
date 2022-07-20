package GoldenDay.Komisyonsuz.business.abstracts;

import java.util.List ;

import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.entites.Dtos.CreateDayDto;
import GoldenDay.Komisyonsuz.entites.concretes.CreateDay;


public interface CreateDayService {

	Result add(CreateDayDto createDayDto);
	Result delete(int id);
	Result update(CreateDayDto createDayUpdate);
	DataResult<List<CreateDay>> getAll();
	DataResult< CreateDay> getById(int id);

	
	DataResult<List<CreateDay>> getByMonth(int id);
	DataResult<List<CreateDay>> getByUserId(int id);
	

}
 