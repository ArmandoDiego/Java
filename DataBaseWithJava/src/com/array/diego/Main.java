package com.array.diego;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
					
					private static Scanner sccaner=new Scanner(System.in);
					private static GroceryList groceryList=new GroceryList();
	
					public static void main(String[] args) {
						boolean quit=false;
						int choose=0;
						printInstructios();
						while(!quit){
							System.out.println("Enter your choice:");
							choose=sccaner.nextInt();
							sccaner.nextLine();
							switch (choose) {
							case 0:
								printInstructios();
								break;
							case 1:
								groceryList.printGroceryItem();
								break;
							case 2:
								addItem();
								break;
							case 3:
								modifyItem();
								break;
							case 4:
								removeItem();
								break;
							case 5:
								searchForItem();
								break;
							case 7:
								processArrayList();
								break;
							case 6:
								quit=true;
								break;
							default:
								break;
							}
							
						}
						
						
					}

					public static void printInstructios(){
						System.out.println("\nPress");
						System.out.println("\t 0- To print choice options");
						System.out.println("\t 1- To print the list of Grocery items");
						System.out.println("\t 2- To add an item to the list");
						System.out.println("\t 3- To modify an item in the list");
						System.out.println("\t 4- To Remove an item in the list ");
						System.out.println("\t 5- To search an item in the list ");
						System.out.println("\t 6- to quit the application ");
					}
					
					public static void addItem(){
						System.out.println("Please enter the grocery Item:");
						groceryList.addGroceryItem(sccaner.nextLine());
					}
					
					public static void modifyItem(){
						System.out.println("Current Item Name");
						String itemNo=sccaner.nextLine();
						System.out.println("Enter New Item");
						String newItem=sccaner.nextLine();
						groceryList.modifyGroceryItem(itemNo,newItem);
					}
					public static void removeItem(){
						System.out.println("Enter Item Name to Remove:");
						String itemNo=sccaner.nextLine();
						groceryList.removeGroceryItem(itemNo);
					}
					public static void searchForItem(){
						System.out.println("Enter Item Name to Remove: to search:");
						String searchItem=sccaner.nextLine();
						if(groceryList.onFile(searchItem)){
							System.out.println("Found" + searchItem + "in our grocery list");
						}else{
							System.out.println(searchItem+ "is not in the grocery list");
						}
							
					}
					
					public static void processArrayList(){
						ArrayList<String> newArray=new ArrayList<String>();
						newArray.addAll(groceryList.getGroceryList());
					}
}
