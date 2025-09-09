package Miscellaneous;
// gfg->

class StepKArray {

    public int findStepKeyIndex(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        // handle k == 0 separately (to avoid division by zero)
        if (k == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == x) {
                    return i;
                }
            }
            return -1;
        }

        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] == x) {
                return i;              // first occurrence found
            }
            // compute safe jump using long to avoid overflow
            long diff = Math.abs((long) arr[i] - (long) x);
            int jump = (int) (diff / k);   // floor division
            if (jump < 1) {
                jump = 1;       // always advance at least one step

                        }i += jump;
        }

        return -1; // not found
    }
}
