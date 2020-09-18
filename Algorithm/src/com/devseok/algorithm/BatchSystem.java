package com.devseok.algorithm;

import java.util.HashMap;

public class BatchSystem {

	public static void main(String[] args) {
		
	}
	
	public BatchSystem() {
		
	}
	
	public int[] schedule(int[] duration, String[] user) {
		int N = duration.length;
		
		HashMap<String, Long> jobTime = new HashMap<String, Long>();
		
		for (int n = 0; n < N; n++) {
			jobTime.put(user[n],  0L);
		}
		
		for (int n = 0; n < N; n++) {
			jobTime.put(user[n],  jobTime.get(user[n]) + duration[n]);
		}
		
		boolean[] done = new boolean[N];
		
		int[] ans = new int[N];
		int ansCount = 0;
		while (ansCount < N) {
			String next = "";
			
			for (int n = 0; n < N; n++) {
				if (!done[n] && (next.equals("") || jobTime.get(user[n]) < jobTime.get(next))) {
					next = user[n];
				}
			}
			
			for (int n = 0; n < N; n++) {
				if(user[n].equals(next)) {
					done[n] = true;
					ans[ansCount++] = n;
				}
			}
		}
		return ans;
	}
}
