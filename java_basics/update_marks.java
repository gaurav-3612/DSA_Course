package java_basics;

import java.util.*;

public class update_marks {

    public static void update(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 10;

        }
    }

    public static void main(String[] args) {
        int marks[] = new int[3];
        Scanner sc = new Scanner(System.in);
        /*marks [0]=sc.next.Int();
        marks[1]=sc.next.Int();
        marks[2]=sc.next.Int();*/
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextInt();
        }
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }
        update(marks);
        System.out.println("updated marks are:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);

        }

    }

}
