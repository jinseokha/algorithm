package com.devseok.algorithm;

public class ColorfulBoxesAndBalls {

	public static void main(String[] args) {
		
	}
	
	public ColorfulBoxesAndBalls() {
		
	}
	
	public int getMaximum(int numRed, int numBlue, int onlyRed, int onlyBlue, int bothColors) {
		int ans = Integer.MIN_VALUE;
		int change = Math.min(numRed, numBlue);
		
		for (int index = 0; index <= change; index++) {
			int myscore = (numRed - index) * onlyRed + (numBlue - index) * onlyBlue + 2 * index * bothColors;
			
			ans = Math.max(ans,  myscore);
		}
		
		return ans;
	}
}
