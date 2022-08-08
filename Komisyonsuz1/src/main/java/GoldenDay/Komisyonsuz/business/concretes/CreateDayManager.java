package GoldenDay.Komisyonsuz.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GoldenDay.Komisyonsuz.business.abstracts.CreateDayService;
import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.ErrorDataResult;
import GoldenDay.Komisyonsuz.core.results.ErrorResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.core.results.SuccessDataResult;
import GoldenDay.Komisyonsuz.core.results.SuccessResult;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.CreateDayDao;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.PaymentDao;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.UserDao;
import GoldenDay.Komisyonsuz.entites.Dtos.CreateDayDto;
import GoldenDay.Komisyonsuz.entites.concretes.CreateDay;

@Service
public class CreateDayManager implements CreateDayService {

	@Autowired
	private CreateDayDao createDayDao;
	private PaymentDao paymentDao;
	private UserDao userDao;

	public CreateDayManager(CreateDayDao createDayDao, PaymentDao paymentDao, UserDao userDao) {
		super();
		this.createDayDao = createDayDao;
		this.paymentDao = paymentDao;
		this.userDao = userDao;
	}

	@Override
	public Result add(CreateDayDto createDayDto) {
		
		if(createDayDao.existsByuserId(createDayDto.getUserId()))
		{
			return new ErrorResult("1 Güne Katılabilirsiniz ");
		}
		else {
		
		CreateDay createDay = new CreateDay();
		createDay.setId(createDayDto.getId());

		createDay.setAmount(createDayDto.getAmount());
		createDay.setMonth(createDayDto.getMonth());
		createDay.setUserQueu(createDayDto.getUserQueu());
		createDay.setPayment(paymentDao.findById(createDayDto.getPaymentId()));
		createDay.setUserId(createDayDto.getUserId());
		this.createDayDao.save(createDay);
		return new SuccessResult("Day Has Been Added!");
	}}

	@Override
	public DataResult<List<CreateDay>> getAll() {
		return new SuccessDataResult<>(this.createDayDao.findAll(), "Create day Başarılı Şekilde Listelendi ");
	}

	@Override
	public DataResult<CreateDay> getById(int id) {

		return new SuccessDataResult<CreateDay>(this.createDayDao.getById(id), "Gün Getirildi");
	}

	@Override
	public DataResult<List<CreateDay>> getByMonth(int id) {
		return new SuccessDataResult<List<CreateDay>>(this.createDayDao.getByMonth(id));
	}

	@Override
	public DataResult<CreateDay> getByuserId(int id) {
		 return new  SuccessDataResult<CreateDay>(this.createDayDao.getByuserId(id),"Başarılı Şekilde Getirildi");


	}

	@Override
	public Result delete(int id) {

		CreateDay createDay = new CreateDay();
		createDay.setId(id);
		this.createDayDao.delete(createDay);
		return new SuccessResult("Day Has Been Deleted");

	}

	@Override
	public Result update(CreateDayDto createDayUpdate) {

		CreateDay createDay = new CreateDay();
		createDay.setAmount(createDayUpdate.getAmount());
		createDay.setMonth(createDayUpdate.getMonth());
		createDay.setUserQueu(createDayUpdate.getUserQueu());
		createDay.setPayment(paymentDao.findById(createDayUpdate.getPaymentId()));
	    createDay.setUserId(createDayUpdate.getUserId());
		this.createDayDao.save(createDay);

		return new SuccessResult("Başarıyla Güncellendi");

	}

	

}
