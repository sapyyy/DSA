public class BinaryExpo {
    public static double checkPow(double x, int n) {
        // changing the sing of n to pos for easier pow calculation
        long pow = n < 0 ? (long) -1 * n : n;

        // calculating the result 
        double result = calPow(x, pow);

        // if the n is neg, return the result as 1/result
        return  n < 0 ? 1 / result : result;
    }

    // binary exponentiation : O(log n)
    public static double calPow(double x, long n) {
        if (n == 0 || x == 1) return 1.0;

        // if odd then make it even by removing one x
        if (n % 2 == 1) {
            return x * calPow(x, n - 1);
        }
        // for even n, we divide it by 2 everytime 
        else {
            return calPow(x * x, n / 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(checkPow(2, 3));
        System.out.println(checkPow(2, -3));
    }
}
