public class Candy {

    public int candy(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;

        while (i < n) {
            // if the slope is flat
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            // if the slope is increasing
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // if the slope is decreasing
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                i++;
                down++;
            }

            if (down > peak) sum += down - peak;
        }

        return sum;
    }
}
