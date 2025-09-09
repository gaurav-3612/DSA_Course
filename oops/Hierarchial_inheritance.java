package oops;

public class Hierarchial_inheritance {

    public static void main(String[] args) {
        Fish f1 = new Fish();
        f1.eat();
        Lion l1 = new Lion();
        l1.eat();
        l1.legs = 4;
        System.out.println(l1.legs);
        l1.roar();
    }
}

class Animal {

    String color;

    void eat() {
        System.out.println("eats");
    }
}

class mammals extends Animal {

    String eyes;

    void roar() {
        System.out.println("roars");
    }
}

class Fish extends Animal {

    String fins;

    void swim() {
        System.out.println("swims");
    }
}
