package com.devseok.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryFlips {

	public int minimalMoves(int A, int B, int K) {
		if(A == 0)
			return 0;
		
		if(A + B < K)
			return -1;
		
		int[] array = new int[A + B + 1];
		
		for (int idx = 0; idx <= A + B; idx++) {
			array[idx] = -1;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(A);
		
		array[A] = 0;
		
		while (!q.isEmpty()) {
			int i = q.poll();
			for (int j = Math.max(0, K - (A + B - i)); j <= Math.min(i,  K); j++) {
				int nextzero = i + (K - 2 * j);
				
				if (array[nextzero] == -1) {
					if (nextzero == 0) 
						return array[i] + 1;
					q.add(nextzero);
				}
			}
		}
		return -1;
	}
	
	int[] array;
	int k;
	Queue<Integer> q;
	
	public int minimalMoves2(int A, int B, int K) {
		if (A == 0)
			return 0;
		if (A + B < K)
			return -1;
		
		array = new int[A + B + 1];
		
		k = K;
		
		for (int i = 0; i <= A + B; i++) {
			array[i] = -1;
		}
		
		q = new LinkedList<Integer>();
		q.add(A);
		array[A] = 0;
		
		while (!q.isEmpty()) {
			int i = q.poll();
			
			check(i, Math.max(0,  K - (A + B - i)));
			check(i, Math.min(i , K));
			check(i, Math.min(Math.max((i+1) / 2, K - ((A + B) - i)),  k));
			check(i, Math.min(Math.max(i / 2,  K - ((A + B) - i)),  k));
		}
		
		return array[0];
	}
	
	public void check(int nowzero, int usezero) {
		int nextzero = nowzero + k - 2 * usezero;
		if (array[nextzero] == -1) {
			array[nextzero] = array[nowzero] + 1;
			q.add(nextzero);
		}
	}
}
