package oops;

public class super_keyword {

    public static void main(String[] args) {
        Horse h = new Horse();
        // In Java, when you create a subclass object, its superclass constructor always runs first,
        //  unless the superclass has no accessible constructor

        // animal constructor is called
        // Horse constructor is called
    }
}

class Animal {

    String color;

    Animal() {
        System.out.println("animal constructor is called");
    }
}

class Horse extends Animal {
// super keyword is only used inside the constructor

    Horse() {
        // one superkeyword at a time
        super.color = "white";
        // super(); it automatically gets called
        System.out.println("Horse constructor is called");
    }
}
