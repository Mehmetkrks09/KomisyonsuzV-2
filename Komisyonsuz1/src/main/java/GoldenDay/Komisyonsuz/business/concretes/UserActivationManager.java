package GoldenDay.Komisyonsuz.business.concretes;

import org.springframework.stereotype.Service;

import GoldenDay.Komisyonsuz.business.abstracts.UserActivationService;
import GoldenDay.Komisyonsuz.core.results.Result;
import GoldenDay.Komisyonsuz.core.results.SuccessResult;

@Service
public class UserActivationManager implements UserActivationService{

	@Override
	public Result userActivation(String email) {
		
		
		return new SuccessResult(email+" aktif hale getirildi");
	}

}
