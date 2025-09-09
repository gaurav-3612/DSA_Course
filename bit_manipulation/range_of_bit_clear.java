package bit_manipulation;

public class range_of_bit_clear {

    public static void clear(int p, int a, int b) {
// here first we calculate j like 1110000 and then take its OR with k like 0000011 and the finally take AND with p
        int j = ((~0) << (b + 1));
        //0..111 i times equals to 2^i-1
        //2^b=1<<b because a<<i equals a*2^i
        int k = (1 << a) - 1;
        int l = j | k;
        System.out.println(p & l);
    }

    public static void main(String args[]) {
        clear(10, 2, 4);
    }
}
