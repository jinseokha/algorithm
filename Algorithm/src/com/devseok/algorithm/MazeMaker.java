package com.devseok.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class MazeMaker {

	public static void main(String[] args) {

		new MazeMaker();
	}
	
	public MazeMaker() {
		
		String[] maze1 = {"...", "...", "..." };
		int startRow1 = 0;
		int startCol1 = 0;
		int[] moveRow1 = {1, 0, -1 , 0};
		int[] moveCol1 = {0, 1, 0, -1};
		
		String[] maze2 = {"...", "...", "..." };
		int startRow2 = 0;
		int startCol2 = 1;
		int[] moveRow2 = {1, 0, -1 , 0, 1, 1, -1, -1};
		int[] moveCol2 = {0, 1, 0, -1, 1, -1, 1, -1};
		
		String[] maze3 = {"X.X", "...", "XXX", "X.X"};
		int startRow3 = 0;
		int startCol3 = 1;
		int[] moveRow3 = {1, 0, -1 , 0};
		int[] moveCol3 = {0, 1, 0, -1};
		
		String[] maze4 = {".......", "X.X.X..", "XXX...X", "....X..", "X....X.", "......." };
		int startRow4 = 5;
		int startCol4 = 0;
		int[] moveRow4 = {1, 0, -1 , 0, -2, 1};
		int[] moveCol4 = {0, -1, 0, 1, 3, 0};
		
		int return1 = longestPath(maze1, startRow1, startCol1, moveRow1, moveCol1);
		int return2 = longestPath(maze2, startRow2, startCol2, moveRow2, moveCol2);
		int return3 = longestPath(maze3, startRow3, startCol3, moveRow3, moveCol3);
		int return4 = longestPath(maze4, startRow4, startCol4, moveRow4, moveCol4);
		
		System.out.println("return1 = " + return1);
		System.out.println("return2 = " + return2);
		System.out.println("return3 = " + return3);
		System.out.println("return4 = " + return4);
	}
	
	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
		int max = 0;
		
		int width = maze[0].length();
		int height = maze.length;
		
		int[][] board = new int[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = -1;
			}
		}
		
		board[startRow][startCol] = 0;
		
		Queue<Integer> queueX = new LinkedList<Integer>();
		Queue<Integer> queueY = new LinkedList<Integer>();
		
		queueX.add(startCol);
		queueY.add(startRow);
		
		while (!queueX.isEmpty()) {
			int x = queueX.poll();
			int y = queueY.poll();
			
			for (int i = 0; i < moveRow.length; i++) {
				int nextX = x + moveCol[i];
				int nextY = y + moveRow[i];
				
				if ( 0<=nextX && nextX < width && 0 <= nextY && nextY < height 
						&& board[nextY][nextX] == -1 && maze[nextY].charAt(nextX) == '.') {
					board[nextX][nextY] = board[y][x] + 1;
					queueX.add(nextX);
					queueY.add(nextY);
				}
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (maze[i].charAt(j) == '.' && board[i][j] == -1) {
					
					return -1;
				}
				max = Math.max(max, board[i][j]);
			}
		}
		
	
		return max;
	}
	
}
