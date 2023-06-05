import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private long accountNumber;
    private String name;
    private double balance;
    private final double RATE = 0.035;

    public Account() {
        this.accountNumber = 999999;
        this.name = "chưa xác định";
        this.balance = 50000;
    }

    public Account(long accountNumber, String name, double balance) {
        if (accountNumber > 0)
            this.accountNumber = accountNumber;
        else
            this.accountNumber = 999999;

        if (name.isEmpty())
            this.name = "chưa xác định";
        else
            this.name = name;

        if (balance < 50000)
            this.balance = 50000;
        else
            this.balance = balance;
    }

    public Account(long accountNumber, String name) {
        if (accountNumber > 0)
            this.accountNumber = accountNumber;
        else
            this.accountNumber = 999999;

        if (name.isEmpty())
            this.name = "chưa xác định";
        else
            this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount < 0)
            return false;

        this.balance = this.balance + amount;
        return true;
    }

    public boolean withdraw(double amount, double fee) {
        if (amount < 0 && amount+fee > this.balance)
            return false;

        this.balance -= (amount + fee);
        return true;
    }

    public void addInterest() {
        Locale locale = new Locale("vi","vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String interestFormated = numberFormat.format(this.balance + this.balance * this.RATE);

        System.out.println(interestFormated);
    }

    public void transfer(Account acc2, double amount) {
        this.balance -= amount;
        acc2.deposit(amount);
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi","vn");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String balanceFormated = numberFormat.format(balance);

        return "Account{" +
                "accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", balance=" + balanceFormated +
                '}';
    }
}
