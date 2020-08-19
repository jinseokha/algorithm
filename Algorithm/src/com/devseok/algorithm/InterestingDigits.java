package com.devseok.algorithm;

import java.util.ArrayList;
import java.util.Vector;

public class InterestingDigits {

	public static void main(String[] args) {
		new InterestingDigits();
	}
	
	public InterestingDigits() {
		int[] ex1 = digitsEx1(26);
		int[] ex2 = digitsEx2(26);
		
		
		for (int i = 0; i < ex1.length; i++) {
			System.out.println("ex1 = " +ex1[i]);
		}
		
		for (int j = 0; j < ex2.length; j++) {
			System.out.println("ex2 = " +ex2[j]);
		}
		
		
	}
	
	public int[] digitsEx1(int base) {
		
		ArrayList<Integer> v = new ArrayList<Integer>();
		for (int n = 2; n < base; n++) {
			boolean ok = true;
			for (int k1 = 0; k1 < base; k1++) {
				for (int k2 = 0; k2 < base; k2++) {
					for (int k3 = 0; k3 < base; k3++) {
						if ((k1+k2*base + k3*base*base) % n == 0 && (k1+k2+k3) % n != 0) {
							ok = false;
							break;
						}
					}
					if (!ok) 
						break;
				}
				if(!ok) 
					break;
			}
			if(ok)
				v.add(n);
		}
		int[] ans = new int [v.size()];
		for (int i = 0; i < v.size(); i++) {
			ans[i] = v.get(i);
		}
		return ans;
		
	}
	
	public int[] digitsEx2(int base) {
		Vector<Integer> v = new Vector<Integer>();
		
		for (int i = 2; i < base; i++) {
			if(((base-1)%i) == 0) {
				v.add(i);
			}
		}
		
		int[] ans = new int[v.size()];
		for (int i = 0; i < v.size(); i++) {
			ans[i] = v.get(i);
		}
		return ans;
	}
}
