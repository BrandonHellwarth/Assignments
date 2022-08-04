package com.BrandonHellwarth.ZooKeeper;

public class Bat extends Mammal {
	public Bat() {
		this.energyLevel = 300;
	}
	public int fly() {
		System.out.println("A bat takes flight...");
		energyLevel -= 50;
		return energyLevel;
	}
	public int eatHumans() {
		System.out.println("AHHHHHHHH!... 'GULP'");
		energyLevel += 25;
		return energyLevel;
	}
	public int attackTown() {
		System.out.println("Bat breaths fire on town!");
		energyLevel -= 100;
		return energyLevel;
	}
}
