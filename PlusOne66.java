public class PlusOne66{
    static int[] plusOne(int[] digits){
        // [1,2,3] should change to [1,2,4]
        int lenOfDigit = digits.length;
        long storeSum = 0;
        
        // calculating the sum of all the digits
        for (int i=0; i<lenOfDigit; i++){
            storeSum = (storeSum * 10) + digits[i];
        }
        // adding one to it
        storeSum += 1;
        System.out.println(storeSum);

        // calculating the length of the storeSum to initialize the array finalArray
        lenOfDigit = (int) Math.log10(storeSum);
        lenOfDigit = (int) Math.ceil(lenOfDigit) + 1;

        // initializing the final array with lenOfDigit
        int[] finalArray = new int[lenOfDigit];
        // c here is the counter 
        int c = lenOfDigit - 1; 
        long d = 0; // d stores the last digit after modulus
       
        // taking out the last digits one by one and then assigning it to the array "finalArray"
        while (storeSum > 0 && c >= 0){
            d = storeSum % 10;
            finalArray[c--] = (int) d;
            storeSum = storeSum / 10;
        }
        
        // lastly we return the finalArray
        return finalArray;
    }
    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1,0};
        array = plusOne(array);
        
        for (int val : array){
            System.out.println(val);
        }
    }
}