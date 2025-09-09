package oops;

public class Method_overloading {

    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.sum(5, 6);
    }
}

class Calculator {

    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}
