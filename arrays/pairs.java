package arrays;

public class pairs {

    /*
        in Java, every method must be part of a class, 
       because Java is a purely object-oriented language (except for primitive types).

       So while pairs() is a method, it is defined inside a class called pairs
     */

 /*
           If you remove static, you must first create an object of the class:

             public static void main(String[] args) {
             int array[] = { 2, 4, 6, 8, 9 };
             pairs obj = new pairs();     // create an object
             obj.pairs(array);            // call the method using the object
}
     */
    public static void pairs(int array[]) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.print("(" + array[i] + "," + array[j] + ")");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int array[] = {2, 4, 6, 8, 9};
        pairs(array);

    }
}
