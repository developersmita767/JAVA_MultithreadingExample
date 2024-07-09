package MultiThreading;


class RunnableDemo implements Runnable{

	@Override
	public void run() {
		System.out.println("Entering"+Thread.currentThread().getName());
		for(int i=0;i<5;i++) {
			System.out.println(i +" by "+Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Existing"+Thread.currentThread().getName());
	}
	
}
public class RunnableThreadTest {

	public static void main(String[] args) {
		RunnableDemo r1=new RunnableDemo();
		Thread t1=new Thread(r1);
		
		RunnableDemo r2=new RunnableDemo();
		Thread t2=new Thread(r2);
		
		t1.start();
		t2.start();
		
		System.out.println("Exiting "+Thread.currentThread().getName());

	}

}
