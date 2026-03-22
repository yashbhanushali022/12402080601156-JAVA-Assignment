// Find prime numbers using multithreading (Thread, Runnable, Executor Framework)

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Utility class to check prime
class PrimeUtil {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

// 1. Using Thread class
class PrimeThread extends Thread {
    int start, end;

    PrimeThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("\nUsing Thread class:");
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

// 2. Using Runnable interface
class PrimeRunnable implements Runnable {
    int start, end;

    PrimeRunnable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("\nUsing Runnable interface:");
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

// 3. Using Executor Framework
class PrimeTask implements Runnable {
    int start, end;

    PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("\nUsing Executor Framework:");
        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class Problem1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter start number: ");
        int start = sc.nextInt();

        System.out.print("Enter end number: ");
        int end = sc.nextInt();

        // 1. Thread class
        PrimeThread t1 = new PrimeThread(start, end);
        t1.start();

        try {
            t1.join(); // wait for completion
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2. Runnable interface
        Thread t2 = new Thread(new PrimeRunnable(start, end));
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. Executor Framework
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(new PrimeTask(start, end));
        executor.shutdown();

        sc.close();
    }
}
