package com.interfaces.diego;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {
	
	private String name;
	private int hitPointes;
	private int strength;
	private String weapon;
	
	public Player(String name, int hitPointes, int strength) {
		this.name = name;
		this.hitPointes = hitPointes;
		this.strength = strength;
		this.weapon = "Sword";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHitPointes() {
		return hitPointes;
	}

	public void setHitPointes(int hitPointes) {
		this.hitPointes = hitPointes;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hitPointes=" + hitPointes + ", strength=" + strength + ", weapon=" + weapon
				+ "]";
	}

	@Override
	public List<String> write() {
		List<String> values=new ArrayList<>();
		values.add(0,this.name);
		values.add(1,""  + this.hitPointes);
		values.add(2, "" + this.strength);
		values.add(3, this.weapon);
		return values;
	}

	@Override
	public void read(List<String> savedValues) {
		if(savedValues != null && savedValues.size() > 0){
			this.name=savedValues.get(0);
			this.hitPointes=Integer.parseInt(savedValues.get(1));
			this.strength=Integer.parseInt(savedValues.get(2));
			this.weapon=savedValues.get(3);
		}
	}
	
}
