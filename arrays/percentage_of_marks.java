package arrays;

import java.util.*;
public class percentage_of_marks{
    public static void main(String[] args){
        int marks[] = new int[50];
        System.out.println("length of an array:" + marks.length);
        Scanner sc= new Scanner(System.in);
        marks[0]=50;
        marks[1]=60;
        marks[2]=70;

System.out.println("physics marks:"+marks[0]);
System.out.println("chemistry marks:"+marks[1]);
System.out.println("maths marks:"+marks[2]);

marks[0]=80;
System.out.println(" updated physics marks:"+marks[0]);
int percentage=(marks[0]+marks[1]+marks[2])/3;
System.out.println("percentage:"+percentage);



        


    }
}
