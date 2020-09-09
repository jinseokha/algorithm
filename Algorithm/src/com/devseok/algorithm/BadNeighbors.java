package com.devseok.algorithm;

public class BadNeighbors {

	public static void main(String[] args) {
		new BadNeighbors();
	}
	
	public BadNeighbors() {
		
		int[] ans1 = {10, 3, 2, 5, 7, 8};
		int[] ans2 = {11, 15};
		int[] ans3 = {7, 7, 7, 7, 7, 7, 7};
		int[] ans4 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
		
		int res1 = maxDonations(ans1);
		int res2 = maxDonations(ans2);
		int res3 = maxDonations(ans3);
		int res4 = maxDonations(ans4);
	
		
		System.out.println("res 1 = " + res1);
		System.out.println("res 2 = " + res2);
		System.out.println("res 3 = " + res3);
		System.out.println("res 4 = " + res4);
		
		
	}
	
	public int maxDonations(int[] donations) {
		int i;
		int ans = 0;
	
		int N = donations.length;
		int[] dp = new int[N];
		
		for(i = 0; i < N-1; i++) {
			dp[i] = donations[i];
			
			if (i > 0)
				dp[i] = Math.max(dp[i], dp[i-1]);
			
			if (i > 1)
				dp[i] = Math.max(dp[i], dp[i-2] + donations[i]);
			
			ans = Math.max(ans,  dp[i]);
		}
		
		for(i = 0; i < N-1; i++) {
			dp[i] = donations[i+1];
			
			if (i > 0)
				dp[i] = Math.max(dp[i], dp[i-1]);
			
			if (i > 1)
				dp[i] = Math.max(dp[i], dp[i-2] + donations[i+1]);
			
			ans = Math.max(ans,  dp[i]);
		}
		
		
		return ans;
	
	}
}
