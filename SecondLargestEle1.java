public class SecondLargestEle1 {
    public static void main(String[] args) {
        int arr[] = {-232,3223,34353,533,2113,323,-3249};

        int maxEle = Integer.MIN_VALUE;
        int secondMaxEle = Integer.MIN_VALUE;

        for (int i : arr){
            if (i > maxEle){
                secondMaxEle = maxEle;
                maxEle = i;
            }
            else if (i > secondMaxEle && i < maxEle){
                secondMaxEle = i;
            }
        }

        System.out.println(maxEle + " " +secondMaxEle);
    }
}
