package com.devseok.algorithm;

public class Hamilton_Path {

	String[] roads;
	boolean[] visited;
	
	public int countPaths(String[] roads) {
		int group = 0, free = 0;
		
		int[] connect = new int[roads.length];
		long sum = 1;
		
		this.roads = roads;
		visited = new boolean[roads.length];
		
		for (int idx = 0; idx < roads.length; idx++) {
			int y = 0;
			for (int j = 0; j < roads[idx].length(); j++) {
				if(roads[idx].charAt(j) == 'Y') {
					if (2 < ++y)
						return 0;
				}
			}
		}
		
		for (int idx = 0; idx < connect.length; idx++) {
			if (connect[idx] == 0) {
				visited[idx] = true;
				free++;
			} else if(connect[idx] == 1 && !visited[idx]){
				group++;
				dfs(idx);
				
			}
		}
		
		for (int idx = 0; idx < visited.length; idx++) {
			if(!visited[idx]) 
				return 0;
		}
		
		for (int idx = 0; idx < group+free; idx++) {
			sum = sum * (idx + 1) % 1000000007;
		}
		
		for (int idx = 0; idx < group; idx++) {
			sum = sum * (idx + 1) % 1000000007;
		}
		
		return (int) sum;
		
	}
	
	void dfs(int city) {
		visited[city] = true;
		
		for (int idx = 0; idx < roads[city].length(); idx++) {
			if (roads[city].charAt(idx) == 'Y' && !visited[idx]) {
				dfs(idx);
			}
		}
	}
}
