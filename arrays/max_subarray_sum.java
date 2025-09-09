package arrays;

public class max_subarray_sum {
    public static void maxsum(int array[]){
        int maximum=Integer.MIN_VALUE;
        int curr=0;
     for(int i=0;i<array.length-1;i++){
        for(int j=i+1;j<array.length;j++){
            for(int p=i;p<=j;p++){
                curr=curr+array[p];
            }
            System.out.println("sum of subarray"+curr);
            if(curr>maximum){
                maximum=curr;
            }
        }
        curr=0;
      }
      System.out.println("maximum subarray sum is "+maximum);

    }
    public static void main(String[] args) {
        int array[]={-2,-3,4,-1,-2,1-5,-3};
        maxsum(array);
    }
}
