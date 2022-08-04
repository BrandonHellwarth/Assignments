public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber = "";
    private static int numberOfAccounts = 0;
    private static double totalBanked = 0;
//PRIVATE METHOD
private String createAccountNumber(){
        String number = "";
        for(int i=0;i<10;i++){
            number += (int)Math.floor((Math.random() * 9) + 1);
        }
        return number;
    }
//CONSTRUCTOR
    public BankAccount(double checking, double savings){
        this.checkingBalance = checking;
        this.savingsBalance = savings;
        this.accountNumber = createAccountNumber();
        System.out.println("Account Number: " + this.accountNumber);
        numberOfAccounts++;
        System.out.println("Number of accounts: " + numberOfAccounts);
    }
// METHODS
    public double deposit(String account, double amount){
        if(account == "checking"){
            this.checkingBalance += amount;
            totalBanked += amount;
            return checkingBalance;
        }
        else if(account == "savings"){
            this.savingsBalance += amount;
            totalBanked += amount;
            return savingsBalance;
        }
        else{
            System.out.println("Invalid account name, please enter checking or savings");
            return 0;
        }
    }
    public double withdraw(String account, double amount){
        if(account == "checking"){
            if(checkingBalance < amount){
                System.out.println("Insufficient Funds");
                return 0;
            }
            else{
                this.checkingBalance -= amount;
                totalBanked -= amount;
                return checkingBalance;
            }
        }
        else if(account == "savings"){
            if(savingsBalance < amount){
                System.out.println("Insufficient Funds");
                return 0;
            }
            else{
                this.savingsBalance -= amount;
                totalBanked -= amount;
                return savingsBalance;
            }
        }
        else{
            System.out.println("Invalid account name, please enter checking or savings");
            return 0;
        }
    }
//GETTERS and SETTERS
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }
    public double sumAccounts(){
        return checkingBalance + savingsBalance;
    }
}