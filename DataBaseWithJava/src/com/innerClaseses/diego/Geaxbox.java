package com.innerClaseses.diego;

import java.util.ArrayList;

public class Geaxbox {
		
	private ArrayList<Gear> gears;
	private int maxGears;
	private int currentGear=0;
	private boolean clutchIsIn;
	public Geaxbox(int maxGears) {
		this.maxGears = maxGears;
		this.gears=new ArrayList<>();
		Gear neutral=new Gear(0,0.0);
		this.gears.add(neutral);
	}
	
	
	public void operateCluth(boolean in){
		this.clutchIsIn=in;
	}
	
	public void addGear(int number,double ratio){
		if((number >0) && (number <= maxGears)){
			this.gears.add(new Gear(number,ratio));
		}
	}
	public void changeGear(int newGear){
		if((newGear>=0) && (newGear <this.gears.size()) && this.clutchIsIn){
			this.currentGear=newGear;
			System.out.println("Gea: "+ newGear + " selected");
		}
		else{
			System.out.println("Grind!");
			this.currentGear=0;
		}
	}
	public double wheelSpeed(int revs){
		if (clutchIsIn) {
			System.out.println("Scream!!!");
			return 0.0;
		}
		return revs * gears.get(currentGear).getRatio();
	}
	private  class Gear{
		private int gearNumber;
		private double ratio;
		
		public Gear(int gearNumber, double ratio) {
			super();
			this.gearNumber = gearNumber;
			this.ratio = ratio;
		}
		
		
		
		public int getGearNumber() {
			return gearNumber;
		}



		public void setGearNumber(int gearNumber) {
			this.gearNumber = gearNumber;
		}



		public double getRatio() {
			return ratio;
		}



		public void setRatio(double ratio) {
			this.ratio = ratio;
		}



		public double driverSpeed(int revs){
			return revs *(this.ratio);
		}
		
		
	}
	
	
	
}
