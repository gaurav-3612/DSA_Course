package pattern;

public class nums_half_pyramid {

    public static void pyramid(int rows) {
        for (int i = 0; i < rows; i++) {
            // if we want to start i also with i=1 the we need to have j limit as j<=rows-i+1
            for (int j = 1; j <= (rows - i); j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        pyramid(10);
    }
}
