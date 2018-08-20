
public class CreateMultipleThreads {

	public static void createThread() {
		
		for(int i = 0 ; i<10; i++) {
			MultiThread m = new MultiThread();
			m.start();
		}
	}
	
	

}
