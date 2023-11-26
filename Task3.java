import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    static Scanner sc = new Scanner(System.in);
    static List<Integer> accountNumber = new ArrayList<>();
    static List<String> passWord = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("************ ATM INTERFACE ************");

        while (true) {
            System.out.println("====================================");
            System.out.println("Insert number of your choice:\n1. Register  (new user) \n2. Login (Already a user) \n3. Exit");
            int in = sc.nextInt();
            if(in == 1){
                register();
            }
            else if(in == 2){
                login();
            }
            else if(in == 3){
                break;
            }
            else{
                System.out.println("invalid input");
            }
        }
    }

    public static void register(){
        System.out.println("====================================");
        System.out.println("Enter 6 Digit Account Number:");
        int ano = sc.nextInt();
        accountNumber.add(ano);
        System.out.println("Enter Password:");
        String pass = sc.next();
        sc.nextLine();
        while (true) {
            System.out.println("Confirm Password:");
            String confirm = sc.nextLine();
            if(pass.equals(confirm)){
                passWord.add(pass);
                break;
            }
            else{
                System.out.println("Enter correct password");
            } 
        }
    }

    public static void login(){
        System.out.println("====================================");
        List<String> Transaction = new ArrayList<>();
        int balance = 10000; // initially 10000

        System.out.println("Enter 6 Digit Account Number:");
        int ano = sc.nextInt();
        if(!(accountNumber.contains(ano))){
            System.out.println("User does not exist please register or enter valid account number.");
            return;
        }
        sc.nextLine();
        while (true) {
            System.out.println("Enter Password:");
            String pass = sc.nextLine();
            if (!(passWord.contains(pass))) {
                System.out.println("Wrong password.");
            }
            else{
                break;
            }
        }

        while (true) {
            System.out.println("====================================");
            System.out.println("Enter your choice number: \n1. Transaction history \n2. Withdraw \n3. Deposite \n4. Transfer amount to account \n5. Check balance \n6. logout");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("====================================");
                    if(Transaction.isEmpty()){
                        System.out.println("No transaction available.");
                    }
                    else{
                        for(String tran : Transaction){
                            System.out.println(tran);
                        }
                    }
                    break;
                
                case 2:
                    System.out.println("====================================");
                    System.out.println("Enter amount to withdraw:");
                    int amt = sc.nextInt();
                    if(balance-amt<0){
                        System.out.println("Insuficient balance");
                    }
                    else{
                        balance -= amt;
                        Transaction.add("Rs."+amt+" debited on "+LocalDate.now());
                    }
                    break;

                case 3:
                    System.out.println("====================================");
                    System.out.println("Enter amount to deposite:");
                    int deposite = sc.nextInt();
                    balance += deposite;
                    Transaction.add("Rs."+deposite+" credited on "+LocalDate.now());
                    break;

                case 4:
                    System.out.println("====================================");
                    System.out.println("Enter 6 digit account number:");
                    int tano = sc.nextInt();
                    System.out.println("Enter amount to transfer:");
                    int transferamt = sc.nextInt();
                    if(balance-transferamt<0){
                        System.out.println("Insuficient balance");
                    }
                    else{
                        balance -= transferamt ;
                        Transaction.add("Rs."+transferamt+" transfered from "+ano+" to "+tano+" on "+LocalDate.now());
                    }
                    break;
                
                case 5:
                    System.out.println("====================================");
                    System.out.println("current balance:"+balance);
                    break;
                
                case 6:
                    return;

                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }
}
