package com.devseok.algorithm;

public class AutoLoan {

	public static void main(String[] args) {
		
	}
	
	public AutoLoan() {
		
	}
	
	public double intereestRate(double price, double monthlyPayment, int loanTerm) {
		double balance;
		double high = 100, low = 0, mid = 0;
		
		while ((1e-9<high-low) && (1e-9 < (high - low) / high)) {
			balance = price;
			mid = (high + low) / 2;
			
			for (int j = 0; j < loanTerm; j++) {
				balance *= mid / 1200 + 1;
				balance -= monthlyPayment;
			}
			
			if (0 < balance) 
				high = mid;
			
			else 
				low = mid;
		}
		
		return mid;
	}
}
