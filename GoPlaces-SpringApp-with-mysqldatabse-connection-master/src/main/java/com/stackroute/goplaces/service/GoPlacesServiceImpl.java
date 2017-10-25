package com.stackroute.goplaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stackroute.goplaces.domain.Places;
import com.stackroute.goplaces.repository.Goplacesrepository;
@Component
public class GoPlacesServiceImpl implements GoPlacesService
{

	@Autowired
	Goplacesrepository goplacesrepository;
	
	@Override
	public String create(Places places) {
		
	goplacesrepository.save(places);
		return "Places saved Successfully";
	}

	@Override
	public Places update(Places places) {
		Places update = goplacesrepository.save(places);
		return update;
	}

	@Override
	public String delete(Places places) {
		 goplacesrepository.delete(places);
		return "Data deleted Successfi=ully";
	}

	@Override
	public List<Places> getAllPlaces() {
		
		
		return (List<Places>) goplacesrepository.findAll();
	}

	
}
