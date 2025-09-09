package oops;

public class abstraction {

    public static void main(String[] args) {
        // abstract class do not create object
        Horse h = new Horse();
        h.walks();
        h.eat();
        // here abstract class color is printed

        System.out.println(h.color);
        //    if we call changeolor() of Horse class then white will print
        Chicken c = new Chicken();
        c.walks();
        c.eat();
    }
}

abstract class Animal {

    String color;

    // constructor can be made in the abstract class
    Animal() {
        color = "brown";
    }

    // non abstract methods can be there
    void eat() {
        System.out.println("animal eats");
    }

    // nothing is defined in the abstract method
    abstract void walks();
}

class Horse extends Animal {

    // if the non abstract class extends abstracts class then the abstract method in it like walks() must be called
    // and must be defined like walks on 4 legs
    // or make the subclass abstract too
    void walks() {
        System.out.println("walks on 4 legs");
    }

    void changeColor() {
        color = "white";
    }
}

class Chicken extends Animal {

    void walks() {
        System.out.println("walks on 2 legs");
    }

    void changeColor() {
        color = "yellow";
    }
}
