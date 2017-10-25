package com.stackroute.goplaces.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Places 
{
	@Id
 private int id;
 private String name;
 private String address;
 private String imageurl;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getImageurl() {
	return imageurl;
}
public void setImageurl(String imageurl) {
	this.imageurl = imageurl;
}
}
