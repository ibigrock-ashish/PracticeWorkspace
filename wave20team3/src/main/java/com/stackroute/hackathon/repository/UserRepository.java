package com.stackroute.hackathon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.hackathon.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>
{

}
