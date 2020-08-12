package com.challenge.dynamic_programming;

public class UniquePaths {
	
	public static void main(String[] args) {
		UniquePaths u = new UniquePaths();
		int res = u.uniquePaths(51,9);
		System.out.println(res);
	}
	
	
	/*
	 * Unique Path by dynamic Programming
	 */
	
	public int uniquePaths(int m, int n) {
		int[][] paths = new int[m][n];
		
		for(int i = 0; i< m ; i++) {
			paths[i][0] = 1;
		}
		
		for(int i = 0; i< n ; i++) {
			paths[0][i] = 1;
		}
		
		for(int i= 1 ; i< m ; i++) {
			for(int j=1; j<n; j++) {
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}
		
		return paths[m-1][n-1];
	}
	
	
	/*
	 * Unique path with DFS method. TIme limit exceeding for large matrix
	 */

	/*int count = 0;

	public int uniquePaths(int m, int n) {
		boolean[][] visited = new boolean[m][n];
		uniquePaths(m, n, 0, 0);
		return count;
	}

	private void uniquePaths(int m, int n, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}

		if (m == i + 1 && n == j + 1 || visited[i][j] == true) {
			count++;
			return;
		}

		visited[i][j] = true;

		uniquePaths(m, n, i + 1, j);
		uniquePaths(m, n, i, j + 1);
	}*/

}
