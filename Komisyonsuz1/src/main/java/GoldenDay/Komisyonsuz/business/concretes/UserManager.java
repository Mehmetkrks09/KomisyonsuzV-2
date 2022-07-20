package GoldenDay.Komisyonsuz.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import GoldenDay.Komisyonsuz.Service.ImageService;
import GoldenDay.Komisyonsuz.business.abstracts.UserActivationService;
import GoldenDay.Komisyonsuz.business.abstracts.UserCheckService;
import GoldenDay.Komisyonsuz.business.abstracts.UserService;
import GoldenDay.Komisyonsuz.core.abstracts.ValidatorService;
import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.ErrorResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.core.results.SuccessDataResult;
import GoldenDay.Komisyonsuz.core.results.SuccessResult;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.CreateDayDao;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.PaymentDao;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.UserDao;
import GoldenDay.Komisyonsuz.entites.Dtos.UserDto;
import GoldenDay.Komisyonsuz.entites.concretes.CreateDay;
import GoldenDay.Komisyonsuz.entites.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private ImageService ımageService;
	private UserCheckService userCheckService;
	private ValidatorService validatorService;
	private UserActivationService userActivationService;
	private CreateDayDao createDayDao;
	private PaymentDao paymentDao;

	@Autowired
	public UserManager(UserDao userDao, ImageService ımageService, UserCheckService userCheckService,
			ValidatorService validatorService, UserActivationService userActivationService, CreateDayDao createDayDao,
			PaymentDao paymentDao) {
		super();
		this.userDao = userDao;
		this.ımageService = ımageService;
		this.userCheckService = userCheckService;
		this.validatorService = validatorService;
		this.userActivationService = userActivationService;
		this.createDayDao = createDayDao;
		this.paymentDao = paymentDao;
	}

	@Override
	public Result add(UserDto userDto) {

		if (!isAllFieldsFilled(userDto)) {
			return new ErrorResult("Bütün alanları doldurunuz");

		}
		if (!userCheckService.isValidEMail(userDto.getEmail())) {
			return new ErrorResult(" mail de Karakter kurallarına uyunuz");
		}
		if (userDao.existsByemail(userDto.getEmail())) {
			return new ErrorResult(userDto.getEmail() + " Maili Sistemde kayıtlı ");

		}

		if (userCheckService.isPasswordOk(userDto.getPassword())) {
			return new ErrorResult(" Şifre de Karakter kurallarına uyunuz");
		}

		if (userCheckService.isFirstNameOk(userDto.getName())) {
			return new ErrorResult(" İsim  Karakter kurallarına uyunuz");
		}

		if (userCheckService.isLastNameOk(userDto.getSurName())) {
			return new ErrorResult(" Soyadı Karakter kurallarına uyunuz");
		}

		if (userDao.existsByidentityNumber(userDto.getIdentityNumber())) {
			return new ErrorResult(userDto.getIdentityNumber() + " Tc no Sistemde Kayıtlı");
		} else {
			validatorService.sendVerificationMail(userDto.getEmail());
			userActivationService.userActivation(userDto.getEmail());

			User user = new User();
			user.setId(userDto.getId());
			user.setName(userDto.getName());
			user.setSurName(userDto.getSurName());
			user.setAdress(userDto.getAdress());
			user.setBirtOfDate(userDto.getBirtOfDate());
			user.setEmail(userDto.getEmail());
			user.setIdentityNumber(userDto.getIdentityNumber());
			user.setPassword(userDto.getPassword());
			user.setPhoto(userDto.getPhoto());
			user.setCreateDay(createDayDao.getById(userDto.getDayId()));
			user.setPayment(paymentDao.findById(userDto.getPaymentId()));

			this.userDao.save(user);

			return new SuccessResult("User Has Been Added!");

		}
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users Listed");
	}

	@Override
	public DataResult<User> findById(int id) {
		return new SuccessDataResult<User>(this.userDao.findById(id), "User getirildi");
	}

	@Override
	public Result delete(int id) {

		User user = new User();
		user.setId(id);
		this.userDao.delete(user);
		return new SuccessResult("User Has Been Deleted");
	}

	@Override
	public Result update(UserDto userUpdate) {
		User user = this.userDao.findById(userUpdate.getId());
//       if(user.getEmail()!="")
//       {
//		if (userCheckService.isValidEMail(userUpdate.getEmail())) {
//			return new ErrorResult(" mail de Karakter kurallarına uyunuz");
//		}
//		if (userDao.existsByemail(userUpdate.getEmail())) {
//			return new ErrorResult(userUpdate.getEmail() + " Sistemde kayıtlı ");
//
//		} 
//       }
     

		user.setAdress(userUpdate.getAdress());

		user.setEmail(userUpdate.getEmail());

		user.setPassword(userUpdate.getPassword());
		
		user.setPhoto(userUpdate.getPhoto());
		
		user.setCreateDay(createDayDao.getById(userUpdate.getDayId()));
		
		user.setPayment(paymentDao.findById(userUpdate.getPaymentId()));
		
		this.userDao.save(user);
		return new SuccessResult("Başarıyla Güncellendi");

	}

	@Override
	public DataResult<User> imageUpload(int userId, MultipartFile multipartFile) throws IOException {
		User user = this.userDao.findById(userId);
		var result = this.ımageService.uploadImageFile(multipartFile);
		user.setPhoto(result.getData().get("url").toString());
		this.userDao.save(user);
		return new SuccessDataResult<>("Fotoğrafınız başarıyla kaydedildi.");
	}
	
	
	
	@Override
	public DataResult<List<User>> getByCreateDay_id(int id) {

      return new SuccessDataResult<List<User>>(this.userDao.getByCreateDay_id( id),"Başarıyla Listelendi");
	}

	
	@Override
	public DataResult<User> findByName(String name) {

     return new SuccessDataResult<User>(this.userDao.findByName(name));
	}
	
	
	
	// ------------------------------Validation--------------------------------------------------------------------------------------
	public boolean isAllFieldsFilled(UserDto user) {

		if (user.getName() == "" || user.getEmail() == "" || user.getSurName() == "" || user.getIdentityNumber() == ""
				|| user.getPassword() == "") {
			return false;
		}

		return true;
	}

	

	

}
