package com.stackroute.goplaces.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.goplaces.domain.Places;
@Service
public interface GoPlacesService 
{
	
	public String create(Places places);
	public Places update(Places places);
	public String delete(Places places);
	public List<Places> getAllPlaces();

}
