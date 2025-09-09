package oops;

public class Inheritance {

    public static void main(String[] args) {
        Fish f1 = new Fish();
        // we cannot print the void return function so this gives error
        // System.out.println(f1.eat());

        f1.eat();
    }
}

class Animal {

    String color;

    void eat() {
        System.out.println("eats");
    }

    void move() {
        System.out.println("moves");
    }
}

// single level inheritance
class Fish extends Animal {

    String fins;

    void swim() {
        System.out.println("swims");
    }
}
