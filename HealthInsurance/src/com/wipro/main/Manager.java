package com.wipro.main;

public class Manager {

	Surveyor surveyoy;

	Manager(Surveyor surveyoy) {
		this.surveyoy = surveyoy;
	}

	public String process() {
		// System.out.println("Validate 2");
		boolean b = surveyoy.voilidate();
		if (b) {
			return "Approved";

		} else
			return "Claim canceled";
	}

}
