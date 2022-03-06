package com.greatlearning.bankdemo.service;

public class OTPGenrator {
	
	public int getOTP() {
		int otp = (int) (Math.random()*9000) + 1000;
		return otp;
	}

}
