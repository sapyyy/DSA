public class NumberOfSubStringsContainingAllThreeCharacters {
     public int numberOfSubstrings(String s) {
        // s contains a,b,c, minLength = 3 
        // aabbccccaabbcc
        //  brute force 

        int n = s.length();
        int totalSubstrs = 0;
        for (int i=0; i<n; i++) {
            int a = -1;
            int b = -1;
            int c = -1;
            for (int j=i; j<n; j++) {
                char c1 = s.charAt(j); 
                if (c1 == 'a') 
                    a = j;
                else if (c1 == 'b') 
                    b = j;
                else 
                    c = j; 

                if (a > -1 && b > -1 && c > -1) {
                    totalSubstrs += n - (j + 1) + 1;
                    break;
                }
            }
        }

        return totalSubstrs;
    }
    public static void main(String[] args) {
        
    }
}
