import java.util.Arrays;

public class NumberOfStringsContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        // s contains a,b,c, minLength = 3 
        // aabbccccaabc
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
                    totalSubstrs += n - j;
                    break;
                }
            }
        }

        return totalSubstrs;
    }
    public int numberOfSubstrings1(String s) {
        // optimal
        int totalSubstrs = 0;
        int n = s.length();
        int[] arr = new int[3];
        Arrays.fill(arr, -1);
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            arr[c - 'a'] = i;

            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                totalSubstrs += Math.min(arr[0], Math.min(arr[1], arr[2])) + 1;
            }
        }

        return totalSubstrs;
    }
    public static void main(String[] args) {
        
    }
}
