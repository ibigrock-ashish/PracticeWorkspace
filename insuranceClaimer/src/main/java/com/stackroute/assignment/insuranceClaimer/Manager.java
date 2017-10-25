package com.stackroute.assignment.insuranceClaimer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class Manager {

	private InsuranceSurveyor surveyor;
	public static Logger logger =  LogManager.getLogger("Manager.class");
	public Manager(InsuranceSurveyor surveyor) {
		this.surveyor = surveyor;
	}

	public void status() {
		if (surveyor.validator()) {
			logger.debug("Claim Approved!!");
		} else {
			logger.debug("Claim Rejected...");
		}
	}

}
