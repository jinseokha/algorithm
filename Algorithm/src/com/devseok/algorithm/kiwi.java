package com.devseok.algorithm;

public class kiwi {

	
	public static void main(String[] args) {
		new kiwi();
	}
	
	public kiwi() {
		
		int[] capacities = {14, 35, 86, 58, 25, 62};
		int[] bottles = {6, 34, 27, 38, 9, 60};
		int[] fromId = {1, 2, 4, 5, 3, 3, 1, 0};
		int[] toId = {0, 1, 2, 4, 2, 5, 3, 1};
		
		int[] resultEx1 = thePouringEx1(capacities, bottles, fromId, toId);
		int[] resultEx2 = thePouringEx2(capacities, bottles, fromId, toId);
		int[] resultEx3 = thePouringEx3(capacities, bottles, fromId, toId);
		
		System.out.println("thePouringEx1");
		
		for (int i = 0; i < resultEx1.length; i++) {
			System.out.print(resultEx1[i] + " ");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("thePouringEx2");
		
		for (int i = 0; i < resultEx2.length; i++) {
			System.out.print(resultEx2[i] + " ");
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("thePouringEx3");
		
		for (int i = 0; i < resultEx3.length; i++) {
			System.out.print(resultEx3[i] + " ");
		}
		
		
	}
	
	
	public int[] thePouringEx1(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for (int i = 0; i < fromId.length; i++) {
			int f = fromId[i];
			int t = toId[i];
			int space = capacities[t] - bottles[t];
			
			if (space >= bottles[f]) {
				int vol = bottles[f];
				bottles[t] += vol;
				bottles[f] = 0;
			} else {
				int vol = space;
				bottles[t] += vol;
				bottles[f] -= vol;
			}
		}
		
		return bottles;
	}
	
	public int[] thePouringEx2(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for (int i = 0; i < fromId.length; i++) {
			int f = fromId[i];
			int t = toId[i];
			
			int vol = Math.min(bottles[f], capacities[t] - bottles[t]);
			
			bottles[f] -= vol;
			bottles[t] += vol;
		}
		
		return bottles;
		
	}
	
	public int[] thePouringEx3(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		
		for (int i = 0; i < fromId.length; i++) {
			int sum = bottles[fromId[i]] + bottles[toId[i]];
			bottles[toId[i]] = Math.min(sum,  capacities[toId[i]]);
			bottles[fromId[i]] = sum - bottles[toId[i]];
		}
		
		return bottles;
	}


}
