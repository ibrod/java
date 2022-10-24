public class test3 {
    public static void main(String[] args) {
        Account a = new Account();
        a.setBalance(100);
        Bank2 bank1 = new Bank2(a);
        Bank2 bank2 = new Bank2(a);
        Bank2 bank3 = new Bank2(a);
        Bank2 bank4 = new Bank2(a);
        Bank2 bank5 = new Bank2(a);
        new Thread(bank1, "bank1").start();
        new Thread(bank2, "bank2").start();
        new Thread(bank3, "bank3").start();
        new Thread(bank4, "bank4").start();
        new Thread(bank5, "bank5").start();
    }
}
