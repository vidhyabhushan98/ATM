import java.util.*;
import java.text.*;
import account_holder;
import admin;
import deposit_slot;
import dispenser;

public class CS21B030ATM {
    public static void main(String[] args) {

        SimpleDateFormat sd = new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss z");
        Date date = new Date();
        // gets the date and time at each instance.......
        sd.setTimeZone(TimeZone.getTimeZone("IST"));
        System.out.println("\nThe ATM has been opened on " + sd.format(date));
        Random random = new Random();// random account number generator for new user.....
        ArrayList<String> today = new ArrayList<String>();// keeps a list of transactions that happened in the ATM....
        ArrayList<String> acc_nolist = new ArrayList<String>();// keeps a list of account numbers that are available for
                                                               // new users....
        for (int i = 100000; i < 999999; i++) {
            acc_nolist.add(String.valueOf(i));
        }
        admin namaste = new admin();
        dispenser Dispenser = new dispenser();
        deposit_slot Deposit = new deposit_slot();
        namaste.open_ATM();
        // creating admin and opening the ATM as well...
        today.add("The ATM is opened on " + sd.format(date));
        int witdrws = 0;// money transactions through withdrawals
        int deps = 0;// money transactions through deposits
        int num_accounts = 3;// total number of acciunts existing
        int new_accounts = 0;// new accounts created today
        int trs = 0;// money transactions through account transfer
        // keeping record of all transactions that happen throughout the day
        namaste.update_accounts(num_accounts);
        boolean status = namaste.getATM_status();
        Scanner scan = new Scanner(System.in);
        account_holder accountholders[] = new account_holder[900000];
        // creating some accounts
        ArrayList<ArrayList<String>> transactions = new ArrayList<ArrayList<String>>();// a list to store the
                                                                                       // transactions by users
        accountholders[0] = new account_holder("kyle james", "james123", "123456", "savings", "123456",
                "87456", 22);
        transactions.add(new ArrayList<String>());
        accountholders[0].setquestion("which flies in sky?", "bird");
        accountholders[1] = new account_holder("jack package", "pack12345", "129453", "savings", "098765",
                "12744", 19);
        accountholders[1].setquestion("At what age did jack graduate?", "notyet");
        transactions.add(new ArrayList<String>());
        accountholders[2] = new account_holder("chris malcolm", "chris45", "129451", "savings",
                "0987651", "91271", 29);
        transactions.add(new ArrayList<String>());
        accountholders[2].setquestion("How many cars does chris have?", "9");
        int usercount = 3;
        acc_nolist.remove("123456");
        acc_nolist.remove("129453");
        acc_nolist.remove("129451");
        while (true) {
            // the atm interface
            System.out.println("\n--------Welcome to ATM--------");
            System.out.println("(1)Registration  (2)Existing user  (3)ADMIN ");
            // The registration and existing user only open and operate whenever the ATM is
            // in open and admin can alter this.
            System.out.println("Enter your choice : ");
            int choice_ATM = scan.nextInt();
            scan.nextLine();
            if (choice_ATM == 1) {
                if (status == false) {
                    System.out.println(
                            "\nThe ATM is under maintainence or out of service. for further details contact ADMIN..");
                } else {
                    System.out.println("Welcome New User.");
                    System.out.print("Please enter your name :  ");
                    String name = scan.nextLine();
                    System.out.print("Enter your age : ");
                    int age = scan.nextInt();
                    scan.nextLine();
                    String username = "";
                    user_name: while (true) {
                        System.out.print("Enter your username : ");
                        String uname = scan.nextLine();
                        int flag = 0;
                        for (int i = 0; i < usercount; i++) {
                            if (uname.equals(accountholders[i].get_username())) {
                                flag = 1;
                                break;
                            }
                        }
                        if (flag == 1) {
                            System.out.println("The username is already taken please enter again.");
                        } else {
                            username = username + uname;
                            break user_name;
                        }
                    }

                    String Acc_type = "";
                    acctype: while (true) {
                        System.out.println("Enter your account type : ");
                        System.out.println("(1)Savings  (2)current ");
                        int choice_acc = scan.nextInt();
                        if (choice_acc == 1) {
                            Acc_type += "Savings";
                        } else if (choice_acc == 2) {
                            Acc_type += "Current";
                        } else {
                            System.out.println("Please make a valid choice.");
                            continue;
                        }
                        break acctype;
                    }
                    scan.nextLine();
                    int index = random.nextInt(acc_nolist.size());
                    String Acc_no = acc_nolist.get(index);
                    acc_nolist.remove(acc_nolist.get(index));
                    String PIN = "";
                    pinentry: while (true) {
                        System.out.print("Enter your PIN : ");
                        String upin = scan.nextLine();
                        boolean stat = true;
                        for (int i = 0; i < upin.length(); i++) {
                            if (upin.charAt(i) > '9'
                                    || upin.charAt(i) < '0' || upin.length() < 5) {
                                stat = false;
                                break;
                            }
                        }
                        if (stat == true) {
                            PIN += upin;
                            break pinentry;
                        } else {
                            System.out.println("The PIN is invalid, please enter again.");
                            continue;
                        }
                    }
                    System.out.print("Enter your Phone number : ");
                    String phone_num = scan.nextLine();
                    System.out.println(
                            "We are almost close to complete the creation of your account... Just a few steps away...");
                    System.out.println(
                            "In order to recover account when you might have forgot the password, this step is necessary");
                    System.out.println(
                            "Please enter a question to recognise if it's you in the future for PIN recovery purpose.");
                    String question = scan.nextLine();
                    System.out.println("Now, enter the answer for that question.");
                    String ans_toreq = scan.nextLine();
                    accountholders[usercount] = new account_holder(name, username, Acc_no, Acc_type, PIN,
                            phone_num, age);
                    accountholders[usercount].setquestion(question, ans_toreq);
                    System.out.println("\nYou have successfully registered for services in our ATM.");
                    System.out.println("____________________________________________________________");
                    System.out.println("YOUR ACCOUNT DETAILS ARE DISPLAYED HERE.........");
                    System.out.println("Name             : " + accountholders[usercount].name);
                    System.out.println("username         : " + accountholders[usercount].get_username());
                    System.out.println("Account number   : " + accountholders[usercount].getAcc_no());
                    System.out.println("Account type     : " + accountholders[usercount].getAcc_type());
                    System.out.println("PIN              : " + accountholders[usercount].printPIN());
                    System.out.println("Phone number     : " + accountholders[usercount].phone_num);
                    System.out.println("____________________________________________________________");
                    transactions.add(new ArrayList<String>());
                    today.add("A new user with account number" + accountholders[usercount].getAcc_no()
                            + "is created on " + sd.format(date));
                    transactions.get(usercount).add("The account has been created on " + sd.format(date));
                    transactions.get(usercount).add("\n");
                    usercount++;
                    new_accounts++;
                    num_accounts++;
                    namaste.update_accounts(num_accounts);
                    namaste.update_newaccounts(new_accounts);

                    // the account will be registered only if the username doesn't match and certain
                    // criteria for the password are met.
                }

            } else if (choice_ATM == 2) {
                if (status == false) {
                    System.out.println(
                            "\nThe ATM is under maintainence or out of service. for further details contact ADMIN..");
                } else {
                    System.out.print("\nEnter your username:");
                    String uname = scan.nextLine();
                    int id = 0, flag = 0;
                    for (int i = 0; i < usercount; i++) {
                        if (uname.equals(accountholders[i].get_username())) {
                            id = i;
                            flag = 1;
                            break;
                        }
                    }
                    if (flag == 1) {
                        int tries = 0;
                        user_login: while (true) {
                            System.out.print("Enter your PIN: ");
                            String upin = scan.nextLine();
                            if (upin.equals(accountholders[id].getPIN())) {
                                System.out.println("Enter your choice.");
                                while (true) {
                                    // takes only valid input from the user
                                    System.out.println(
                                            "(1)Withdraw cash  (2)deposit money  (3)money transfer  (4)check balance  (5)change PIN  (6)view transaction history  (7)exit user");
                                    int choice_user = scan.nextInt();
                                    if (choice_user == 1) {
                                        withdrw: while (true) {
                                            System.out.println("All withdrawal transactions are limited to Rs.50000/-");
                                            System.out.print("Enter the amount of money you want to withdraw: ");
                                            int withdrawal_amount = scan.nextInt();
                                            if (withdrawal_amount <= 50000) {
                                                scan.nextLine();
                                                System.out.println();
                                                if (namaste.get_balance() > withdrawal_amount) {
                                                    // withdraws money if the ATM has enough money
                                                    if (accountholders[id].get_balance() > withdrawal_amount) {
                                                        // withdraws money only if the account has enough balance
                                                        accountholders[id].withdraw(withdrawal_amount);
                                                        namaste.set_ATMbalance(
                                                                namaste.get_balance() - withdrawal_amount);
                                                        witdrws = witdrws + withdrawal_amount;
                                                        namaste.update_withdrawals(witdrws);
                                                        transactions.get(id)
                                                                .add("The amount of Rs." + withdrawal_amount
                                                                        + "/- is withdrawn from your "
                                                                        + accountholders[id].getAcc_type()
                                                                        + " account on "
                                                                        + sd.format(date) + ".-----");
                                                        today.add(
                                                                "Accountholder with account number xxxxxx has withdrawn Rs."
                                                                        + withdrawal_amount + " on " + sd.format(date));
                                                        Dispenser.dispense_cash(withdrawal_amount);
                                                        System.out
                                                                .println("You have withdrawn the cash of Rs."
                                                                        + withdrawal_amount + " on " + sd.format(date));

                                                    } else {
                                                        System.out.println(
                                                                "Your acount doesn't have enough money for the transaction.");
                                                    }
                                                } else {
                                                    System.out.println(
                                                            "The current amount in ATM is not enough for the transaction. please consider withdrawing money under Rs."
                                                                    + namaste.get_balance() + "/-");
                                                    continue;
                                                }
                                                break withdrw;
                                            } else {
                                                System.out.println(
                                                        "Withdrwal has beeen failed, withdrawal limit is Rs.50000");
                                                System.out.println("Try once again!!");
                                            }
                                        }
                                    } else if (choice_user == 2) {
                                        System.out.print("Enter the amount of money you want to deposit: ");
                                        int dep_money = scan.nextInt();
                                        System.out.println();
                                        Deposit.deposit_denominations(dep_money);
                                        accountholders[id].deposit(dep_money);
                                        namaste.set_ATMbalance(namaste.get_balance() + dep_money);
                                        scan.nextLine();
                                        deps = deps + dep_money;
                                        namaste.update_deposits(deps);
                                        transactions.get(id)
                                                .add("The amount of Rs." + dep_money + "/- is deposited into your "
                                                        + accountholders[id].getAcc_type() + " account on "
                                                        + sd.format(date) + ".-----");
                                        today.add(
                                                "Accountholder with account number xxxxxx has deposited Rs." + dep_money
                                                        + "on " + sd.format(date));
                                    } else if (choice_user == 3) {
                                        scan.nextLine();
                                        System.out.print(
                                                "Enter the username of account you want to transfer money into:");
                                        String acc = scan.nextLine();
                                        int flag1 = 0;
                                        int idx = 0;
                                        // checks if the username entered by the accountholder exists or not
                                        for (int i = 0; i < usercount; i++) {
                                            if (acc.equals(accountholders[i].get_username())) {
                                                idx = i;
                                                flag1 = 1;
                                                break;
                                            }
                                        }
                                        if (flag1 == 1) {
                                            trnsmny: while (true) {
                                                System.out.print("Enter your amount of money you want to transfer: ");
                                                int transfer = scan.nextInt();
                                                scan.nextLine();
                                                if (transfer > accountholders[id].get_balance()) {
                                                    // checks if the account has enough balance
                                                    System.out.println(
                                                            "Your account doesn't have the enough balance to proceed the transaction.");
                                                    System.out.println("Please enter the money again.");
                                                    continue;
                                                } else {
                                                    System.out.println("The money transfer has been succesful.");
                                                    accountholders[id].moneytransfer(accountholders[idx], transfer);
                                                    transactions.get(id)
                                                            .add("The amount of Rs." + transfer
                                                                    + "/- is transferred from your "
                                                                    + accountholders[id].getAcc_type()
                                                                    + " account into account of "
                                                                    + accountholders[idx].name + " on "
                                                                    + sd.format(date)
                                                                    + ".-----");
                                                    transactions.get(idx)
                                                            .add("The amount of Rs." + transfer
                                                                    + "/- is transferred from account of "
                                                                    + accountholders[id].name + " into your "
                                                                    + accountholders[idx].getAcc_type() + " account on "
                                                                    + sd.format(date) + ".-----");
                                                    today.add(
                                                            "Accountholder with account number xxxxxx has transferred Rs."
                                                                    + transfer + " on " + sd.format(date));
                                                    trs = transfer + trs;
                                                    namaste.update_transfers(trs);
                                                    break trnsmny;
                                                }
                                            }

                                        } else {
                                            System.out.println("The account doesn't exist .....");
                                            System.out.println("The transaction has been terminated.....");
                                        }

                                    }

                                    else if (choice_user == 4) {
                                        System.out.println("\nYour account details as of " + sd.format(date)
                                                + " are displayed here .........");
                                        accountholders[id].check_balance();
                                        // prints balance in the account
                                    } else if (choice_user == 5) {
                                        accountholders[id].change_PIN();
                                        // change the pin
                                    } else if (choice_user == 6) {
                                        System.out.println("\nYour account details as of " + sd.format(date)
                                                + " are displayed here.........");
                                        accountholders[id].check_balance();
                                        System.out.println("_______________________________________________________");
                                        System.out.println();
                                        System.out.println("Transactions as of " + sd.format(date) + ".-----");
                                        for (int i = 0; i < transactions.get(id).size(); i++) {
                                            System.out.println(transactions.get(id).get(i));
                                        }
                                        // displays transactions that happpened through the account since it's opening
                                    } else if (choice_user == 7) {
                                        break user_login;
                                    } else {
                                        System.out.println("please make a valid choice!");
                                        continue;
                                    }
                                    break user_login;
                                }
                            }

                            else if (tries < 2) {
                                System.out.println("The PIN you entered is wrong...");
                                System.out.println("please try entering the correct PIN once again");
                                tries++;
                            } else if (tries == 2) {
                                System.out.println(
                                        "You have reached the maximum number of attempts, this is your final chance \n You will be asked the question when your account has been created ");
                                System.out.println("If you answer it correctly you will be allowed further");
                                System.out.println("Please answer the following question to proceed further.");
                                System.out.println(accountholders[id].recovery_question);
                                System.out.print("ANS : ");
                                String ans = scan.nextLine();
                                if (ans.equals(accountholders[id].ans_toreq)) {
                                    upd_pass1: while (true) {
                                        System.out.println("Please enter your new pin");
                                        System.out.println(
                                                "PIN MUST HAVE LENGTH OVER 5 CHARACTERS,COMPRISES OF ONLY DIGITS( E.G: 342316 )");
                                        String newpin = scan.nextLine();
                                        boolean status1 = true;
                                        for (int i = 0; i < newpin.length(); i++) {
                                            if (newpin.charAt(i) > '9'
                                                    || newpin.charAt(i) < '0'
                                                    || newpin.length() < 5) {
                                                status = false;
                                                break;
                                            }
                                        }
                                        if (status1 == true) {
                                            accountholders[id].set_PIN(newpin);
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
                                    tries++;
                                }
                            } else {
                                System.out.println(
                                        "You have PIN incorrect maximum number of times , now you'll be restricted from accessing the account");
                                break user_login;
                            }
                        }
                    } else {
                        System.out.println("The username doesn't exist.");
                    }

                }
            } else if (choice_ATM == 3) {
                System.out.println("\nPlease enter the admin password :");
                int tries = 0;
                admin: while (true) {
                    String pass = scan.nextLine();
                    if (tries >= 2) {
                        // access to admin has only three wrong tries, if used all of them incorrectly
                        // the ATM will be shutdown...
                        System.out.println("You don't seem to be the admin.");
                        System.out.println("You are restricted to proceed from here.");
                        System.out.println("404 ERROR......");
                        System.out.println(
                                "SYSTEM HAS BEEN BLOCKED >>>> SECURITY IS BREACHED >>>> POLICE ARE ON THE WAY.");
                        break;
                    } else if (pass.equals(namaste.getpassword())) {
                        while (true) {
                            System.out.println("\nYou are welcome Mr.admin");

                            while (true) {
                                System.out.println("\nSelect what you want to do Mr.Admin");
                                System.out.println(
                                        "(1)See ATM balance  (2)replenish the money  (3)today's history  (4)Open the ATM  (5)close the ATM  (6)EXIT Admin");
                                // Admin can check the ATM balance, close or open ATM, can check the
                                // transactions happened throughout that day,replenish the money in the ATM.
                                int choice_admin = scan.nextInt();
                                if (choice_admin == 1) {
                                    System.out.println("The ATM balance as of now is " + namaste.get_balance());
                                } else if (choice_admin == 2) {
                                    namaste.replenish_ATMbalance();
                                    System.out.println("The ATM's balance has been replenished.");
                                    today.add("The ATM's balance has been replenished on " + sd.format(date));

                                } else if (choice_admin == 3) {
                                    System.out.println("\nThe report of ATM for today is here.");
                                    for (int i = 0; i < today.size(); i++) {
                                        System.out.println(today.get(i));
                                    }
                                    System.out.println();
                                    namaste.get_todaysreport();
                                } else if (choice_admin == 4) {
                                    if (namaste.getATM_status() == false) {
                                        namaste.open_ATM();
                                        today.add("The ATM has been opened on " + sd.format(date));
                                    } else {
                                        System.out.println("The ATM is already functioning...");
                                    }
                                    status = namaste.getATM_status();
                                } else if (choice_admin == 5) {
                                    if (namaste.getATM_status() == true) {
                                        namaste.close_ATM();
                                        today.add("The ATM has been closed on " + sd.format(date));

                                    } else {
                                        System.out.println("The ATM is already closed...");
                                    }
                                    status = namaste.getATM_status();
                                } else if (choice_admin == 6) {
                                    break admin;
                                } else {
                                    System.out.println("Please make a valid choice.");
                                    continue;
                                }
                            }
                        }
                    } else {
                        System.out.println("Please enter the admin password correctly!...");
                        tries++;
                        continue;
                    }
                }
            } else {
                System.out.println("Please make a valid choice!!")
            }

        }
    }
}
