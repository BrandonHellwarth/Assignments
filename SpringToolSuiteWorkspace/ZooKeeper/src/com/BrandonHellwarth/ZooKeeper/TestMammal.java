package com.BrandonHellwarth.ZooKeeper;

public class TestMammal {

	public static void main(String[] args) {
		Gorilla John = new Gorilla();
		John.throwSomething();
		John.throwSomething();
		John.throwSomething();
		John.eatBananas();
		John.eatBananas();
		John.climb();
		John.displayEnergy();
		
		Bat Bruce = new Bat();
		Bruce.attackTown();
		Bruce.attackTown();
		Bruce.attackTown();
		Bruce.eatHumans();
		Bruce.eatHumans();
		Bruce.fly();
		Bruce.fly();
		Bruce.displayEnergy();
	}
}
