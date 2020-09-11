package com.devseok.algorithm;

public class HandShaking {

	public static void main(String[] args) {
		new HandShaking();
	}
	
	public HandShaking() {
		int ans1 = 2;
		int ans2 = 4;
		int ans3 = 8;
		
		long res1 = countPerfect(ans1);
		long res2 = countPerfect(ans2);
		long res3 = countPerfect(ans3);
		
		System.out.println("res1 = " + res1);
		System.out.println("res2 = " + res2);
		System.out.println("res3 = " + res3);
		
	}
	
	public long countPerfect(int n) {
		long[] dp = new long[n/2+1];
		
		dp[0] = 1;
		
		for (int index = 1; index < n/2; index++) {
			dp[index] = 0;
			
			for (int j = 0; j < index; j++) {
				dp[index] += dp[j] * dp[index - j - 1];
			}
		}
		
		return dp[n/2];
	}
}
