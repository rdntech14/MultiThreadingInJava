import java.io.IOException;

public class MultiThread extends Thread {
	
	public void run() {

		System.out.println(Thread.currentThread().getName() + " STARTED");

		try {
			HttpRequestMethod.getRequestDemo(Thread.currentThread().getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + " ENDED");
	}
}
