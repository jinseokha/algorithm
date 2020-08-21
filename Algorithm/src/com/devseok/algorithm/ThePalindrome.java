package com.devseok.algorithm;

public class ThePalindrome {

	public static void main(String[] args) {
		new ThePalindrome();
	}
	
	public ThePalindrome() {
		
		String ex1 = "abab";
		String ex2 = "abacaba";
		String ex3 = "qwerty";
		String ex4 = "adavadafasvdzxv";
		
		
		int result1 = find(ex1);
		int result2 = find(ex2);
		int result3 = find(ex3);
		int result4 = find(ex4);
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		System.out.println("result3 = " + result3);
		System.out.println("result4 = " + result4);
		
	}
	
	public int find(String s) {
		for (int index = s.length(); ; index++) {
			boolean flag = true;
			for (int j = 0; j < s.length(); j++) {
				if((index - j - 1) < s.length() && s.charAt(j) != s.charAt(index - j - 1)) {
					flag = false;
					break;
				}
			}
			if (flag)
				return index;
		}
	}
}
