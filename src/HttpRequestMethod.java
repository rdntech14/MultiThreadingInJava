import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpRequestMethod {

	public static void getRequestDemo(String threadName) throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:8080/CreateRESTFulService/rest/employee/list/1002");

		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// set Request Method
		con.setRequestMethod("GET");

		// Set connection parameters
		con.setRequestProperty("Authorization", "Bearer tokenvalue");
		con.setRequestProperty("Accept", "application/json");

		if (con.getResponseCode() != 200) {
			System.out.println("connection failed with error code : " + con.getResponseCode());
			throw new RuntimeException();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		StringBuilder sb = new StringBuilder();
		String s;
		while ((s = br.readLine()) != null) {
			sb.append(s);
		}

		br.close();

		// output
		System.out.println("Result from thread : " + threadName + sb);

	}
}
