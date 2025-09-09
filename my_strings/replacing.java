package my_strings;

public class replacing {

    public static void main(String args[]) {
        String str = "Gaurav Sharma";
        // although the strings are immutable but still replacing takes place here beacause there is no change comes in the str but 
        // new string id created with the same variable name we can cross check this with the help of hashside printing
        str = str.replace('a', 'x');
        System.out.println(str);
    }
}
