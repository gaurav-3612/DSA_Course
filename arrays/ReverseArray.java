package arrays;

public class ReverseArray {
    public static void ReverseArray(int array[]){
        int start=0;
        int end=array.length-1;
        int temp;
        while(start<=end){
             temp=array[start];
             array[start]=array[end];
             array[end]=temp;
             start++;
             end--;
        }
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }

    }
    public static void main(String[] args){
        int array[]={2,3,5,6,8,9,0};
        ReverseArray(array);

    }
    
}

