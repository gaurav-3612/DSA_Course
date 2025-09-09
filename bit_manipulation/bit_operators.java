package bit_manipulation;

public class bit_operators {
    public static void main (String args[]){
        int a=5;
        int b=6;
        // AND operator
        System.out.println((a & b));

        // OR operator
        System.out.println((a | b));

        // XOR operator 0 for same and 1 for different bits
        System.out.println((a ^ b));

        // binary one's complement
        //  for this first we covert number into binary and then calculate its 2's complement by taking its complement again and then
        // adding 1 to it and then again coverting it into binary
        System.out.println((~5));
        System.out.println((~0));

        // binary left shift 
        // shifting a value towards left anf filling empty spaces with 0
        // a<<b=a*2^b
        System.out.println((5<<2));

        // binary right shift 
        // shifting a value towards right anf filling empty spaces with 0
        // a>>b=a/2^b
        System.out.println((6>>1));
    }
}
