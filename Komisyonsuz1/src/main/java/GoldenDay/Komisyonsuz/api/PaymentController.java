package GoldenDay.Komisyonsuz.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GoldenDay.Komisyonsuz.business.abstracts.PaymentService;
import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.entites.Dtos.PaymentDto;
import GoldenDay.Komisyonsuz.entites.concretes.Payment;

@CrossOrigin
@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	@GetMapping("/getAll")
	public DataResult<List<Payment>> getAll(){
		
		return paymentService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Payment>getById(@RequestParam int id) {
		
		return this.paymentService.getById(id);
	}
	

	@PostMapping("/add")
	public Result add(@RequestBody PaymentDto paymentDto) {
	
	return this.paymentService.add(paymentDto);
	}
	@GetMapping("/findByCreateDay")
	public DataResult<List<Payment>>findByCreateDay(@RequestParam int id) {
		
		return this.paymentService.findByCreateDay(id);
	}
	@GetMapping("/getByuserİd")
	public DataResult<List<Payment>>getByuserİd(@RequestParam int id) {
		
		return this.paymentService.getByuserİd(id);
	}
	@GetMapping("/getByStateTrue")
	public DataResult<List<Payment>>getByStateTrue() {
		
		return this.paymentService.getByStateTrue();
	}
}
