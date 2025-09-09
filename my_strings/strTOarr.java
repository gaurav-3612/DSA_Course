package my_strings;

public class strTOarr {

    public static void main(String args[]) {
        String str1 = "Gaurav";
        String str2 = "hello my name is gaurav";

        // string to array of character by toCharArray() function
        char CharArray[] = str1.toCharArray();
        for (int i = 0; i < CharArray.length; i++) {
            System.out.print(CharArray[i] + " ");
        }

        System.out.println();

        // string to array of words by split() function
        String wordArray[] = str2.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(wordArray[i] + " ");
        }

        // TO MAKE ARRAY OF WORDS AND REMMOVING COMMA AND GAP AND ALSO TO LOWER CASE
        String str = "A man, a plan, a canal: Panama";

        // Convert to lowercase and split on non-alphabetic characters
        String[] words = str.toLowerCase().split("[^a-z]+");

        // Print the clean words
        for (String w : words) {
            if (!w.isEmpty()) { // avoid empty strings from split
                System.out.println(w);
            }
        }
    }
}
/*
 ✅ 1. String.valueOf(int i)

General-purpose method in the String class.
Can take any type (int, long, float, double, boolean, char, Object, char[]) and convert it to a string.
If you pass an object, it calls the object’s .toString() method.
Safe for null → returns "null" instead of throwing an exception.

Integer num = null;
String s = String.valueOf(num);  
System.out.println(s); // "null" (no exception)


✅ 2. Integer.toString(int i)

Specific to the Integer class.
Only works for int (or Integer).
Slightly faster in principle because it’s specialized for integers.
Throws NullPointerException if you pass a null Integer.

Integer num = null;
String s = Integer.toString(num); // ❌ NullPointerException

 */
