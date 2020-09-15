package com.devseok.algorithm;

public class StockHistory {

	public static void main(String[] args) {
		new StockHistory();
	}
	
	public StockHistory() {
		
		
	}
	
	public int maximumEarnings(int initialInvestment, int monthlyContribution, String[] stockPrices) {
		int money = initialInvestment;
		int month = stockPrices.length;
		int corp = stockPrices[0].split(" ").length;
		
		int[][] prices = new int[month][corp];
		double max = 0, profit = 0;
		double[] proportion = new double[month-1];
		boolean[] buy = new boolean[month - 1];
		
		for (int i = 0; i < month; i++) {
			String[] s = stockPrices[i].split(" ");
			
			for (int j = 0; j < corp; j++) {
				prices[i][j] = Integer.valueOf(s[j]);
			}
		}
		
		for (int i = month - 2; i >= 0; i--) {
			for (int j =0; j < corp; j++) {
				double p = 1.0*prices[month - 1][j]/ prices[i][j] - 1;
				
				if (0 < p && max < p) {
					buy[i] = true;
					max = p;
					proportion[i] = p;
				}
			}
		}
		
		for (int i = 0; i < buy.length; i++) {
			if (buy[i]) {
				profit += money * proportion[i];
				money = 0;
			}
			
			money += monthlyContribution;
		}
		
		return (int)Math.round(profit);
	}
}
