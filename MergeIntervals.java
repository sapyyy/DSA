import java.util.*;

public class MergeIntervals {
    // wrong approach
    public static int[][] merge(int[][] intervals) {
            List <int[]> list = new ArrayList<>();
            int n = intervals.length;
            boolean[] visited = new boolean[n];

            for (int i=0; i<n; i++){
                if (visited[i]) continue;

                int startI = intervals[i][0];
                int endI = intervals[i][1];
                visited[i] = true;

                for (int j=0; j<n; j++) {
                    if (visited[j] || intervals[j][0] == intervals[j][1]) continue;

                    int startJ = intervals[j][0];
                    int endJ = intervals[j][1];

                    if (endI >= startJ) {
                        startI = Math.min(startI, startJ);
                        endI = Math.max(endI, endJ);
                        visited[j] = true;
                    }
                }

//                System.out.println(Arrays.toString(visited));
                list.add(new int[]{startI, endI});
            }

            return list.toArray(new int[0][]);
    }

    // bruteforce
    public static int[][] mergeBrute(int[][] intervals) {
        int n = intervals.length;
        List <int[]> result = new ArrayList <> ();

        // sorting the arrays first based on the pairs
        Arrays.sort(intervals, new Comparator <int[]> (){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        for (int i=0; i<n; i++) {
            int startI = intervals[i][0];
            int endI = intervals[i][1];

            if (!result.isEmpty() && endI <= result.getLast()[1]) {
                continue;
            }

            for (int j=i+1; j<n; j++){
                if (endI >= intervals[j][0]){
                    endI = Math.max(endI, intervals[j][1]);
                }
                else
                    break;
            }

            result.add(new int[]{startI, endI});
        }

        return result.toArray(new int[0][]);
    }

    public static int[][] mergeOptimal(int[][] intervals) {
        int n = intervals.length;
        List <int[]> result = new ArrayList <> ();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i=0; i<n; i++) {
            if (result.isEmpty() || intervals[i][0] > result.get(result.size() - 1)[1]) {
                result.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            else {
                result.get(result.size() - 1)[1] = Math.max(result.getLast()[1], intervals[i][1]);
            }
        }

        return result.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] result = merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        int[][] result2 = mergeBrute(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        int[][] result3 = mergeOptimal(new int[][]{{2,3}, {4,5}, {6,7}, {8,9}, {1,10}});
//        for (int[] ele : result) {
//            System.out.println(Arrays.toString(ele));
//        }
        for (int[] ele : result3){
            System.out.println(Arrays.toString(ele));
        }
    }
}
