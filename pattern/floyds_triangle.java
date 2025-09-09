package pattern;

public class floyds_triangle {

    public static void floyds(int row) {
        int counter = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                if (i < row) {
                    System.out.print(" ");
                }
                counter++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        floyds(5);
    }
}
