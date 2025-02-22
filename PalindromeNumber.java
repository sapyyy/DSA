public class PalindromeNumber {
    static boolean isPalindrome(int x){
        if (x >= 0){
            if (x < 10) return true;
            
            int copyNumber = x;
            int d = 0;
            int reverse = 0;

            while (x > 0){
                d = x % 10;
                reverse = (reverse * 10) + d;
                x /= 10;
            }

            if (copyNumber == reverse) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
