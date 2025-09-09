package my_strings;

public class UpperCaseConversion {

    public static void convert(String str) {
        StringBuilder sb = new StringBuilder("");
        sb.append(Character.toUpperCase(str.charAt(0)));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(' ');
                sb.append(Character.toUpperCase(str.charAt(i + 1)));
                i++;
                // here we only did i++ but we appended two chars because inside for loop also there is one i++
            } else {
                sb.append(str.charAt(i));
            }
        }
        System.out.println(str);
        System.out.println(sb);
    }

    public static void main(String args[]) {
        String str = "hello, my name is gaurav";
        convert(str);
    }
}
//  sb.append(Character.toUpperCase(s.charAt(i)));


/*
  if (Character.isLetter(ch)) {  // ✅ only letters
                sb.append(ch);
    }
    
      if (Character.isLetterOrDigit(ch)) {  // ✅ only letters and numbers
                sb.append(ch);
            }
 */
