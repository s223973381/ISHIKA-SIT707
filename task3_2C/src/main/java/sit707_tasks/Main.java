package sit707_tasks;

/**
 * Demonstrates equivalence class examples for DateUtil.
 * @author Ishika Mandal
 */
public class Main {
    public static void main(String[] args) {

        // EC1: Normal day in 31-day month
        DateUtil date = new DateUtil(15, 1, 1994);
        System.out.println("EC1 before increment: " + date);
        date.increment();
        System.out.println("EC1 after increment:  " + date);

        // EC2: End of 30-day month
        date = new DateUtil(30, 6, 1994);
        System.out.println("EC2 before increment: " + date);
        date.increment();
        System.out.println("EC2 after increment:  " + date);

        // EC3: Leap year February
        date = new DateUtil(29, 2, 2024);
        System.out.println("EC3 before increment: " + date);
        date.increment();
        System.out.println("EC3 after increment:  " + date);

        // EC4: Year-end transition
        date = new DateUtil(31, 12, 2023);
        System.out.println("EC4 before increment: " + date);
        date.increment();
        System.out.println("EC4 after increment:  " + date);

        // EC5: Decrement example from March 1 in leap year
        date = new DateUtil(1, 3, 2024);
        System.out.println("EC5 before decrement: " + date);
        date.decrement();
        System.out.println("EC5 after decrement:  " + date);
    }
}