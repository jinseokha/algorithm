package com.devseok.algorithm;

public class CirclesCountry {

	public int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {
		int num = 0;
		
		for (int index = 0; index < X.length; index++) {
			if(inside(X[index], Y[index], x1, y1, R[index]) != inside(X[index], Y[index], x2, y2, R[index])) {
				num++;
			}
		}
		return num;
	}
	
	boolean inside(int x1, int y1, int x2, int y2, int r) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r * r;
	}
}
