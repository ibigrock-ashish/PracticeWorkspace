package com.wipro.SpringRest.repository;

import org.springframework.data.repository.CrudRepository;

import com.wipro.SpringRest.domain.User;



public interface UserRepository  extends CrudRepository<User, Integer>{
 


}
