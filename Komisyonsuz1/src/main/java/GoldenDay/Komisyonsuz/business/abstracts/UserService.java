package GoldenDay.Komisyonsuz.business.abstracts;

import java.io.IOException; 
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.entites.Dtos.UserDto;
import GoldenDay.Komisyonsuz.entites.concretes.User;

public interface UserService {

	Result add(UserDto userDto);
	Result delete(int id);
	DataResult<User> imageUpload(int userId, MultipartFile multipartFile) throws IOException;
	Result  update(UserDto  userUpdate);
	DataResult<List<User>> getAll();
	DataResult< User> findById(int id);
	//DataResult<List<User>> getByNameAndCreateDay_id(String name ,int id);
	DataResult<List<User>> getByCreateDay_id(int id);
	
    DataResult<List< User>> findByName(String name);
	
}
