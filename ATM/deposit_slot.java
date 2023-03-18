import java.util.*;
import java.text.*;

public class deposit_slot implements ATM {
    private int MM, D, CC, C, L, XX, X, xx, x, v, ii, i;
    Scanner scan = new Scanner(System.in);

    public void deposit_denominations(int money) {
        // takes the number of all denominations of money
        while (true) {
            System.out.println("Enter the denomination of the notes that are deposited.");
            System.out.print("Rs.2000 : ");
            MM = scan.nextInt();
            System.out.print("Rs.500  : ");
            D = scan.nextInt();
            System.out.print("Rs.200  : ");
            CC = scan.nextInt();
            System.out.print("Rs.100  : ");
            C = scan.nextInt();
            System.out.print("Rs.50   : ");
            L = scan.nextInt();
            System.out.print("Rs.20   : ");
            XX = scan.nextInt();
            System.out.print("Rs.10   : ");
            X = scan.nextInt();
            System.out.println("Enter the denomination of the coins that are deposited.");
            System.out.print("Rs.20 : ");
            xx = scan.nextInt();
            System.out.print("Rs.10 : ");
            x = scan.nextInt();
            System.out.print("Rs.5  : ");
            v = scan.nextInt();
            System.out.print("Rs.2  : ");
            ii = scan.nextInt();
            System.out.print("Rs.1  : ");
            i = scan.nextInt();
            int amount_chosen = 2000 * MM + 500 * D + 200 * CC + 100 * C + 50 * L + 20 * XX +
                    10 * X + 20 * xx + 10 * x + 5 * v + 2 * ii + 1 * i;
            if (amount_chosen == money) {
                break;
            } else {
                System.out.println("The amount doesn't match, please enter valid denominations again.");
            }
        }

    }
}
