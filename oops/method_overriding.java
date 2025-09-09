package oops;

public class method_overriding {

    public static void main(String[] args) {
        deer d = new deer();
        d.eat();
    }
}

class Animal {

    String color;

    void eat() {
        System.out.println("eats");
    }
}

class deer extends Animal {

    String eyes;
// method overrides

    void eat() {
        System.out.println("happily eats");
    }
}
