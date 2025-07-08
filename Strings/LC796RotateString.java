package Strings;

public class LC796RotateString {
    // optimal
    public boolean rotateString(String s, String goal) {
        // when the two string are diff, return
        if (s.length() != goal.length())
            return false;

        // adding the same string should contain the goal
        s += s;

        return s.contains(goal);
    }
}
