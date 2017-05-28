package com.array.diego;

import java.util.Scanner;

public class MainContact {
			
			private static Scanner scanner=new Scanner(System.in); 
			private static MobilePhone mobilePhone=new MobilePhone("4492259143");
	
			public static void main(String[] args) {
				
				
				boolean quit=false;
				startPhone();
				printActions();
				while(!quit){
					System.out.println("\nEnter action: (6 to show avaliable actios)");
					int action=scanner.nextInt();
					scanner.nextLine();
					switch(action){
					case 0:
						System.out.println("\nShitting down....");
						quit=true;
						break;
					case 1:
						mobilePhone.printContacts();
						break;
					case 2:
						addNewContact();
						break;
					case 3:
						updateContact();
						break;
					case 4:
						removeContact();
						break;
					case 5:
						queryContact();
						break;
					case 6:
						printActions();
						break;
					}
				}
				
			}
			private static  void addNewContact(){
				System.out.println("Enter new Contact name:");
				String name=scanner.nextLine();
				System.out.println("Enter new phone Number");
				String phoneNumber=scanner.nextLine();
				Contact newContact=Contact.createContact(name, phoneNumber);
				if(mobilePhone.addNewContact(newContact)){
					System.out.println("new Contact Added "+ name + " ,phone= " + phoneNumber);
				}else{
					System.out.println("Can not added"+ name + " Already on file");
				}
			}
			
			private static void updateContact(){
				System.out.println("Enter existing Contact name");
				String name=scanner.nextLine();
				Contact existingContactRecord=mobilePhone.queryContact(name);
				if (existingContactRecord == null) {
					System.out.println("contact not found");
					return;
				}
				System.out.println("Enter new Contact name");
				String newName=scanner.nextLine();
				System.out.println("Enter new Contact phone");
				String newPhone=scanner.nextLine();
				Contact newContact=Contact.createContact(newName, newPhone);
				if(mobilePhone.updateContact(existingContactRecord, newContact)){
					System.out.println("the contact " + name +  " was remplaced by" + newContact.getName() );
				}else{
					System.out.println("the contact" + name + "Was not found" );
				}
				
			}
			
			
			private static void removeContact(){
				System.out.println("Enter existing Contact name");
				String name=scanner.nextLine();
				Contact existingContactRecord=mobilePhone.queryContact(name);
				if (existingContactRecord == null) {
					System.out.println("contact not found");
					return;
				}
				if(mobilePhone.removeConctact(existingContactRecord)){
					System.out.println("successfully Removed");
				}else{
					System.out.println("Oh something wrong happen");
				}
			}
			
			private static void queryContact(){
				System.out.println("Enter Contact name ");
				String name=scanner.nextLine();
				Contact existingContactRecord=mobilePhone.queryContact(name);
				if (existingContactRecord == null) {
					System.out.println("contact not found");
					return;
				}
				System.out.println("Name:" + existingContactRecord.getName()+ "Phone number is" + existingContactRecord.getPhoneNumber());
				
			}
			
			private static void startPhone(){
				System.out.println("Starting phone....");
			}
			
			private static void printActions(){
				System.out.println("\nAvaliable actions:\npress");
				System.out.println(	  "0 - to shutdown\n"
									+ "1 - to print contacts\n"
									+ "2 - to add a new contact\n"
									+ "3 - to update existing an existing contact\n"
									+ "4 - to remove an existing contact\n"
									+ "5 - query if existing contact\n"
									+ "6 - to print a list of avaliable actios");
				System.out.println("Choose your action");
			}
}
