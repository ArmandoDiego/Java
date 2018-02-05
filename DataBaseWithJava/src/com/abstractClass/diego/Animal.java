package com.abstractClass.diego;

public abstract class Animal {
	
	private String name;

	public Animal(String name) {
		this.name = name;
	}
	
	public abstract void eat();
	public abstract void breather();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
