package com.devseok.algorithm;

import java.util.Arrays;

public class Cryptography {

	public static void main(String[] args) {
		new Cryptography();
	}
	
	public Cryptography() {
		int[] number1 = {1, 2, 3};
		int[] number2 = {1, 3, 2, 1, 1, 3};
		int[] number3 = {1000, 999, 998, 997, 996, 995};
		int[] number4 = {1, 1, 1, 1};
		
		
		long num1 = encrypt1(number1);
		long num2 = encrypt1(number2);
		long num3 = encrypt1(number3);
		long num4 = encrypt1(number4);
		
		
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		System.out.println("num4 = " + num4);
		
		
	}
	
	public long encrypt1(int[] numbers) {
		long ans = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			long temp = 1;
			
			for (int j = 0; j < numbers.length; j++) {
				if (i == j) {
					temp *= (numbers[j] + 1);
				} else {
					temp *= (numbers[j]);
				}
			}
			ans = Math.max(ans, temp);
		}
		
		
		return ans;
	}
	
	public long encrypt2(int[] numbers) {
		long ret = 0;
		
		Arrays.parallelSort(numbers);
		numbers[0]++;
		for(int i = 0; i < numbers.length; i++) {
			ret *= numbers[i];
		}
		
		
		return ret;
	}
}
