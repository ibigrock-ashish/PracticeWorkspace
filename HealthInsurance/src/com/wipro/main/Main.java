package com.wipro.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = sc.nextInt();
		System.out.println("Enter a amount:");
		int amount = sc.nextInt();
		System.out.println("Give attachments as String: ");
		String attachments = sc.next();
		Claim c = new Claim();
		c.setAmount(amount);
		c.setId(id);
		c.setAttachments(attachments);
		HealthInsurance h = new HealthInsurance(c);
		Manager m = new Manager(h);
		System.out.println(m.process());

	}
}