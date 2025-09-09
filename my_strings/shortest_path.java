package my_strings;

import java.util.Scanner;
public class shortest_path {
    public static float shortest(String path){
        int n=path.length();
        int x=0;
        int y=0;
        for(int i=0;i<n;i++){
            if(path.charAt(i)=='e'){
                x++;
            }
            if(path.charAt(i)=='w'){
                x--;
            }
            if(path.charAt(i)=='n'){
                y++;
            }
            if(path.charAt(i)=='s'){
                y--;
            }
        }
        return (float)Math.sqrt(x*x+y*y);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String path=sc.nextLine();
        System.out.println(shortest(path));
        
    }
}
