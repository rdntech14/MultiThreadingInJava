
public class CreateMultipleThreads {

	public static void firstExample() {
		
		for(int i = 0 ; i<10; i++) {
			MultiThread m = new MultiThread();
			m.start();
		}
	}
	
	

}
