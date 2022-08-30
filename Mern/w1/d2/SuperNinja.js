class Ninja{
    constructor(name, health, speed = 3, strength = 3){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.strength = strength;
    }


    sayName(){
        return console.log(this.name);
    }

    showStats(){
        return console.log("Name:" + this.name,"Strength:" + this.strength,"Speed:" + this.speed,"Health:" + this.health);
    }

    drinkSake(){
        this.health += 10;
        return console.log("Health: " + this.health);
    }
}

class Sensei extends Ninja{
    constructor(name, health = 200, speed = 10, strength = 10, wisdom = 10){
        super(name, health, speed, strength);
        this.wisdom = wisdom;
    }


    speakWisdom(){
        super.drinkSake();
        return console.log("What one programmer can do in one month, two programmers can do in two months.");
    }
}

const ninja1 = new Ninja("Hyabusa", 10);
ninja1.sayName();
ninja1.showStats();
ninja1.drinkSake();
ninja1.drinkSake();

const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
superSensei.showStats();
