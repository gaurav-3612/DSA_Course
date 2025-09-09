package oops;

public class multi_interface_inheritance {

    public static void main(String[] args) {
        Beer b = new Beer();
        b.grass_eater();
        b.meat_eater();
    }
}

interface Herbivorous {

    void grass_eater();
}

interface Carnivorous {

    void meat_eater();
}

class Beer implements Herbivorous, Carnivorous {

    public void grass_eater() {
        System.out.println("eats grass");
    }

    public void meat_eater() {
        System.out.println("eats meats");
    }
}
