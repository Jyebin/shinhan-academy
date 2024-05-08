import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload2.do")
public class FileUpload2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			MultipartRequest mr = new MultipartRequest(request, // request 객체
//					"D:\\file_repo", // 경로
					request.getRealPath(getServletInfo("/upload")), //실제 경로를 가져다 줌
					1024 * 1024, // 사이즈. 용량
					"utf-8", new DefaultFileRenamePolicy()); // 파일 이름을 다시 짓는 정책을 구현한 클래스
			String fileName1 = mr.getFilesystemName("file1");
			System.out.println("실제파일명:" + fileName1);
			String fileName2 = mr.getOriginalFileName("file1"); // 실제 파일명과 original 파일명이 다름
			System.out.println("원본파일명:" + fileName2);

			System.out.println("param1:" + mr.getParameter("param1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}