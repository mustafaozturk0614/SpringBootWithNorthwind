package com.kodlamaio.springboot.business.abstracts;

import com.kodlamaio.springboot.core.entities.User;
import com.kodlamaio.springboot.core.utilities.results.DataResult;
import com.kodlamaio.springboot.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	
	DataResult<User> findByEmail(String email);
	
}
