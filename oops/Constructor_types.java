package oops;

public class Constructor_types {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Gaurav");
        Student s3 = new Student("ram");
        Student s4 = new Student(20);
        //  we did not make any constructor of this type
        // Student s5 = new Student("shyam", 20);
    }
}

class Student {

    String name;
    int roll;
    // if we do not define any constructor then by default null constructor is created
    // but we defined any constructor and we need to use null constructor then we must need to define it

    // non parametrized constructor
    Student() {
        System.out.println("the null constructor is called");
    }

    // parametrized constructor
    Student(String name) {
        this.name = name;
    }

    Student(int roll) {
        this.roll = roll;
    }
}
