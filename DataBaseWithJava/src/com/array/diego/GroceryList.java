package com.array.diego;

import java.util.ArrayList;

public class GroceryList {

	
	ArrayList<String>  groceryList=new ArrayList<String>();
	
	
	public ArrayList<String> getGroceryList(){
		return groceryList;
	}
	
	public void addGroceryItem(String item){
		groceryList.add(item);
	}
	
	public void printGroceryItem(){
		System.out.println("You have" + groceryList.size() + "items in your grocery list");
		groceryList.forEach(x->System.out.println(x));
		
	}
	 
	public void modifyGroceryItem(String currentItem,String newItem){
		int position = findItem(currentItem);
		if(position>=0){
			modifyGroceryItem(position,newItem);
		}
		
	}
	
	private void modifyGroceryItem(int position, String newItem) {
		groceryList.set(position,newItem);
		System.out.println("grocery item" + (position+1) + "has been modified");
	}
	
	public void removeGroceryItem(String item){
		int position = findItem(item);
		if(position>=0){
			removeGroceryItem(position);
		}
	}
	
	private void removeGroceryItem(int position){
		groceryList.remove(position);
	}
	
	
	private  int findItem(String SearchItem){
		return groceryList.indexOf(SearchItem);
	}
	
	public boolean onFile(String searchItem){
		int position=findItem(searchItem);
		if(position > 0){
			return true;
		}
		return false;
	}
	
	private String findGroceryItem(String searchItem) {
//			boolean exists=groceryList.contains(searchItem);
			int position=groceryList.indexOf(searchItem);
			if (position >= 0) {
				return groceryList.get(position);
			}
			return "No find Element";
	}
	
}
