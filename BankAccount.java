public class BankAccount {
    private int AccountNumber;
    private double Balance;
    private String AccountHolder;


    public BankAccount(int accountNumber, double balance, String accountHolder) {
        AccountNumber = accountNumber;
        Balance = balance;
        AccountHolder = accountHolder;
    }

    //Getters 
    public int getAccountNumber() {
        return AccountNumber;
    }

      public double getBalance(){
        return Balance;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    //Setters
    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }
    public void setBalance(double balance) {
        Balance = balance;
    }
    public void setAccountHolder(String accountHolder) {
        AccountHolder = accountHolder;
    }

    //Methods not synchronization
    public void deposit(double amount){
        Balance += amount;
    }

    public void withdraw(double amount){
        if (amount <= Balance) {
            Balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void transfer(BankAccount targetAccount, double amount){
        if (amount <= Balance) {
            this.withdraw(amount);
            targetAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds for transfer");
        }
    }

    //methods synchronization
    public synchronized void syncDeposit(double amount){
        Balance += amount;
    }

    public synchronized void syncWithdraw(double amount){
        if (amount <= Balance) {
            Balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public synchronized void syncTransfer(BankAccount targetAccount, double amount){
        if (amount <= Balance) {
            this.syncWithdraw(amount);
            targetAccount.syncDeposit(amount);
        } else {
            System.out.println("Insufficient funds for transfer");
        }
    }

        public synchronized double getBalanceSync(){
        return Balance;
    }




}
