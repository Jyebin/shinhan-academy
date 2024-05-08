package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.json.JSONArray;
//import org.json.JSONObject;

public class NaverAPI {
	public String getBookList(String searchWord) {
		String clientId = "cQgsadLX1Trus8W0uCdn"; // 애플리케이션 클라이언트 아이디
		String clientSecret = "PlBZ8d8QTF"; // 애플리케이션 클라이언트 시크릿

		String text = null;
		try {
			text = URLEncoder.encode("월드컵", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/book?query=" + text; // JSON 결과
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // XML 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		return responseBody;
	}

	public static void main(String[] args) {
		NaverAPI n = new NaverAPI();
		System.out.println(n.getBookList("평균의 종말"));

//		String clientId = "cQgsadLX1Trus8W0uCdn"; // 애플리케이션 클라이언트 아이디
//		String clientSecret = "PlBZ8d8QTF"; // 애플리케이션 클라이언트 시크릿
//
//		String text = null;
//		try {
//			text = URLEncoder.encode("월드컵", "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			throw new RuntimeException("검색어 인코딩 실패", e);
//		}
//
//		String apiURL = "https://openapi.naver.com/v1/search/book?query=" + text; // JSON 결과
//		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
//		// // XML 결과
//
//		Map<String, String> requestHeaders = new HashMap<>();
//		requestHeaders.put("X-Naver-Client-Id", clientId);
//		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
//		String responseBody = get(apiURL, requestHeaders);
//
//		System.out.println(responseBody);
//		JSONObject obj = new JSONObject(responseBody);
////        System.out.println(obj.toString());
////        System.out.println(obj.getJSONArray("items").toString());
//		JSONArray items = obj.getJSONArray("items");
//		List<NaverBlog> list = new ArrayList<>();
//		for (int i = 0; i < items.length(); i++) {
//			JSONObject item = (JSONObject) items.get(i);
////        	System.out.println(item.get("title"));
//			NaverBlog blog = new NaverBlog();
//			blog.setTitle(item.getString("title"));
//			blog.setLink(item.getString("link"));
//			blog.setDescription(item.getString("description"));
//			list.add(blog);
//		}
//		System.out.println(list);
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}
}