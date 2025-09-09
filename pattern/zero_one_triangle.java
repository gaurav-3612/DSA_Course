package pattern;

public class zero_one_triangle {

    public static void triangle(int rows) {
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            if ((i % 2) == 0) {
                counter = 1;
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(counter + " ");
                if (counter == 1) {
                    counter = 0;
                } else {
                    counter = 1;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        triangle(8);
    }
}
