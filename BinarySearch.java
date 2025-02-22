public class BinarySearch {
    public static void main (String[] args){
        int[] arr = {3,4,5,6,7};

        // binary search
        int key = 7;
        int first = 0;
        int last = arr.length - 1;
        boolean found = false;
        int counter = 0; // to see how many times the loop executes
        
        while (first <= last){
            System.out.println(++counter);
            int mid = (first + last)/2;
            if (arr[mid] == key){
                System.out.println("Element found at postion : "+mid);
                found = true;
                break;
            }
            else if (arr[mid] < key){
                first = mid + 1;
            }
            else last = mid - 1;
        }

        if (!found){
            System.out.println("The element is not present in the array.");
        }
    }
}
