package com.challenge.graph;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
		
	public static void main(String[] args) {
		char[][] board =
			{
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'}
			};
		
		WordSearch w = new WordSearch();
		boolean res = w.exist(board, "ABCESCFSADEES");
		System.out.println(res);

	}
	int a[] = {-1,1,0,0};
	int b[] = {0,0,-1,1};

	public boolean exist(char[][] board, String word) {
		
		boolean isFound = false;
		for(int i=0; i< board.length; i++) {
			for(int j=0;j<board[0].length;j++) {
				Set<Point> set = new HashSet<Point>();
				if(isValid(i,j,board,word.charAt(0),set) && exist(board, word, set, i, j, 1) ) {
					return true;
				}
			}
		}
		
		return isFound;

	}

	private boolean isValid(int i, int j, char[][] board, char ch, Set<Point> set) {
		if(i<0 || j<0 || i>=board.length || j>=board[0].length || set.contains(new Point(i,j)) || board[i][j] != ch) {
			return false;
		}
		return true;
	}

	private boolean exist(char[][] board, String word, Set<Point> points, int row, int col, int p) {
		
		if(p == word.length()) {
			return true;
		}
		
		for(int i =p; i< word.length(); i++) {
			points.add(new Point(row, col));
			for(int j=0;j<a.length;j++) {
				if(isValid(row+a[j], col+b[j], board, word.charAt(i), points)) {
					points.add(new Point(row+a[j], col+b[j]));
					if(exist(board, word, points, row+a[j], col+b[j], p+1)) {
						return true;
					}
				}
			}
			points.remove(new Point(row, col));
			
		}
		
		return false;
	}

}
