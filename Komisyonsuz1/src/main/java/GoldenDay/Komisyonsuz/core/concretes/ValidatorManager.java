package GoldenDay.Komisyonsuz.core.concretes;

import org.springframework.stereotype.Service;

import GoldenDay.Komisyonsuz.core.abstracts.ValidatorService;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.core.results.SuccessResult;

@Service
public class ValidatorManager implements ValidatorService {

	@Override
	public Result sendVerificationMail(String email) {

		return new SuccessResult(email +" Doğrulama Linki Gönderildi");
	}

}
