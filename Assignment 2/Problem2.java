// Producer–Consumer problem using synchronization and inter-thread communication 

// Problem2.java

// Shared Buffer Class
class Buffer {
    private int data;
    private boolean hasValue = false;

    // Produce method
    public synchronized void produce(int value) {
        try {
            while (hasValue) {
                wait(); // wait if buffer is full
            }

            data = value;
            System.out.println("Produced: " + data);
            hasValue = true;

            notify(); // notify consumer

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Consume method
    public synchronized void consume() {
        try {
            while (!hasValue) {
                wait(); // wait if buffer is empty
            }

            System.out.println("Consumed: " + data);
            hasValue = false;

            notify(); // notify producer

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Producer Class
class Producer extends Thread {
    private Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Consumer Class
class Consumer extends Thread {
    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main Class
public class Problem2 {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}