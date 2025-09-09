package pattern;

public class hollow_rhombus {

    public static void rhombus(int row) {
        for (int i = 1; i <= row; i++) {
            // starting spaces
            for (int j = 1; j <= (row - i); j++) {
                System.out.print(" ");
            }
            // stars and inside space
            for (int j = 1; j <= row; j++) {
                if (j == 1 || j == row || i == 1 || i == row) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rhombus(7);
    }
}
