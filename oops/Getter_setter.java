package oops;

public class Getter_setter {

    public static void main(String[] args) {
    }
}

class Pen {

    private String color;
    public String tip;

    // getter for color as it is private
    String getColor() {

        return this.color;
    }

    // setter for color as it is private
    void setColor(String color) {
        this.color = color;
    }

    // no need of getter and setter for tip as it is public
}
