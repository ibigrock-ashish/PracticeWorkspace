package com.stackroute.goplaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.goplaces.domain.Places;
import com.stackroute.goplaces.service.GoPlacesService;

@RestController
public class GoPlacesController 
{
	@Autowired
	GoPlacesService goplacesservice;
	
	@RequestMapping(method=RequestMethod.GET , value="/getall")
	public ResponseEntity<List<Places>> getAllPlaces()
	{
		List<Places> places=goplacesservice.getAllPlaces();
		return ResponseEntity.ok(places);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/create")
	public ResponseEntity<String> create(@RequestBody Places places)
	{
		goplacesservice.create(places);
		String create= "Places saved Successfully";
		return ResponseEntity.ok(create);
	}

	@RequestMapping(method=RequestMethod.DELETE , value="/delete")
	public ResponseEntity<String> delete(@RequestBody Places places)
	{
		String delete=goplacesservice.delete(places);
		return ResponseEntity.ok(delete);
	}
	@RequestMapping(method=RequestMethod.PUT, value="update")
	public ResponseEntity<Places> update(@RequestBody Places places)
	{
		Places update=goplacesservice.update(places);
		return ResponseEntity.ok(update);
	}

	
}
