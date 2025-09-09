package java_basics;

public class Basics {

    public static void main(String[] args) {

    }
}
/*
 Java Notes: Static, Main, and Command-Line Arguments
1. static Keyword
For Methods

static means the method belongs to the class, not an object.

Can be called without creating an instance.

Useful for:

Utility/helper methods (Math.sqrt(), Collections.sort())

Shared behavior across all instances

Cannot access instance variables directly inside a static method.

Example:

class MathUtils {
    static int square(int x) { return x * x; }
}
System.out.println(MathUtils.square(5)); // 25

For Classes

Only nested classes can be static.

static class = nested class without a reference to the outer class.

Top-level classes cannot be static.

Useful for:

Grouping helper classes logically

Avoiding unnecessary outer references

Example:

class Garage {
    static class Car {
        void drive() { System.out.println("Car is driving!"); }
    }
}

Garage.Car red = new Garage.Car();
red.drive(); // Car is driving!

2. main Method
Signature
public static void main(String[] args)

Modifier	Meaning
public	JVM can access it from anywhere
static	JVM can call it without creating an object
void	No return value to JVM
main	Fixed method name; JVM looks for it as the entry point
String[] args	Command-line arguments passed to program
Why static?

JVM needs a guaranteed entry point without creating objects.

Prevents startup failure if constructors throw exceptions.

Makes program startup simple and predictable.

Example:

public static void main(String[] args) {
    System.out.println("Program started");
}

Why not everything static?

Static methods cannot access instance variables.

Non-static methods allow object-specific behavior.

Example: Car.drive() uses color of that object.

class Car {
    String color;
    Car(String color) { this.color = color; }
    void drive() { System.out.println(color + " car is driving!"); }
}
Car red = new Car("Red");
red.drive(); // Red car is driving!

3. String[] args
Definition

Array of strings containing command-line arguments.

args[0], args[1], … represent inputs passed while running the program.

Example:

java Main Alice Bob

public static void main(String[] args) {
    System.out.println(args[0]); // Alice
    System.out.println(args[1]); // Bob
}

Why use it?

To provide external input at runtime.

Allows programs to be configurable without recompiling.

Inspired by C/C++’s argc/argv.

What if we don’t use it?

JVM still requires String[] args in the signature.

You can ignore it in code, but must include it for JVM to recognize main.

4. Class Access Modifiers
Modifier	Scope	Notes
public	Everywhere	Must match file name; used for classes meant to be API
default (no modifier)	Package	Only accessible in the same package; good for helper/internal classes

Rules:

Only one public top-level class per file.

Top-level classes cannot be static.

Nested classes can be static.

5. Key Takeaways

static main ensures program starts reliably, without creating objects.

non-static methods allow object-specific state and behavior.

String[] args allows programs to receive input from the command line.

static nested classes are for organization and independence from outer objects.

public is for accessibility, default is for internal use.
 */
