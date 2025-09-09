package arrays;

public class Prefix {
    public static void prefix(int array[]){
        int largest=Integer.MIN_VALUE;
        int prefix[]=new int[array.length];
        prefix[0]=array[0];
        for (int i=1;i<array.length;i++){
        prefix[i]=prefix[i-1]+array[i];
        }
        for(int start=0;start<array.length;start++){
            for(int end=start;end<array.length;end++){
                int sum=start==0? prefix[end]:prefix[end]-prefix[start-1];
                if(sum>largest){
                    largest=sum;
                }
            }
        }
        System.out.println(largest);

    }
    public static void main(String[] args){
        int array[]={2,4,6,7,8,9};
        prefix(array);

    }
    
}
