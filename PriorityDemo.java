package MultiThreading;

class PriorityDemo extends Thread {
    public PriorityDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " with priority " + getPriority() + " is running");
        }
    }

    public static void main(String[] args) {
        // Create threads with different priorities
        PriorityDemo thread1 = new PriorityDemo("Thread-1");
        PriorityDemo thread2 = new PriorityDemo("Thread-2");
        PriorityDemo thread3 = new PriorityDemo("Thread-3");

        // Set thread priorities
        thread1.setPriority(Thread.MIN_PRIORITY); // Priority 1
        thread2.setPriority(Thread.NORM_PRIORITY); // Priority 5
        thread3.setPriority(Thread.MAX_PRIORITY); // Priority 10

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

