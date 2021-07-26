package com.opts.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.opts.crud.entity.UserAccount;

public interface UserAccountRespository extends CrudRepository<UserAccount, Long>{

}
