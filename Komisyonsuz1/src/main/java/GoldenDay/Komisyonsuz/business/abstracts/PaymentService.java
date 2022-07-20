package GoldenDay.Komisyonsuz.business.abstracts;

import java.util.List; 

import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.entites.Dtos.PaymentDto;
import GoldenDay.Komisyonsuz.entites.concretes.Payment;

public interface PaymentService {

	Result add(PaymentDto paymentDto);
	DataResult<List<Payment>> getAll();
	DataResult< Payment> getById(int id);

	
	
	DataResult<List<Payment>> findByCreateDay(int id); 
	DataResult<List<Payment>> getByuserİd(int id);
	DataResult<List<Payment>> getByStateTrue();
}
	

