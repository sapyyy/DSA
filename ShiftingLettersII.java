public class ShiftingLettersII {
    static String shiftingLetters(String s, int[][] shifts){
        for (int i=0; i<shifts.length; i++){
            // store the shifted letters here
            // String shiftedLetters = "";
            StringBuilder shiftedLetters = new StringBuilder(s);

            for (int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                // if the j in the range of the shifts perform operation
                if (j >= shifts[i][0] && j <= shifts[i][1]){
                    // move the letters forward 
                    if (shifts[i][2] == 1){
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
            // change s everytime here
            s = shiftedLetters.toString();
        }
        // finally return the s
        return s;
    }
    public static void main(String[] args) {
        String sInp = "abc";
        int[][] shiftsInp = {{0,1,0},{1,2,1},{0,2,1}};

        String output = shiftingLetters(sInp, shiftsInp);
        System.out.println("The output : "+output);
    }
}
