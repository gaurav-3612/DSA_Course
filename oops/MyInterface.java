package oops;

public class MyInterface {

    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
    }
}

interface ChessPlayer {

    // we can only made abstract method i.e not define the method because interface provides 100% abstraction
    void moves();
}

class Rook implements ChessPlayer {

    // we have to make the interface method public
    public void moves() {
        System.out.println("up,down,right,left(desired steps)");
    }
}

class King implements ChessPlayer {

    public void moves() {
        System.out.println("up,down,right,left(only by 1 step)");
    }
}

class Queen implements ChessPlayer {

    public void moves() {
        System.out.println("up,down,right,left,cross(desired steps)");
    }
}
