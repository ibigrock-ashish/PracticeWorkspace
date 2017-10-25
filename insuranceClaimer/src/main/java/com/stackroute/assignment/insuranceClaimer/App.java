package com.stackroute.assignment.insuranceClaimer;

/**
 * Validates and Approves the Claim made by Customer
 *
 */
public class App {
	public static void main(String[] args) {

		Claim claim = new Claim();
		HealthInsuranceSurveyor objHealthInsurance = new HealthInsuranceSurveyor(claim);
		VehicleInsuranceSurveyor objVehicleInsurance = new VehicleInsuranceSurveyor(claim);

		Manager manager = new Manager(objHealthInsurance);
		manager.status();

		manager = new Manager(objVehicleInsurance);
		manager.status();

	}
}