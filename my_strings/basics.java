package my_strings;

import java.util.Scanner;

public class basics {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // STRINGS ARE IMMUTABLE
        String str = "abcd";
        str = 'z' + str;
        String str2 = new String("pqrs");
        String name = sc.next();
        Scanner pq = new Scanner(System.in);

        // IMPORTANT NOTE:if we write Scanner sc=new Scanner(System.in) it means we can only take one input by variable sc here and the input
        // will be of the last time sc.next line used. To take two inputs in same program we need to write Scanner line again with some another 
        // vriable name let us say pq
        String FullName = pq.nextLine();
        System.out.println(str);
        System.out.println(str2);
        System.out.println(name);
        System.out.println(FullName);
        System.out.println("hello");
    }
}

// for converting integer to char use (char)(digit+'0')
