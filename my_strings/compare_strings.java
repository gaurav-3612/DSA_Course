package my_strings;

public class compare_strings {
    public static void main(String args[]){
        String s1="Tony";
        String s2="Tony";
        String s3=new String("Tony");
        // here by this method s1 and s2 are equal but s1 and s3 are not equal because we have used new keyword to create s3
        // if we do not use new keyword the string takes the previous value if it is stored

        if(s1==s2){
            System.out.println("s1 and s2 strings are equal");
        }
        else {
            System.out.println("s1 ands2 strings are not equal");

        }
        if(s1==s3){
            System.out.println("s1 and s3 strings are equal");
        }
        else{
            System.out.println("s1 and s3 strings are not equal");

        }
        // new method
        System.out.println("Applying correct method");
        System.out.println(s1.equals(s3));
        if(s1.equals(s3)){
            System.out.println("s1 and s3 strings are equal");
        }
        else{
            System.out.println("s1 and s3 strings are not equal");
        }
    }
}
