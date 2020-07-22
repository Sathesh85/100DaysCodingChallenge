package com.challenge.graph;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = { { 'F', 'Y', 'C', 'E', 'N', 'R', 'D' }, { 'K', 'L', 'N', 'F', 'I', 'N', 'U' },
				{ 'A', 'A', 'A', 'R', 'A', 'H', 'R' }, { 'N', 'D', 'K', 'L', 'P', 'N', 'E' },
				{ 'A', 'L', 'A', 'N', 'S', 'A', 'P' }, { 'O', 'O', 'G', 'O', 'T', 'P', 'N' },
				{ 'H', 'P', 'O', 'L', 'A', 'N', 'O' } };

		WordSearch w = new WordSearch();
		boolean res = w.exist(board, "CHINA");
		System.out.println(res);

	}

	int a[] = { -1, 1, 0, 0 };
	int b[] = { 0, 0, -1, 1 };

	public boolean exist(char[][] board, String word) {

		boolean isFound = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				Set<Point> set = new HashSet<Point>();
				if (isValid(i, j, board, word.charAt(0), set) && exist(board, word, set, i, j, 1)) {
					return true;
				}
			}
		}

		return isFound;

	}

	private boolean isValid(int i, int j, char[][] board, char ch, Set<Point> set) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || set.contains(new Point(i, j))
				|| board[i][j] != ch) {
			return false;
		}
		return true;
	}

	private boolean exist(char[][] board, String word, Set<Point> points, int row, int col, int p) {

		if (p == word.length()) {
			return true;
		}

		points.add(new Point(row, col));
		for (int j = 0; j < a.length; j++) {
			if (isValid(row + a[j], col + b[j], board, word.charAt(p), points)) {
				points.add(new Point(row + a[j], col + b[j]));
				if (exist(board, word, points, row + a[j], col + b[j], p + 1)) {
					return true;
				}
			}
		}
//		points.remove(new Point(row, col));

		points.remove(new Point(row, col));
		return false;
	}

}
