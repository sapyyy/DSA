public class LC2749 {
        public int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long x = 1L * num1 - 1L * k * num2;

            if (x < k) 
               return -1;
            if (Long.bitCount(x) <= k) 
               return k;
        }

        return -1;
    }

    public static void main(String[] args) {
        
    }
}
