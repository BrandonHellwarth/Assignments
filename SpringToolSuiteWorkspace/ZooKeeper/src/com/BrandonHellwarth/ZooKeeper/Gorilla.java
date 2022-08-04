package com.BrandonHellwarth.ZooKeeper;

public class Gorilla extends Mammal{
	public Gorilla() {}
	
	public int throwSomething() {
		System.out.println("Gorilla throw object!");
		energyLevel -= 5;
		return energyLevel;
	}
	public int eatBananas() {
		System.out.println("Gorilla like eat banana!");
		energyLevel += 10;
		return energyLevel;
	}
	public int climb() {
		System.out.println("Gorilla climb!");
		energyLevel -= 10;
		return energyLevel;
	}
}
