package book;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import util.NaverAPI;

@WebServlet("/book/list2.do")
public class BookList2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord"); // 클라이언트에서 전송되는 파라미터 값이랑 정확하게 일치해야 함
		NaverAPI n = new NaverAPI();
		String result = n.getBookList(searchWord);
		// Map > List > Map
		try {
			Map<String, Object> map = new HashMap<>();
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(result);

			map.put("lastBuildDate", obj.get("lastBuildDate"));
			map.put("total", obj.get("total"));

			JSONArray items = (JSONArray) obj.get("items");
			List<Map<String, String>> list = new ArrayList<>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject item = (JSONObject) items.get(i);
				Map<String, String> map2 = new HashMap<>();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
