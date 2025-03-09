package projects;
import java.util.*;


public class BankingSystem {
    private String f_name;
    private String l_name;
    private int mob_no;
    private int pin;
    private int amount=0;
    static HashMap<Integer,BankingSystem> users=new HashMap<>();
    BankingSystem(String f_name,String l_name,int mob_no,int pin,int amount) {
        this.f_name=f_name;
        this.l_name=l_name;
        this.mob_no=mob_no;
        this.pin=pin;
        this.amount=amount;
    }
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }
    public void displayInfo(){
            System.out.println("\nAccount Holder: " + f_name + " " + l_name);
            System.out.println("Mobile Number: " + mob_no);
            System.out.println("Current Balance: ₹" + amount);
    }
    public void deposit(int num){
        this.amount+=num;
        System.out.println("Amount Successfully Added");
        System.out.println("Your current balance is " + this.amount);
    }
    public void withdraw(int num){
        this.amount-=num;
        System.out.println("Amount Successfully withdrawn");
        System.out.println("Your current balance is " + this.amount);
    }

    public static void main(String[] args){
        while(true){
        System.out.println("Welcome to my Bank");
        System.out.println("Choose the servise you want");
        System.out.println("1. Want to create Account");
        System.out.println("2. Already have an account");
        System.out.println("3. Exit");

        Scanner sc=new Scanner(System.in);
        System.out.print("enter your choise : ");
        int ans=sc.nextInt();
        if(ans==1){
            System.out.println("Enter Your First Name: ");
            sc.nextLine();

            String F_name=sc.nextLine();
            System.out.println("Enter Your Last Name: ");

            String L_name=sc.nextLine();
            System.out.println("Enter Your Mobile Number: ");

            int mob_no=sc.nextInt();
            System.out.println("please Choose 4 digit pin : ");

            int pin=sc.nextInt();
            System.out.println("Please Deposit your Initial amount of 500");

            int amount=sc.nextInt();

            BankingSystem user=new BankingSystem(F_name,L_name,mob_no,pin,amount);
            users.put(mob_no,user);
            System.out.print("User Added Successfully");

        }else if(ans==2){
                System.out.print("Enter your Mobile Number");

                int number=sc.nextInt();
                if (!users.containsKey(number)) {
                    System.out.println("User Not Found! Please Try Again.");
                    return; 
                }
                BankingSystem user = users.get(number);
                int cnt=3;
                while(cnt!=0){
                    System.out.print("Enter Your PIN: ");
                    int enteredPin = sc.nextInt();
                    if(user.verifyPin(enteredPin)){
                        System.out.println("Login Successful!");
                        System.out.println("what information do you want");
                        System.out.println("1. want to see account information");
                        System.out.println("2. Deposit balance");
                        System.out.println("3. WIthdraw balance");
                        ans=sc.nextInt();
                        if(ans==1){
                            user.displayInfo();
                        }else if(ans==2){
                            System.out.print("Enter the amount you wanted to deposit : ");
                            int amount=sc.nextInt();
                            user.deposit(amount);
                        }else if(ans==3){
                            System.out.print("Enter the amount you wanted to withdraw : ");
                            int amount=sc.nextInt();
                            user.withdraw(amount);
                        }
                        break;
                    }else{
                        System.out.print("please enter the correct pin");
                        System.out.print("Chances left : "+ cnt--);
                    }
                }
                }else if(ans==3){
                    System.out.print("Thankyou for Banking with us. Hope you will come back later. Goodbye!");
                    break;
                }else{
                    System.out.print("Invalid Choice, please try again");
                }
        }
    }
}
