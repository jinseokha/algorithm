package com.devseok.algorithm;

public class ChessMetric {


	public static void main(String[] args) {
		new ChessMetric();
	}
	
	public ChessMetric() {
		
		int size1 = 3;
		int[] start1 = {0, 0};
		int[] end1 = {1, 0};
		int numMoves1 = 1;
		
		int size2 = 3;
		int[] start2 = {0, 0};
		int[] end2 = {1, 2};
		int numMoves2 = 1;
		
		int size3 = 3;
		int[] start3 = {0, 0};
		int[] end3 = {2, 2};
		int numMoves3 = 1;
		
		int size4 = 3;
		int[] start4 = {0, 0};
		int[] end4 = {0, 0};
		int numMoves4 = 2;
		

		long res1 = howMany(size1, start1, end1, numMoves1);
		long res2 = howMany(size2, start2, end2, numMoves2);
		long res3 = howMany(size3, start3, end3, numMoves3);
		long res4 = howMany(size4, start4, end4, numMoves4);
		
		System.out.println("res1 = " + res1);
		System.out.println("res2 = " + res2);
		System.out.println("res3 = " + res3);
		System.out.println("res4 = " + res4);
		
	}
	
	public long howMany(int size, int[] start, int[] end, int numMoves) {
		long [][][] ways = new long[100][100][55];
		int[] dx = new int[] {1, 1, 1, 0, -1, -1, -1, 0, 2, 1, -1, -2, -2, -1, 1, 2};
		int[] dy = new int[] {1, 0, -1, -1, -1, 0, 1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
		
		int x, y, i, j;
		int sx = start[0];
		int sy = start[1];
		int ex = end[0];
		int ey = end[1];
		
		ways[sy][sx][0] = 1;
		
		for (i = 1; i <= numMoves; i++) {
			for (x = 0; x < size; x++) {
				for (y = 0; y < size; y++) {
					for (j = 0; j < 16; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						
						if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
							continue;
						}
						
						ways[ny][nx][i] += ways[y][x][i-1];
					}
				}
			}
		}
		return ways[ey][ex][numMoves];
	}
}
