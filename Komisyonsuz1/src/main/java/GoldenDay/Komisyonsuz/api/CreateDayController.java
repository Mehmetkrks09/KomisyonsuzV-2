package GoldenDay.Komisyonsuz.api;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import GoldenDay.Komisyonsuz.business.abstracts.CreateDayService;
import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.entites.Dtos.CreateDayDto;
import GoldenDay.Komisyonsuz.entites.concretes.CreateDay;


@CrossOrigin
@RestController
@RequestMapping("/api/createDay")

public class CreateDayController {

	private CreateDayService createDayService;

	@Autowired
	public CreateDayController(CreateDayService createDayService) {
		
		this.createDayService = createDayService;
	}

	@GetMapping("/getall")
	public DataResult<List<CreateDay>> getAll() {
		return this.createDayService.getAll();
	}
	
	@GetMapping("/getByMonth")
	public DataResult<List<CreateDay>> getByMonth(@RequestParam int id) {
		return this.createDayService.getByMonth(id);
	}
	
	@GetMapping("/getByuserId")
	public DataResult<CreateDay> getByuserId(@RequestParam int id) {
		return this.createDayService.getByuserId(id);
	}
	 
	@GetMapping("/getById")
	public DataResult< CreateDay>getById(@RequestParam int id) {
		
		return this.createDayService.getById(id);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateDayDto createDayDto) {
	
	return this.createDayService.add(createDayDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
	
	return this.createDayService.delete(id);
	}
	
	
	@PutMapping("/UpdateCreateDay")
	public Result UpdateDay(CreateDayDto createDayDto ) {
		
		return this.createDayService.update(createDayDto);
	}
	
	
	

}
