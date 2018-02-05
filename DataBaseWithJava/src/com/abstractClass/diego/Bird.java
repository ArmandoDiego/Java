package com.abstractClass.diego;

public abstract class Bird extends Animal {

	public Bird(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(getName() + "is pecking");
	}

	@Override
	public void breather() {
		System.out.println("Breathe in, breathe out, repeat ");
	}
	
	public abstract void fly();

}
