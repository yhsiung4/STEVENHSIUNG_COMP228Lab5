import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(100);

        int threadCount = 4;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for(int i=0; i<threadCount; i++) {
            if(i%2==0) {
                executorService.submit(new Producer(bankAccount));
            }
            else {
                executorService.submit(new Consumer(bankAccount));
            }
        }




        executorService.shutdown();

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                System.out.println("Closing balance $=" + bankAccount.getBalance())));
    }
}

class Producer implements Runnable {

    private BankAccount bankAccount;

    public Producer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            bankAccount.deposit(10);
        }
    }
}

class Consumer implements Runnable {

    private BankAccount bankAccount;

    public Consumer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            bankAccount.withdraw(10);
        }
    }
}