package oops;

public class CopyConstructor {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Gaurav";
        s1.age = 20;
        s1.password = "Gaurav123";
        s1.marks[0] = 50;
        s1.marks[1] = 70;
        s1.marks[2] = 90;

        Student s2 = new Student(s1);
        s2.password = "Ram123";  // Changing s2's password should not affect s1

        System.out.println(s2.name);  // Output: Gaurav
        System.out.println(s2.age);   // Output: 20
        System.out.println(s2.password); // Output: Ram123
        System.out.println(s1.password); // Output: Gaurav123

        // Checking deep copy
        s2.marks[0] = 100; // Modifying s2's marks should not affect s1

        System.out.println("s1 marks[0]: " + s1.marks[0]); // Should be 50
        System.out.println("s2 marks[0]: " + s2.marks[0]); // Should be 100
    }
}

class Student {

    String name;
    int age;
    String password;
    int marks[] = new int[3];

    // Default Constructor
    Student() {
    }

    // Copy Constructor (Deep Copy)
    Student(Student s1) {
        this.name = s1.name;
        this.age = s1.age;
        this.password = s1.password;

        // Deep copy of array
        this.marks = new int[3];
        for (int i = 0; i < 3; i++) {
            this.marks[i] = s1.marks[i];
        }
        //if we do not use for loop to change idex wise then that was called shallow copy and i will also change s1 marks
        // if we make any change in s2 marks
    }
}
