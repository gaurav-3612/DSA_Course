package oops;

public class Static_keyword {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.set_name("Gaurav");
        s1.roll = 20;

        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println(s1.get_name()); // Corrected

        // System.out.println(s2.get_name()); // Will print null
        // System.out.println(s3.get_name()); // Will print null
        s1.schoolName = "svm";
        System.out.println(s1.schoolName);

    }
}

class Student {

    String name;
    int roll;

    static String schoolName;

    static int percentage(int maths, int phy, int chem) {
        return (maths + phy + chem) / 3;
    }

    void set_name(String name) {
        this.name = name;
    }

    String get_name() {
        return this.name;
    }
}
