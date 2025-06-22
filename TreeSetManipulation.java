import java.util.*;
public class TreeSetManipulation {
    public static int extractFirstEle(Integer digit){
        while (digit > 10) {
            digit /= 10;
        }

        return digit;
    }
    public static void main(String[] args) {
        Comparator <Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int diff = extractFirstEle(o1)-extractFirstEle(o2);
                return diff == 0? o1 - o2 : diff;
            }
        };

        TreeSet <Integer> tree = new TreeSet <> (comp);

        int n = 20;
        for (int i=0; i<n; i++){
            tree.add(i);
        }

        System.out.println(tree);
    }
}
