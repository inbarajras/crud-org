package com.opts.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opts.crud.dao.UserAccountRespository;
import com.opts.crud.entity.UserAccount;

@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRespository userAccountRespository;
	

	public void save(UserAccount user) {
		userAccountRespository.save(user);
	}

	public void deleteUser(Long id) {
		userAccountRespository.deleteById(id);
	}

}
