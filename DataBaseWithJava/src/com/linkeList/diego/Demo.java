package com.linkeList.diego;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Demo {
	public static void main(String[] args) {
		LinkedList<String> placesToVisit=new LinkedList<String>();
		addInOrder(placesToVisit, "Sydney");
		addInOrder(placesToVisit, "Melbourne");
		addInOrder(placesToVisit, "Brisbane");
		addInOrder(placesToVisit, "Perth");
		addInOrder(placesToVisit, "Canberra");
		addInOrder(placesToVisit, "Adelaide");
		addInOrder(placesToVisit, "Darwin");
		printLinkedList(placesToVisit);
//		placesToVisit.add("Sydnay");
//		placesToVisit.add("mx");
//		placesToVisit.add("canada");
//		placesToVisit.add("aguscalientes");
//		placesToVisit.add("darwin");
//		printLinkedList(placesToVisit);
//		
//		placesToVisit.add(0,"GDL");
//		printLinkedList(placesToVisit);
//		placesToVisit.remove(4);
//		printLinkedList(placesToVisit);
	}
	
	private static void printLinkedList(LinkedList<String> linkedList){
		Iterator<String> i= linkedList.iterator();
		while(i.hasNext()){
			System.out.println("now visiting: "+ i.next());
		}
		System.out.println("===============================");
	}
	
	private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
		ListIterator<String> stringListIterator= linkedList.listIterator();
		while(stringListIterator.hasNext()){
			int comparison=stringListIterator.next().compareTo(newCity);
			if(comparison == 0){
				//equal, do not add
				System.out.println(newCity + "is already included as a destination");
				return false;
			}else if(comparison > 0){
				//new city should be appear before this one
				stringListIterator.previous();
				stringListIterator.add(newCity);
			}else if(comparison < 0){
				// move on next city
			}
		}
		stringListIterator.add(newCity);
		return true;
		
	}
	
}
