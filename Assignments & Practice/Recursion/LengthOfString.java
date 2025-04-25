public class LengthOfString {
    public static int findLen(String str){
        // using substring until the string contains null value
        if (str.equals("")){
            return 0;
        }

        // else just add one, until the string contains nothing
        return 1 + findLen(str.substring(1));
    }
    public static void main(String[] args) {
        String str = "Saptadeep";
        System.out.println(findLen(str));
    }    
}
