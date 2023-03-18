import java.util.*;
import java.text.*;

class dispenser implements ATM {
    private int notes_2000, notes_500, notes_200, notes_100, notes_50, notes_20, notes_10;
    private int coins_5, coins_2, coins_1;

    public void dispense_cash(int money) {
        int k = money;
        notes_2000 = k / 2000;
        k = k - 2000 * notes_2000;
        notes_500 = k / 500;
        k = k - 500 * notes_500;
        notes_200 = (k) / 200;
        k = k - 200 * notes_200;
        notes_100 = (k) / 100;
        k = k - 100 * notes_100;
        notes_50 = (k) / 50;
        k = k - 50 * notes_50;
        notes_20 = (k) / 20;
        k = k - 20 * notes_20;
        notes_10 = (k) / 10;
        k = k - 10 * notes_10;
        coins_5 = (k) / 5;
        k = k - 5 * coins_5;
        coins_2 = (k) / 2;
        k = k - 2 * coins_2;
        coins_1 = (k);
        k = k - coins_1;
        if (k == 0) {
            System.out.println("The withdrawal of the amount Rs." + money + " is successful, collect your cash.");
            System.out.println("number of Rs.2000 notes = " + notes_2000);
            System.out.println("number of Rs.500 notes = " + notes_500);
            System.out.println("number of Rs.200 notes = " + notes_200);
            System.out.println("number of Rs.100 notes = " + notes_100);
            System.out.println("number of Rs.50 notes = " + notes_50);
            System.out.println("number of Rs.20 notes = " + notes_20);
            System.out.println("number of Rs.10 notes = " + notes_10);
            System.out.println("number of Rs.5 coins = " + coins_5);
            System.out.println("number of Rs.2 coins = " + coins_2);
            System.out.println("number of Rs.1 coins = " + coins_1);
        }
    }

}