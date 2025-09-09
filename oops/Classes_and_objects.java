package oops;

public class Classes_and_objects {

    public static void main(String args[]) {
        Pen p1 = new Pen();
        p1.setColor("blue");
        System.out.println(p1.color);
        // we can also set color without using setColor functon
        p1.color = "yellow";
        System.out.println(p1.color);

    }
}

class Pen {

    String color;
    String tip;

    void setColor(String newColors) {
        color = newColors;
    }
}
//   here Pen is class,
//   p1 is object,
//   color and tip are attributes,
//   set colour is function
