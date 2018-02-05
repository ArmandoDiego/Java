package com.interfaces.diego;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Player tim=new Player("Diego", 10, 15);
		System.out.println(tim.toString());
		saveObject(tim);
		tim.setHitPointes(8);
		System.out.println(tim);
		tim.setWeapon("Stormbringer");
		saveObject(tim);
//		loadObject(tim);
		System.out.println(tim);
		
		
		ISaveable werewolf=new Monster("Tim", 10, 15);
		System.out.println(((Monster) werewolf).getStrength());
		saveObject(werewolf);
	}
		
	
	
	
	public static ArrayList<String> readValue(){
		ArrayList<String> values=new ArrayList<String>();
		Scanner scanner=new Scanner(System.in);
		boolean quit=false;
		int index=0;
		System.out.println("Choose\n"
				+ "1 to enter a String\n"
				+ "0 to quit");
		while(!quit){
			System.out.println("Choose an option");
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice){
			case 0:
				quit=true;
				break;
			case 1:
				System.out.println("Enter a String:");
				String stringInput=scanner.nextLine();
				values.add(index,stringInput);
				index++;
				break;
			
			}
		}
		return values;
	}
	
	public static void saveObject(ISaveable objectToSave){
		for (int i = 0; i < objectToSave.write().size(); i++) {
			System.out.println("Saving " + objectToSave.write().get(i) + "to storage device");
		}
	}
	
	public static void loadObject(ISaveable objectToLoad){
		ArrayList<String> values= readValue();
		objectToLoad.read(values);
		
	}
}
