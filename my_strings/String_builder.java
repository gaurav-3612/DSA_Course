package my_strings;

public class String_builder {

    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.print(sb);

        // here time complexity is O(n) insted of O(n^2) in case if we do str+=ch
        // hence if always we need to make a string which we want to append then we create it by string builder
    }
}
