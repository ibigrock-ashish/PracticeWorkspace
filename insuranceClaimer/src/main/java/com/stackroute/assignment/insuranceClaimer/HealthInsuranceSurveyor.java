package com.stackroute.assignment.insuranceClaimer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class HealthInsuranceSurveyor implements InsuranceSurveyor {

	private Claim claim;
	private static Logger logger =  LogManager.getLogger("HealthInsuranceSurveyor.class");
	public HealthInsuranceSurveyor(Claim claim) {
		this.claim = claim;
	}

	public boolean validator() {
		logger.debug("Validating health insurance claim ...");
		return true;
	}

}
