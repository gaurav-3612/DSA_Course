package oops;

public class Multilevel_Inheritance {

    public static void main(String[] args) {
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

class Lion extends mammals {

    int legs;

    void jump() {
        System.out.println("jumps");

    }
}
