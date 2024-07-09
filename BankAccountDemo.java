package MultiThreading;

class BankAccount {
    private int balance = 100;

    public  void withdraw(int amount) {
    	
    	/*synchronized (this) {
    		if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + ". Remaining balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ". Insufficient balance.");
            }
		}*/
    	
    	if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw.");
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ". Insufficient balance.");
        }
        
    }

}

class WithdrawalThread extends Thread {
    private BankAccount account;
    private int amount;

    public WithdrawalThread(BankAccount account, int amount, String name) {
        super(name);
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
    		account.withdraw(amount);
        
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Create multiple threads trying to withdraw money from the same account
        WithdrawalThread t1 = new WithdrawalThread(account, 50, "Thread-1");
        WithdrawalThread t2 = new WithdrawalThread(account, 50, "Thread-2");
        WithdrawalThread t3 = new WithdrawalThread(account, 50, "Thread-3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
    }
}
