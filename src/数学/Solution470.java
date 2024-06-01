package 数学;

import java.util.Random;

public class Solution470 {
    private int rand7() {
        Random random = new Random();
        return random.nextInt(7) + 1;
    }

    // (randX - 1)*Y + randY  ==> [1, X*Y]
    public int rand10() {
        while (true) {
            int num1 = (rand7()-1)*7 + rand7();  // rand49
            if (num1 <= 40) {
                return num1%10 + 1;
            }
            int num2 = (num1-40-1)*7 + rand7();  // rand63
            if (num2 <= 60) {
                return num2%10 + 1;
            }
            int num3 = (num2-60-1)*7 + rand7(); // ranfd21
            if (num3 <= 20) {
                return num3%10 + 1;
            }
        }
    }
}
