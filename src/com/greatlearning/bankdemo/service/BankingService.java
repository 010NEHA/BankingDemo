package com.greatlearning.bankdemo.service;

import com.greatlearning.bankdemo.model.Customer;

public class BankingService {
	
	public void deposit(double amount, Customer customer) {
		//add business logic
		if(amount > 0.0) {
			double currBalance = customer.getBalance();
			currBalance = currBalance+amount;
			customer.setBalance(currBalance);
			System.out.println("Depoisted Successfully. Current Balance is "+currBalance);
		}else {
			System.out.println("Invalid Deposit Amount");
		}
	}
	
	public void withdrawl(double amount, Customer customer) {
		//add business logic
		if(amount <= customer.getBalance()) {
			double currBalance = customer.getBalance();
			currBalance = currBalance - amount;
			customer.setBalance(currBalance);
			System.out.println("Withraw Successful. Current Balance is "+currBalance);
		}else {
			System.out.println("Withdrawl Amount Greater than Current Balance");
		}
	}
	
	public void transfer(double amount, Customer fromCustomer, Customer toCustomer) {
		//add business logic
		if(amount <= fromCustomer.getBalance()) {
			
			double currBalance = fromCustomer.getBalance();
			currBalance = currBalance - amount;
			fromCustomer.setBalance(currBalance);
			
			currBalance = toCustomer.getBalance();
			currBalance = currBalance+amount;
			toCustomer.setBalance(currBalance);
			
			System.out.println("Transfer Successful. Current Balance is "+fromCustomer.getBalance());
		}else {
			System.out.println("Transfer Amount Greater than Current Balance");
		}
	}
}
