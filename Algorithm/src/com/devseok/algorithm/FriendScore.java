package com.devseok.algorithm;

public class FriendScore {

	public static void main(String[] args) {
		new FriendScore();
	}
	
	public FriendScore() {
		String[] ex1 = {"NNN", "NNN", "NNN"};
		String[] ex2 = {"NYY", "YNY", "YYN"};
		String[] ex3 = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
		String[] ex4 = {"NNNNYNNNNN", "NNNNYNYYNN", "NNNYYYNNNN", "NNYNNNNNNN", "YYYNNNNNNY", "NNYNNNNNYN",
				"NYNNNNNYNN", "NYNNNNYNNN", "NNNNNYNNNN", "NNNNYNNNNN"};
		
		int ans1 = highestScore(ex1);
		int ans2 = highestScore(ex2);
		int ans3 = highestScore(ex3);
		int ans4 = highestScore(ex4);
		
		System.out.println("ans1 = " + ans1);
		System.out.println("ans2 = " + ans2);
		System.out.println("ans3 = " + ans3);
		System.out.println("ans4 = " + ans4);
	}
	
	public int highestScore(String[] friends) {
		int ans = 0;
		int n = friends[0].length();
		
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			
			for (int j = 0; j < n; j++) {
				if (i == j) 
					continue;
				
				if (friends[i].charAt(j) == 'Y') {
					cnt++;
				} else {
					for (int k = 0; k < n; k++) {
						if (friends[j].charAt(k) == 'Y' && friends[k].charAt(i) == 'Y') {
							cnt++;
							break;
						}
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		
		return ans;
	}
}
