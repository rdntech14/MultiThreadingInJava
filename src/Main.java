import java.util.concurrent.BrokenBarrierException;

public class Main {

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		
		/* how to create multiple threads and run them sequence is not guarantee */
		 CreateMultipleThreads.firstExample();

		/* To start the threads at exactly the same time, you can use a CyclicBarrier, run 2 thread at the same time*/
//		CyclicBarrierDemo.startThreadsInParallel();
	}
	
}
