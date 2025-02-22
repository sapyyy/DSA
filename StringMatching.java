import java.util.*;

class Solution {
    public static List<String> stringMatching(String[] words) {
        // subStr arraylist which contains all the substrings
        List <String> subStr = new ArrayList <> ();
        // takes O(n^2) time complexity
        for (int i=0; i<words.length; i++){
            for (int j=0; j<words.length; j++){
                // condition to check the substring
                if (words[i].contains(words[j]) && i != j){
                    // add to the subStr only when the subStr doesn't contain the word[j]
                    if (!(subStr.contains(words[j]))){
                        subStr.add(words[j]);
                    }
                }
            }
        }

        // finally return the subStr
        return subStr;
    }
}

public class StringMatching {
    public static void main (String [] args){
        String[] wordsInp = {"mon","ana","monkey", "banana", "starfish", "an", "fish"};
        System.out.println(Solution.stringMatching(wordsInp));
        
    }
}
