package com.greatlearning.bankdemo.dataaccess;

import java.util.HashMap;

import com.greatlearning.bankdemo.model.Customer;

public class DataBase {
	
	public HashMap<String,Customer> loadData() {
		Customer customer1 = new Customer();
		customer1.setAccountNo("04567542");
		customer1.setPassword("password");
		customer1.setBalance(1000.00);
		
		Customer customer2 = new Customer();
		customer2.setAccountNo("04567543");
		customer2.setPassword("password");
		customer2.setBalance(1000.00);
		
		Customer customer3 = new Customer();
		customer3.setAccountNo("04567544");
		customer3.setPassword("password");
		customer3.setBalance(1000.00);
		
		HashMap<String,Customer> map = new HashMap<String, Customer>();
		map.put("04567542", customer1);
		map.put("04567543", customer2);
		map.put("04567544", customer3);
		
		return map;
	}

}
