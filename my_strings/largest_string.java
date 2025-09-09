package my_strings;

public class largest_string {
    public static void main(String args[]){
        // first we define array of string
        String fruits[]={"banana","apple","orange"};
        String largest=fruits[0];
        for(int i=1;i<fruits.length;i++){
            if(largest.compareToIgnoreCase(fruits[i])<0){
                largest=fruits[i];
            }
        }
        System.out.println(largest);
        //TIME COMPLEXITY OF THIS PROBLEM IS O(x*n) and x let be the length of largest string used here
    }
}
