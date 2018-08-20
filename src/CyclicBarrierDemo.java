import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	public static void startThreadsInParallel() throws InterruptedException, BrokenBarrierException {
		final CyclicBarrier gate = new CyclicBarrier(3);

		Thread t1 = new Thread() {
			public void run() {

				try {
					//do some task
					//generate 100 numbers
					for (int i = 0; i < 100; i++) {
						System.out.println(Thread.currentThread().getName() + " : " + i);
						
					}
					
					// cyclic barrier value was 3
					// decrement the cyclic barrier counter by 1
					gate.await();
					// after decrement cyclic barrier counter value will be 2
					// wait to become cyclic barrier value zero and that will become once all parties reduces counter by 1
					//once value is 0, start task
					HttpRequestMethod.getRequestDemo(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (ProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				// cyclic barrier value was 2
				// decrement the cyclic barrier counter by 1
				try {
					
					//do some task
					//generate 100 numbers
					for (int i = 10000; i < 10100; i++) {
						System.out.println(Thread.currentThread().getName() + " : " + i);
						
					}
					// cyclic barrier value was 3
					// decrement the cyclic barrier counter by 1
					gate.await();
					// after decrement cyclic barrier counter value will be 1
					// wait to become cyclic barrier value zero and that will become once all parties reduces counter by 1
					//once value is 0, start task
					HttpRequestMethod.getRequestDemo(Thread.currentThread().getName());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (ProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();
		
		// cyclic barrier value was 1
		// decrement the cyclic barrier counter by 1
		// this counter is for main thread
		gate.await();
		// after decrement cyclic barrier counter value will be 0, once it become zero, 
		// it will execute all the pending halt threads
		System.out.println("all threads started");
	}

}
