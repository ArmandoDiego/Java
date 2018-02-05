package com.innerClaseses.diego;

public class Main {
		public static void main(String[] args) {
			Geaxbox mLaren=new Geaxbox(6);
//			Geaxbox.Gear first= mLaren.new Gear(1,12.3);
//			System.out.println(first.driverSpeed(1000));
			mLaren.addGear(1, 5.3);
			mLaren.addGear(2, 10.6);
			mLaren.addGear(3, 15.9);
			mLaren.operateCluth(true);
			mLaren.changeGear(1);
			mLaren.operateCluth(false);
			System.out.println(mLaren.wheelSpeed(1000));
			mLaren.changeGear(2);
			System.out.println(mLaren.wheelSpeed(3000));
			
			
		}
}
