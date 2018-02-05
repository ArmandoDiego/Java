package com.sortColle.diego;

public class Main {
	
	private static StockList stockList=new StockList();
	
	public static void main(String[] args) {
		
		StockItem temp=new StockItem("bread", 3,5);
		stockList.addStock(temp);
		temp=new StockItem("Cake", 1.10,7);
		stockList.addStock(temp);
		temp=new StockItem("Car", 12.50,2);
		stockList.addStock(temp);
		temp=new StockItem("Chair", 52.0,10);
		stockList.addStock(temp);
		temp=new StockItem("Cup", 0.50,200);
		stockList.addStock(temp);
		temp=new StockItem("door", 72.95,4);
		stockList.addStock(temp);
		temp=new StockItem("vase", 8.76,40);
		stockList.addStock(temp);
		
		System.out.println(stockList);
		
		for (String s : stockList.items().keySet()) {
			System.out.println(s);
		}
		
	}

}
