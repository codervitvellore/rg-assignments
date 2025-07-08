public class Main {

    public static void main(String[] args) {

        BankAccount acct = new BankAccount("Alice", 1_000);

        acct.deposit(250);           // balance → 1 250
        acct.withdraw(300);          // balance →   950

        System.out.println("Owner   : " + acct.getOwner());
        System.out.println("Balance : " + acct.getBalance());
    }
}
