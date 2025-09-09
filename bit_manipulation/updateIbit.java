package bit_manipulation;

public class updateIbit {
 // it means we want 0 at mth place of n binary number
  public static void clearbit(int m,int n){
        int bitmask = ~(1<<n);
        System.out.println(m & bitmask);
    }
 // it means that we want to set 1 at position n of m binary number
  public static void bitSet(int m, int n){
       int bitmask=1<<n;
       System.out.println(m | bitmask);
    }
 // here it is given that at qth position in p binary bit we have to do either 0 or 1 means clear or set bit
  public static void updateIbit (int p, int q, int r){
    if(r==0){
        clearbit(p,q);
    }
    if(r==1){
        bitSet(p,q);
    }
  }
    public static void main(String args[]){
        updateIbit(14,2,0);
        updateIbit(10,2,1);

    }
}
