package com.stackroute.goplaces.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.goplaces.domain.Places;
@Repository
public interface Goplacesrepository extends CrudRepository<Places,Integer>
{

}
