package com.ck.repository;

import org.springframework.data.repository.CrudRepository;

import com.ck.domain.App_roles;;

public interface RoleRepository extends CrudRepository<App_roles, Integer> {

	App_roles findByName(String name);
	
}