package MultiThreading;

class DaemonThreadDemo extends Thread {
    public DaemonThreadDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        
            System.out.println(getName() + " is running.");
            if(!Thread.currentThread().isDaemon()) {
            	try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    System.out.println(getName() + " was interrupted.");
                }
            }
            
       
    }

    public static void main(String[] args) {
        DaemonThreadDemo daemonThread = new DaemonThreadDemo("Daemon-Thread");
        DaemonThreadDemo userThread = new DaemonThreadDemo("User-Thread");

        // Set the first thread as a daemon thread
        daemonThread.setDaemon(true);

        // Start both threads
        daemonThread.start();
        userThread.start();

        
        if(daemonThread.isAlive()) {
        	System.out.println("Daemon thread is alive");
        }
        System.out.println("Main thread is finishing.");
    }
}

