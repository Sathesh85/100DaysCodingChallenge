package com.challenge.dynamic_programming;

public class CoinChange {
	
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(coins, 100));
	}
	
	int min = Integer.MAX_VALUE;

	/*
	 * Coin change using recursion
	 * 
	 */

	public int coinChange(int[] coins, int amount) {
		
		 coinChange(coins, amount,0);
		
		return min == Integer.MAX_VALUE ? -1 : min;
		
	}

	private void coinChange(int[] coins, int amount, int count) {
		if(amount == 0) {
			 min = Math.min(min, count);
			 return;
		}
		if(amount<0) return;
		
		for(int i =0 ; i < coins.length ; i++) {
			coinChange(coins, amount-coins[i], count+1);
		}
	}

}


