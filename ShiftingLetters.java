public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts){
        StringBuilder shiftedLetters = new StringBuilder(s);

        for (int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            // if the j in the range of the shifts perform operation
            if (j >= shifts[0] && j <= shifts[1]){
                // move the letters forward 
                if (shifts[2] == 1){
                    // when z, c will increment to a
                    if (c == 'z'){
                        c = 'a';
                    }
                    else{
                        ++c;
                    }
                }
                // move the letters backward
                else {
                    // when a the letters will decrement to z
                    if (c == 'a'){
                        c = 'z';
                    }
                    else --c;
                }
                shiftedLetters.setCharAt(j, c);;
            }
        }
        s = shiftedLetters.toString();
        // finally return the s
        return s;
    }
    public static void main(String[] args) {
        String sInp = "abc";
        int[] shiftsInp = {0,1,0};
        System.out.println(shiftingLetters(sInp, shiftsInp));
    }
}
