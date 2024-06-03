package ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGetClient2 {

	public static void main(String[] args) {

		String urlString = "https://jsonplaceholder.typicode.com/todos/5";

		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " + responseCode);

			BufferedReader brin = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String inputLine;
			StringBuffer responseBuffer = new StringBuffer();

			while ((inputLine = brin.readLine()) != null) {
				responseBuffer.append(inputLine);
			}

			brin.close();

			String[] strHtmls = responseBuffer.toString().split("\\s");
			System.out.println("index count : " + strHtmls.length);
			for (String word : strHtmls) {
				System.out.println(word);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
