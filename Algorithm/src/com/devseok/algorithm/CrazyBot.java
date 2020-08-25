package com.devseok.algorithm;

public class CrazyBot {

	double[] prob = new double[4];
	boolean[][] grid = new boolean[100][100];
	int vx[] = {1, -1, 0, 0};
	int vy[] = {0, 0, 1, -1};
	
	public static void main(String[] args) {
		new CrazyBot();
	}
	
	public CrazyBot() {
		int n1 = 1;
		int east1 = 25;
		int west1 = 25;
		int south1 = 25;
		int north1 = 25;
		
		int n2 = 2;
		int east2 = 25;
		int west2 = 25;
		int south2 = 25;
		int north2 = 25;
		
		int n3 = 7;
		int east3 = 50;
		int west3 = 0;
		int south3 = 0;
		int north3 = 50;
		
		int n4 = 14;
		int east4 = 50;
		int west4 = 50;
		int south4 = 0;
		int north4 = 0;
		
		int n5 = 14;
		int east5 = 25;
		int west5 = 25;
		int south5 = 25;
		int north5 = 25;

		
		
		double ans1= getProbability(n1, east1, west1, south1, north1);
		double ans2= getProbability(n2, east2, west2, south2, north2);
		double ans3= getProbability(n3, east3, west3, south3, north3);
		double ans4= getProbability(n4, east4, west4, south4, north4);
		
		System.out.println("ans 1 = " + ans1);
		System.out.println("ans 2 = " + ans2);
		System.out.println("ans 3 = " + ans3);
		System.out.println("ans 4 = " + ans4);
		
		
	}
	
	public double getProbability(int n, int east, int west, int south, int north) {
		
		
		prob[0] = east / 100.0;
		prob[1] = west / 100.0;
		prob[2] = south / 100.0;
		prob[3] = north / 100.0;
		
		return dfs(50, 50, n);
	}
	
	double dfs(int x, int y, int n) {
		
		if (grid[x][y]) 
			return 0;
		
		if (n == 0) 
			return 1;
		
		grid[x][y] = true;
		double ret = 0;
		for (int i = 0; i < 4; i++) {
			ret += dfs(x+vx[i], y + vy[i], n-1)*prob[i];
		}
		
		grid[x][y] = false;
		
		return ret;
	}
}
