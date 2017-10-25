package com.wipro.main;

public class HealthInsurance implements Surveyor {

	Claim cm;
	HealthInsurance(Claim cm)
	{
		this.cm=cm;
	}
	public boolean voilidate() {
		//System.out.println("validate 1");
		return true;
	}
}
