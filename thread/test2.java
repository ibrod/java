import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test2 {
    public static void main(String[] args) {
        Account a = new Account();
        a.setBalance(100);
        Bank bank1 = new Bank(a);
        Bank bank2 = new Bank(a);
        Bank bank3 = new Bank(a);
        Bank bank4 = new Bank(a);
        Bank bank5 = new Bank(a);
        new Thread(bank1, "bank1").start();
        new Thread(bank2, "bank2").start();
        new Thread(bank3, "bank3").start();
        new Thread(bank4, "bank4").start();
        new Thread(bank5, "bank5").start();
    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (account) {
                if (account.getBalance() > 0) {
                    try {
                        Thread.sleep(107);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "取钱成功，余额为：" + account.getBalance());
                    account.setBalance(account.getBalance() - 13);
                } else {
                    System.out.println("余额不足");
                    break;
                }
            }
        }
    }
}

class Bank2 implements Runnable {
    private Account account;

    public Bank2(Account account) {

        this.account = account;
    }

    @Override
    public void run() {
        final ReentrantLock lock = new ReentrantLock();
        while (true) {

            lock.lock();
            if (account.getBalance() > 0) {
                try {
                    Thread.sleep(107);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "取钱成功，余额为：" + account.getBalance());
                account.setBalance(account.getBalance() - 13);
            } else {
                System.out.println("余额不足");
                break;
            }

        }
        lock.unlock();
    }
}