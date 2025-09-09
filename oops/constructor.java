package oops;

public class constructor {

    public static void main(String[] args) {
        Student s1 = new Student("Gaurav", 5);
        System.out.println(s1.name);
        System.out.println(s1.age);

    }
}

class Student {

    String name;
    int age;

    // in java if we do not create any constructor the compiler automatically creates the null constructor
    // the name of class and constructor should be always same
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
