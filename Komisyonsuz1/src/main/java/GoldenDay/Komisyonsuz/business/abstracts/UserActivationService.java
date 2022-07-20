package GoldenDay.Komisyonsuz.business.abstracts;

import GoldenDay.Komisyonsuz.core.results.Result;

public interface UserActivationService {

	Result userActivation(String email);
}
