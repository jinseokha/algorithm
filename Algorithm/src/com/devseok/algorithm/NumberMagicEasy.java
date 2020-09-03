package com.devseok.algorithm;

public class NumberMagicEasy {

	public static void main(String[] args) {
		new NumberMagicEasy();
	}
	
	public NumberMagicEasy() {
		
		String ans1 = "YNYY";
		String ans2 = "YNNN";
		String ans3 = "NNNN";
		String ans4 = "YYYY";
		String ans5 = "NYNY";
		
		int num1 = theNumber(ans1);
		int num2 = theNumber(ans2);
		int num3 = theNumber(ans3);
		int num4 = theNumber(ans4);
		int num5 = theNumber(ans5);
		
		int num6 = theNumber2(ans1);
		int num7 = theNumber2(ans2);
		int num8 = theNumber2(ans3);
		int num9 = theNumber2(ans4);
		int num10 = theNumber2(ans5);
		
		int num11 = theNumber3(ans1);
		int num12 = theNumber3(ans2);
		int num13 = theNumber3(ans3);
		int num14 = theNumber3(ans4);
		int num15 = theNumber3(ans5);
		
		System.out.println("num6 = " + num6);
		System.out.println("num7 = " + num7);
		System.out.println("num8 = " + num8);
		System.out.println("num9 = " + num9);
		System.out.println("num10 = " + num10);
		
		
		System.out.println("num11 = " + num11);
		System.out.println("num12 = " + num12);
		System.out.println("num13 = " + num13);
		System.out.println("num14 = " + num14);
		System.out.println("num15 = " + num15);
	}
	
	public int theNumber(String answer) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8};
		int[] B = { 1, 2, 3, 4, 9, 10, 11, 12};
		int[] C = { 1, 2, 5, 6, 9, 10, 13, 14};
		int[] D = { 1, 3, 5, 7, 9, 11, 13, 15};
		
		for (int i = 1; i <= 16; i++) {
			if(Check(A, i) != answer.charAt(0)) 
				continue;
			if(Check(B, i) != answer.charAt(1)) 
				continue;
			if(Check(C, i) != answer.charAt(2)) 
				continue;
			if(Check(D, i) != answer.charAt(3)) 
				continue;
			
			return i;
		}
		
		return 0;
	}
	
	char Check(int[] X, int number) {
		for (int x: X) {
			if (x == number) 
				return 'Y';
		}
		return 'N';
	}
	
	public int theNumber2(String answer) {
		String[] c = {
			"YYYYYYYYNNNNNNNN",
			"YYYYNNNNYYYYNNNN",
			"YYNNYYNNYYNNYYNN",
			"YNYNYNYNYNYNYNYN"
		};
		
		for (int index = 0; index <= 15; index++) {
			String temp = "";
			for (int i = 0; i < 4; i++) {
				temp += c[i].charAt(index);
				
				if (answer.equals(temp)) {
					return index + 1;
				}
			}
		}
		
		return 0;
		
	}
	
	public int theNumber3(String answer) {
		String[] c = {
				"YYYY",
				"YYYN",
				"YYNY",
				"YNYY",
				"YNYN",
				"YNNY",
				"YNNN",
				"NYYY",
				"NYYN",
				"NYNY",
				"NYNN",
				"NNYY",
				"NNYN",
				"NNNY",
				"NNNN"
		};
		
		
		for (int index = 0; index <= 15; index++) {
			if(answer.equals(c[index])) {
				return index + 1;
			}
		}
		
		
		return 0;
	}
	
}
