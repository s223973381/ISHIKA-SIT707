package sit707_week6;

public class LoopUtils {

    // Function 1: conditional loop with simple statements
    public static int sumToN(int n) {
        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }

        return sum;
    }

    // Function 2: conditional loop with conditional statement inside
    public static int countEvenNumbers(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}