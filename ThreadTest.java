package MultiThreading;
class ThreadDemo extends Thread{
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
public class ThreadTest {

	public static void main(String[] args) {
		Thread t1=new ThreadDemo();
		Thread t2=new ThreadDemo();
		t1.start();
		t2.start();

	}

}
