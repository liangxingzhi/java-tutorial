package lxz.tutorial.https;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpClientUtil {
	public static void main(String[] args) {
		HttpClient httpclient = new HttpClient();
		GetMethod httpget = new GetMethod("https://cheatsheet.lxz.com/");
		try {
			httpclient.executeMethod(httpget);
			System.out.println(httpget.getStatusLine());
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpget.releaseConnection();
		}
	}
}
