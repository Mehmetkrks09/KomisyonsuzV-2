package GoldenDay.Komisyonsuz.api;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import GoldenDay.Komisyonsuz.business.abstracts.UserService;
import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.core.results.SuccessDataResult;
import GoldenDay.Komisyonsuz.entites.Dtos.CreateDayDto;
import GoldenDay.Komisyonsuz.entites.Dtos.UserDto;
import GoldenDay.Komisyonsuz.entites.concretes.User;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll(){
		
		return this.userService.getAll();
	}
	
	@GetMapping("/findById")
	public DataResult<User> findById(@RequestParam int id){
		
		return this.userService.findById(id);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody UserDto user) {

		return this.userService.add(user);
	}
	

	@PutMapping("/UpdateUser")
	public Result UpdateUser(UserDto user ) {
		
		return this.userService.update(user);
	}
	

	
	
	@DeleteMapping("delete")
	public Result delete(@RequestParam int id) {

		return this.userService.delete(id);
	}
	
	@GetMapping("/getByCreateDay_id")
	public DataResult<List<User>> getByCreateDay_id(@RequestParam int id){
		
		return this.userService.getByCreateDay_id(id);
	}
	
	@GetMapping("/findByName")
	public DataResult<User> findByName(String name){
		
		return this.userService.findByName(name);
	}
	
	@PostMapping("/imageUpload")
	public ResponseEntity<?> imageUpload(@RequestParam int userId, @RequestParam MultipartFile multipartFile)
			throws IOException {

		return new ResponseEntity<>(this.userService.imageUpload(userId, multipartFile), HttpStatus.OK);
	}
	
	
	
}
