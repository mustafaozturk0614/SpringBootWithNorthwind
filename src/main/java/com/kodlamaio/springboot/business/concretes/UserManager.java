package com.kodlamaio.springboot.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.springboot.business.abstracts.UserService;
import com.kodlamaio.springboot.core.dataAccess.UserDao;
import com.kodlamaio.springboot.core.entities.User;
import com.kodlamaio.springboot.core.utilities.results.DataResult;
import com.kodlamaio.springboot.core.utilities.results.Result;
import com.kodlamaio.springboot.core.utilities.results.SuccessDataResult;
import com.kodlamaio.springboot.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Kaydedildi");
	}
	
	@Override
	public DataResult<User> findByEmail(String email) {
		
		return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Kullanıcı Bulundu");
	}
	
}
