import java.util.*;
import java.text.*;

public class account_holder {
    Scanner scan = new Scanner(System.in);
    public String name, phone_num;
    private String username, Acc_no, Acc_type;
    private String PIN;
    String recovery_question, ans_toreq;
    int balance = 0, age;

    account_holder(String name, String username, String Acc_no,
            String Acc_type, String PIN, String phone_num, int age) {
        this.name = name;
        this.username = username;
        this.Acc_no = Acc_no;
        this.Acc_type = Acc_type;
        this.PIN = PIN;
        this.phone_num = phone_num;
        this.age = age;
    }

    public void setquestion(String recovery_question, String ans_toreq) {
        this.recovery_question = recovery_question;
        this.ans_toreq = ans_toreq;
    }

    public String get_username() {
        return username;
    }

    public String getAcc_no() {
        return Acc_no;
    }

    public String printAcc_no() {
        return "****" + Acc_no.charAt(4) + Acc_no.charAt(5);
    }

    public String printPIN() {
        String res = "";
        for (int i = 0; i < PIN.length(); i++) {
            res = res + "*";
        }
        return res;
    }

    public String getPIN() {
        return PIN;
    }

    public String getAcc_type() {
        return Acc_type;
    }

    public void Setaadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public void set_PIN(String PIN) {
        this.PIN = PIN;
    }

    public void update_balance(int balance) {
        this.balance = balance;
    }

    public int get_balance() {
        return balance;
    }

    public void withdraw(int withdrawal_amount) {
        System.out.println("Your withdrawal is being processed....");
        System.out.println("Your withdrawal is completed!");
        update_balance(get_balance() - withdrawal_amount);
    }

    public void deposit(int dep_money) {
        update_balance(balance + dep_money);
        System.out.println("Your transaction is successful...");
        System.out.println("You have deposited Rs." + dep_money + " into your " + getAcc_type());
    }

    public void check_balance() {
        System.out.println("Name             : " + name);
        System.out.println("username         : " + get_username());
        System.out.println("Account number   : " + printAcc_no());
        System.out.println("Account type     : " + getAcc_type());
        System.out.println("PIN              : " + printPIN());
        System.out.println("Phone number     : " + phone_num);
        System.out.println("________________________________________________");
        System.out.println("Your account balance is :" + balance);
    }

    public void moneytransfer(account_holder X, int transfer) {
        // transfer of money from current accountholder to accountholder X
        X.update_balance(X.get_balance() + transfer);
        update_balance(get_balance() - transfer);
    }

    public void change_PIN() {
        changepin: while (true) {
            System.out.println("\n(1)USE EXISTING PIN   (2)TRY ANOTHER WAY");
            // two ways to change pin (using current pin / using a user self-defined
            // question)
            int choice_changepin = scan.nextInt();
            scan.nextLine();
            if (choice_changepin == 1) {
                System.out.println("Please enter your existing PIN.");
                String PIN_check = scan.nextLine();
                if (PIN_check.equals(PIN)) {
                    upd_pass: while (true) {
                        System.out.println("Please enter your new pin");
                        System.out.println(
                                "PIN MUST HAVE LENGTH OVER 5 CHARACTERS,COMPRISES OF ONLY DIGITS( E.G: 342316 )");
                        String newpin = scan.nextLine();
                        boolean status = true;
                        for (int i = 0; i < newpin.length(); i++) {
                            if (newpin.charAt(i) > '9'
                                    || newpin.charAt(i) < '0'
                                    || newpin.length() < 5) {
                                status = false;
                                break;
                            }
                        }
                        if (status == true) {
                            set_PIN(newpin);
                            System.out.println("YOUR PIN HAS BEEN SUCCESSFULLY UPDATED...");
                            break upd_pass;
                        } else {
                            System.out.println("The PIN is invalid, please enter again.");
                        }
                    }
                }
            } else if (choice_changepin == 2) {
                waytwo: while (true) {
                    System.out.println("Please answer the following question to proceed further.");
                    System.out.println(recovery_question);
                    System.out.print("ANS : ");
                    String ans = scan.nextLine();
                    if (ans.equals(ans_toreq)) {
                        upd_pass1: while (true) {
                            System.out.println("Please enter your new pin");
                            System.out.println(
                                    "PIN MUST HAVE LENGTH OVER 5 CHARACTERS,COMPRISES OF ONLY DIGITS( E.G: 342316 )");
                            String newpin = scan.nextLine();
                            boolean status = true;
                            for (int i = 0; i < newpin.length(); i++) {
                                if (newpin.charAt(i) > '9'
                                        || newpin.charAt(i) < '0'
                                        || newpin.length() < 5) {
                                    status = false;
                                    break;
                                }
                            }
                            if (status == true) {
                                set_PIN(newpin);
                                System.out.println("YOUR PIN HAS BEEN SUCCESSFULLY UPDATED...");
                                break upd_pass1;
                            } else {
                                System.out.println("The password is invalid, please enter again.");
                                continue;
                            }
                        }
                        // password gets updated only if the new password consists of only digits and is
                        // over length 5.
                    } else {
                        System.out.println("INVALID CREDENTIALS....");
                        continue;
                    }
                    break waytwo;
                }
            } else {
                System.out.println("Please make a valid choice!");
                continue;
            }
            break changepin;
        }
    }
}
