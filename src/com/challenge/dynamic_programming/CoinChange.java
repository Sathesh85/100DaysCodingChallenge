package com.challenge.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = { 1, 2 };
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(coins, 3));
	}

	int min = Integer.MAX_VALUE;


	public int coinChange(int[] coins, int amount) {
		/*coinChange(coins, amount, 0);

		return min == Integer.MAX_VALUE ? -1 : min;*/
		return helper(coins, amount, new int[amount]);

	}

	/*
	 * Coin change using dynamic programming
	 * 
	 */
	private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	    if(rem<0) return -1; // not valid
	    if(rem==0) return 0; // completed
	    if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
	    int min = Integer.MAX_VALUE;
	    for(int coin : coins) {
	        int res = helper(coins, rem-coin, count);
	        if(res>=0 && res < min)
	            min = 1+res;
	    }
	    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
	    return count[rem-1];
	}
	

	/*
	 * Coin change using recursion
	 * 
	 */
	private void coinChange(int[] coins, int amount, int count) {
		if (amount == 0) {
			min = Math.min(min, count);
			return;
		}
		if (amount < 0)
			return;

		for (int i = 0; i < coins.length; i++) {
			coinChange(coins, amount - coins[i], count + 1);
		}
	}

}
