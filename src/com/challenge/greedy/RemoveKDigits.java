package com.challenge.greedy;

import java.util.LinkedList;

public class RemoveKDigits {

	public static void main(String[] args) {
		RemoveKDigits r = new RemoveKDigits();
		System.out.println(r.removeKdigits("1234567890", 9));
	}

	int min = Integer.MAX_VALUE;

	/**
	 * @param num
	 * @param k
	 * @return
	 * 
	 * 		Time limit exceeding
	 * 
	 * 
	 */
	/*
	 * String removeKdigits(String num, int k) {
	 * 
	 * if(num.length()<= k){ return "0"; }
	 * 
	 * 
	 * removeKdigitsHelper(num, k); return String.valueOf(min);
	 * 
	 * }
	 * 
	 * void removeKdigitsHelper(String num, int k){ if(k==0){ min =
	 * Math.min(Integer.valueOf(num), min); return; }
	 * 
	 * for(int i=0; i<num.length();i++){ removeKdigitsHelper(num.substring(0,i) +
	 * num.substring(i+1), k-1); }
	 * 
	 * }
	 */

	/**
	 * @param num
	 * @param k
	 * @return
	 * 
	 * Greedy Algorithm
	 * 
	 */
	public String removeKdigits(String num, int k) {
		if (num.length() <= k) {
			return "0";
		}

		LinkedList<Character> stack = new LinkedList<Character>();

		for (int i = 0; i < num.length(); i++) {
			while (stack.size() > 0 && k > 0 && stack.peekLast() > num.charAt(i)) {
				stack.removeLast();
				k--;
			}
			stack.addLast(num.charAt(i));
		}

		for (int i = 0; i < k; ++i) {
			stack.removeLast();
		}

		StringBuilder res = new StringBuilder();
		boolean leadingZero = true;
		for (char digit : stack) {
			if (leadingZero && digit == '0')
				continue;
			leadingZero = false;
			res.append(digit);
		}

		if (res.length() == 0)
			return "0";
		return res.toString();

	}
}
