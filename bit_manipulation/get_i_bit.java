package bit_manipulation;

public class get_i_bit {
    public static int getIbit(int n,int i){
        int bitmask=1<<i;
        int result=(bitmask & n);
        if(result==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static void main(String args[]){
        System.out.println(getIbit(10,2));
        }
}
