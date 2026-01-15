// Bank Account Program using Dynamic Method Dispatch
class Account
{
    protected int accountNumber;
    protected String name;
    protected String accountType;
    protected double balance;
    protected int day, month, year;
    private static int accNoCounter = 1000;
    // Constructor
    Account(String name, String accountType, double balance, int day, int month, int year)
    {
        this.accountNumber = ++accNoCounter;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.day = day;
        this.month = month;
        this.year = year;
    }
    void checkBalance()
    {
        System.out.println("Current Balance: Rs " + balance);
    }
    void deposit(double amount, int d, int m, int y)
    {
        balance += amount;
        day = d;
        month = m;
        year = y;
        System.out.println("Rs " + amount + " deposited successfully.");
    }
    void withdraw(double amount)
    {
        System.out.println("Withdrawal method of Account class");
    }
}
// Standard Account
class StandardAccount extends Account
{
    StandardAccount(String name, double balance, int d, int m, int y)
    {
        super(name, "Standard", balance, d, m, y);
    }

    @Override
    void withdraw(double amount)
    {
        if (amount <= 100000)
        {
            balance -= amount;
            System.out.println("Rs " + amount + " withdrawn (Free).");
        }
        else if (amount <= 500000)
        {
            double penalty = amount * 0.0005;
            balance -= (amount + penalty);
            System.out.println("Rs " + amount + " withdrawn with penalty Rs " + penalty);
        }
        else
        {
            System.out.println("Withdrawal limit exceeded for Standard Account.");
        }
    }
}
// Premium Account
class PremiumAccount extends Account
{
    PremiumAccount(String name, double balance, int d, int m, int y)
    {
        super(name, "Premium", balance, d, m, y);
    }
    @Override
    void withdraw(double amount)
    {
        if (amount <= 1000000)
        {
            balance -= amount;
            System.out.println("Rs " + amount + " withdrawn successfully.");
        }
        else
        {
            System.out.println("Daily withdrawal limit exceeded.");
        }
    }
}
// Main Class
public class BankAccountDemo
{
    public static void main(String[] args)
    {
        Account a1 = new StandardAccount("Amit", 800000, 10, 1, 2025);
        Account a2 = new PremiumAccount("Rohit", 2000000, 12, 1, 2025);

        System.out.println("\n--- Standard Account ---");
        a1.checkBalance();
        a1.withdraw(200000);
        a1.checkBalance();

        System.out.println("\n--- Premium Account ---");
        a2.checkBalance();
        a2.withdraw(900000);
        a2.checkBalance();
    }
}
