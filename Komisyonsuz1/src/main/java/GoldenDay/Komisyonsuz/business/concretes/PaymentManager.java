package GoldenDay.Komisyonsuz.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GoldenDay.Komisyonsuz.business.abstracts.PaymentService;
import GoldenDay.Komisyonsuz.core.results.DataResult;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.core.results.SuccessDataResult;
import GoldenDay.Komisyonsuz.core.results.SuccessResult;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.CreateDayDao;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.PaymentDao;
import GoldenDay.Komisyonsuz.dataAccess.abstracts.UserDao;
import GoldenDay.Komisyonsuz.entites.Dtos.PaymentDto;
import GoldenDay.Komisyonsuz.entites.concretes.CreateDay;
import GoldenDay.Komisyonsuz.entites.concretes.Payment;
import net.bytebuddy.asm.Advice.This;

@Service
public class PaymentManager implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;
	private UserDao userDao;
	private CreateDayDao createDayDao;

	public PaymentManager(PaymentDao paymentDao, UserDao userDao,CreateDayDao createDayDao) {
		super();
		this.paymentDao = paymentDao;
		this.createDayDao = createDayDao;
		this.userDao = userDao;
	}

	@Override
	public Result add(PaymentDto paymentDto) {

		Payment payment = new Payment();
		payment.setId(paymentDto.getId());
		payment.setState(paymentDto.getState());
		payment.setUser(userDao.findById(paymentDto.getUserİd()));
		payment.setCreateDay(createDayDao.getById(paymentDto.getDayId()));
		this.paymentDao.save(payment);
		
		return new SuccessResult("Payment Has Been Added");
	}

	@Override
	public DataResult<List<Payment>> getAll() {

		return new SuccessDataResult<List<Payment>>(this.paymentDao.findAll(), "Payment Data Listed");
	}

	@Override
	public DataResult<Payment> getById(int id) {

		return new SuccessDataResult<>(this.paymentDao.getById(id), "Payment Getirildi");
	}

	@Override
	public DataResult<List<Payment>> findByCreateDay(int id) {
		
	 return new SuccessDataResult<List<Payment>>(this.paymentDao.findByCreateDay_id(id));

	}

	@Override
	public DataResult<List<Payment>> getByuserİd(int id) {
		return new SuccessDataResult<List<Payment>>(this.paymentDao.getByuserİd(id), "Başarılı Şekide Getirildi");
	}

	@Override
	public DataResult<List<Payment>> getByStateTrue() {
		return new SuccessDataResult<List<Payment>>(this.paymentDao.getByStateTrue(),
				"Ödeme Durumu Kabul Edilenler Listelendi");
	}

	

}
