public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int twenties = 0;

        for (int i=0; i<bills.length; i++) {
            int bill = bills[i];

            if (bill == 10) {
                if (fives > 0) {
                    fives--;
                }
                else return false;
                tens++;
            }
            else if (bill == 20) {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                }
                else if (fives > 2) {
                    fives -= 3;
                }
                else return false;
                twenties++;
            }
            else fives++;
        }

        return true;
    }
}
