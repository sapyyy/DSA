/*Question 3
 * (a) = S = 2 + 4 + 6 + 8 + ... + N (input N)
 * (b) = S = 1^2 - 3^2 + 5^2 - 7^2 + ... -/+ N (input N)
 */
public class Series {
    public static int seriesOne(int n){
         if (n == 1)
            return 2;

        return (n * 2) + seriesOne(n - 1);        
    }
    public static int seriesTwo(int n){
        if (n == 1)
            return 1;

        int val = (n * 2) - 1;

        if (n % 2 == 0)
            return (val * val) + seriesTwo(n - 1);
        else
            return (val * val) - seriesTwo(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(seriesOne(4));
        System.out.println(seriesTwo(3));
    }
}
