package com.devseok.algorithm;

import java.util.HashMap;

public class Interesting_Party {

	public static void main(String[] args) {
		
		String[] first = {"fishing", "gardening", "swimming", "fishing"};
		String[] second = {"hunting","fishing", "fishing", "biting"};
		
		String[] first1 = {"variety", "diversity", "loquacity", "courtesy"};
		String[] second2 = {"talking","speaking","discussion","metting"};
		
		new Interesting_Party(first, second);
		
	}
	
	public Interesting_Party(String[] first, String[] second) {
		int ans1 = bestInvigation1(first, second);
		int ans2 = bestInvitation2(first, second);
		
		System.out.println("ans 1 = " + ans1);
		System.out.println("ans 2 = " + ans2);
		
	}
	
	public int bestInvigation1(String[] first, String[] second) {
		int i, j;
		int ans = 0;
		
		for (i = 0; i < first.length; i++) {
			int f = 0;
			int s= 0;
			for (j = 0; j < first.length; j++) {
				if(first[i].equals(first[j])) 
					f++;
				if(first[i].equals(second[j]))
					f++;
				if(second[i].equals(first[j]))
					s++;
				if(second[i].equals(second[j]))
					s++;
			}
			
			ans = Math.max(f, ans);
			ans = Math.max(s, ans);
		}
		
		return ans;
	}
	
	public int bestInvitation2(String[] first, String[] second) {
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		
		for (int i = 0; i < first.length; i++) {
			dic.put(first[i], 0);
			dic.put(second[i], 0);
		}
		
		for (int i = 0; i < first.length; i++) {
			dic.put(first[i], dic.get(first[i])+1);
			dic.put(second[i], dic.get(second[i])+1);
		}
		
		int ans = 0;
		for (String key : dic.keySet()) {
			ans = Math.max(ans, dic.get(key));
		}
		
		return ans;
		
	}
}
