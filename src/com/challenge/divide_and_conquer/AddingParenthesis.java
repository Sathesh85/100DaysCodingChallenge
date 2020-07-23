package com.challenge.divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddingParenthesis {

	List<Character> possibleSym = Arrays.asList('+', '-', '*');

	public static void main(String[] args) {
		AddingParenthesis ap = new AddingParenthesis();
		List<Integer> list = ap.diffWaysToCompute("2*2-1+5");
		System.out.println(list);
	}

	private List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();

		if (input.length() == 0) {
			return res;
		}

		if (input.length() == 1) {
			res.add(Integer.valueOf(input));
			return res;
		}

		for (int i = 0; i < input.length(); i++) {
			if (possibleSym.contains(input.charAt(i))) {
				String left = input.substring(0, i);
				String right = input.substring(i + 1);

				char symbol = input.charAt(i);

				List<Integer> leftList = diffWaysToCompute(left);
				List<Integer> rightList = diffWaysToCompute(right);

				for (int leftVal : leftList) {
					for (int rightVal : rightList) {
						res.add(calculate(leftVal, rightVal, symbol));
					}
				}
			}
		}

		return res;
	}

	private int calculate(int leftVal, int rightVal, char symbol) {
		if (symbol == '+') {
			return leftVal + rightVal;
		}
		if (symbol == '-') {
			return leftVal - rightVal;
		}
		if (symbol == '*') {
			return leftVal * rightVal;
		}
		return 0;
	}

}
