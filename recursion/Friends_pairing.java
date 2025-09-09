package recursion;

public class Friends_pairing {

    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        // standing in single choices
        int fnm1 = pairing(n - 1);

        // standing in pairs
        int fnm2 = (n - 1) * pairing(n - 2);

        return fnm1 + fnm2;
    }

    public static void main(String[] args) {
        System.out.println(pairing(3));
    }
}
/*
 Enumeration for n = 5:
1. All single (1 way)

{A} {B} {C} {D} {E}

2. One pair + 3 singles (10 ways)

Pick 2 friends to pair, rest are singles.
2. {AB} {C} {D} {E}
3. {AC} {B} {D} {E}
4. {AD} {B} {C} {E}
5. {AE} {B} {C} {D}
6. {BC} {A} {D} {E}
7. {BD} {A} {C} {E}
8. {BE} {A} {C} {D}
9. {CD} {A} {B} {E}
10. {CE} {A} {B} {D}
11. {DE} {A} {B} {C}

3. Two pairs + 1 single (15 ways)

Pick 4 friends, split into 2 pairs, last one is single.

{AB} {CD} {E}

{AB} {CE} {D}

{AB} {DE} {C}

{AC} {BD} {E}

{AC} {BE} {D}

{AC} {DE} {B}

{AD} {BC} {E}

{AD} {BE} {C}

{AD} {CE} {B}

{AE} {BC} {D}

{AE} {BD} {C}

{AE} {CD} {B}

{BC} {DE} {A}

{BD} {CE} {A}

{BE} {CD} {A}

✅ Total = 26 ways
 */
