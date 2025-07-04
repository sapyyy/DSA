public class KthCharacterInStringGame {
    public static char kthCharacter(int k) {
        StringBuilder str = new StringBuilder("a");

        while (str.length() <= k * 2) {
            for (int i = 0; i < str.length(); i++) {
                int c = (byte) str.charAt(i);

                char nextC = c == 125 ? 'a' : (char) (c + 1);
                str.append(nextC);
            }
        }

        return str.charAt(k - 1);
  }
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}