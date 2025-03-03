import java.util.*;
public class MergeArrays{
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List <int[]> finalList = new ArrayList <> ();

        // starting indexes for the first and the second array
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i][0] < nums2[j][0]){
                finalList.add(nums1[i]);
                i++;
            }
            else if (nums2[j][0] < nums1[i][0]){
                finalList.add(nums2[j]);
                j++;
            }
            else {
                // when the indexes are same for the both arrays
                int sum = nums1[i][1] + nums2[j][1];
                finalList.add(new int[]{nums1[i][0],sum});
                i++;
                j++;
            }
        }

        while (i < nums1.length){
            finalList.add(nums1[i++]);
        }

        while (j < nums2.length){
            finalList.add(nums2[j++]);
        }
        
        return finalList.toArray(new int[finalList.size()][2]);
    }
    public static void main(String[] args) {
        int[][] finalList = mergeArrays(new int[][]{{1,2},{2,3},{4,5}}, new int[][]{{1,4},{3,2},{4,1}});
        
        for (int[] ele : finalList){
            System.out.println(ele[0] + " " + ele[1]);
        }
    }
}