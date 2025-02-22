public class FirstBadVersion {
    public static boolean isBadVersion(int n){
        return ((int) Math.round(Math.random())) == 1 ? true : false;
    }
    public int firstBadVersion(int n) {
        int first = 0;
        int last = n;
        
        while (first <= last){
            int mid = (first + last)/2;

            if (isBadVersion(mid) == false){
                
            }
        }

        return 3;
    }
    public static void main (String[] args){
        System.out.println(isBadVersion(34));
        System.out.println(isBadVersion(34));
        System.out.println(isBadVersion(34));
        System.out.println(isBadVersion(34));
        System.out.println(isBadVersion(34));
    }
}