package com.challenge.dynamic_programming;

public class UniquePath2 {
	
	/*
	 * Using DFS
	 */
	int count = 0;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		uniquePaths(obstacleGrid.length, obstacleGrid[0].length, 0, 0, obstacleGrid);
		return count;
	}

	private void uniquePaths(int m, int n, int i, int j, int[][] obstacleGrid) {
		if (i < 0 || j < 0 || i >= m || j >= n || obstacleGrid[i][j] == 1) {
			return;
		}
		if (m == i + 1 && n == j + 1 ) {
			count++;
			return;
		}

		uniquePaths(m, n, i + 1, j, obstacleGrid);
		uniquePaths(m, n, i, j + 1, obstacleGrid);
	}

}
