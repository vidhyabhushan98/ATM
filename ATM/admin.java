interface ATM {

    int get_balance();

    void replenish_ATMbalance();

    void close_ATM();

    void open_ATM();

    void dispense_cash();

    void deposit_denominations();
}

public class admin implements ATM {
    int money, num_accounts, new_accounts, witdrws, deps, trs;
    boolean ATM_status = false;
    private String admin_pass = "cs21b030ATM";

    public String getpassword() {
        return admin_pass;
    }

    public boolean getATM_status() {
        return ATM_status;
    }

    public void set_ATMstatus(boolean ATM_status) {
        this.ATM_status = ATM_status;
    }

    public int get_balance() {
        return money;
    }

    public void set_ATMbalance(int money) {
        this.money = money;
    }

    public void replenish_ATMbalance() {
        set_ATMbalance(1000000);
    }

    public void get_todaysreport() {
        // gets the all things happened in ATM today
        System.out.println("__________________________________________________");
        System.out.println("Number of current accounts : " + num_accounts + ".");
        System.out.println("Number of accounts created today : " + new_accounts + ".");
        System.out.println("Todays opening balance : " + "Rs.1000000");
        System.out.println("Money withdrawn through all transactions today : Rs." + witdrws + "/-");
        System.out.println("Money deposited through all transactions today : Rs." + deps + "/-");
        System.out.println("Money transferred through all transactions today : Rs." + trs + "/-");
        System.out.println("Todays closing balance : " + "Rs." + get_balance() + "/-");
    }

    public void update_withdrawals(int witdrws) {
        this.witdrws = witdrws;
    }

    public void update_deposits(int deps) {
        this.deps = deps;
    }

    public void update_transfers(int trs) {
        this.trs = trs;
    }

    public void update_accounts(int num_accounts) {
        this.num_accounts = num_accounts;
    }

    public void update_newaccounts(int new_accounts) {
        this.new_accounts = new_accounts;
    }

    // updates all the info that happened on that day in the ATM.
    public void open_ATM() {
        // opens the ATM
        set_ATMstatus(true);
        System.out.println("The ATM starts it's services now.");
    }

    public void close_ATM() {
        // closes the ATM
        set_ATMstatus(false);
        System.out.println("The ATM is out of services now.");
    }
}
