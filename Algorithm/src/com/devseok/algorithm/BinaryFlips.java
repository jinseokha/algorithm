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
}
