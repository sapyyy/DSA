public class LC1653 {
    public int minimumDeletions(String s) {
        int n = s.length();

        int countA = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == 'a')
                countA++;
        }

        int totalDel = Integer.MAX_VALUE;
        int countB = 0;
        for (int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a')
                countA--;

            totalDel = Math.min(totalDel, countA + countB);

            if (ch == 'b')
                countB++;
        }

        return totalDel;
    }
    public static void main(String[] args) {
        
    }
}
