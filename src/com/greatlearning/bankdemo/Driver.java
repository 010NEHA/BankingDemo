package com.greatlearning.bankdemo;

import java.util.HashMap;
import java.util.Scanner;

import com.greatlearning.bankdemo.dataaccess.DataBase;
import com.greatlearning.bankdemo.model.Customer;
import com.greatlearning.bankdemo.service.BankingService;
import com.greatlearning.bankdemo.service.OTPGenrator;

public class Driver {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" Welcome to Indian Bank Login");
		//Load data from DB
		DataBase db = new DataBase();
		OTPGenrator otp = new OTPGenrator();
		BankingService banking = new BankingService();
		HashMap<String, Customer> customers=  db.loadData();
		int choice =0;
		System.out.println(" Please Enter your Account Number:");
		String accountNo = sc.nextLine();
		System.out.println(" Please Enter your password:");
		String password = sc.nextLine();
		Customer cust = customers.get(accountNo);
		do {
		if(cust != null && password.equals(cust.getPassword())) {
			System.out.println("Choose the option below");
			System.out.println("--------------------------------------");
			System.out.println("1. Deposit");
			System.out.println("2. Withraw");
			System.out.println("3. Transfer");
			System.out.println("4. Logout");
			System.out.println("--------------------------------------");
			choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println(" Please Enter the deposit Amount");
				double amount = sc.nextDouble();
				banking.deposit(amount, cust);
				break;
			case 2:
				System.out.println(" Please Enter the withdrawl Amount");
				amount = sc.nextDouble();
				banking.withdrawl(amount, cust);
				break;
			case 3:
				System.out.println(" Please Enter the Transfer Amount");
				amount = sc.nextDouble();
				System.out.println(" Please Enter the Account Number to deposit");
				sc.nextLine();
				String toAcc = sc.nextLine();
				Customer toCust = customers.get(toAcc);
				if(toCust == null) {
					System.out.println("Invliad Account Number");
					break;
				}
				int srcOtp = otp.getOTP();
				System.out.println("OTP  Generated :"+srcOtp);
				System.out.println("Enter the OTP Back");
				int otpOut = sc.nextInt();
				if(srcOtp != otpOut) {
					System.out.println("Invliad  OTP Numbers");
					break;
				}
				banking.transfer(amount, cust, toCust);
				break;
			case 4:
				System.out.println("Logged Out");
				break;
			}
			
		}else {
			System.out.println("Invalid Account No or Password");
		}
		}while(choice != 4);

	}

}
