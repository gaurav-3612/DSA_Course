package oops;

public class constructor_hierarchy {

    public static void main(String[] args) {
        Mustang m = new Mustang();
        // animal constructor is called
        // horse constructor is called
        // mustang constructor is called
    }
}

abstract class Animal {

    Animal() {
        System.out.println("animal constructor is called");
    }
}

class Horse extends Animal {

    Horse() {
        super(); // Explicitly call the superclass constructor
        System.out.println("horse constructor is called");
    }
}

class Mustang extends Horse {

    Mustang() {
        super(); // Explicitly call the superclass constructor
        System.out.println("mustang constructor is called");
    }
}
