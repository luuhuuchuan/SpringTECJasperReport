package com.ck.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ck.domain.App_users;;

@Repository
public interface UserRepository extends CrudRepository<App_users, Integer> {
	
	App_users findByUsername(String username);
	
}
