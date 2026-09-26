package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    // Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    Double[] transactions = new Double[1000];
    int transactionIndex = 0;
    public BankAccount(String name, int startingBalance){

        this.name = name;
        this.currentBalance = startingBalance;

    }

    public void deposit(double amount){
        if(amount<0){
            System.out.println("Error in deposit: amount must be positive");
            return;
        }

        this.currentBalance += amount;
        this.transactions[transactionIndex++] = amount;
        System.out.println(this.name + " deposited " + amount + "; The new balance is: " + this.currentBalance);
    }

    public void withdraw(double amount){
        if(amount>this.currentBalance){
            System.out.println("Error in deposit: amount must be positive");
            return;
        }
        this.currentBalance -= amount;
        this.transactions[transactionIndex++] = -amount;
        System.out.println(this.name + " withdrew " + amount + "; The new balance is: " + this.currentBalance);
    }

    public void displayTransactions(){
        System.out.print("Transactions: ");
        for(int i=0;i<transactions.length && transactions[i]!=null ;i++)
            System.out.print((transactions[i] >= 0 ? "+" : "") + transactions[i] + " ");
        System.out.println();

    }

    public void displayBalance(){
        System.out.println("Balance: " + this.currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
