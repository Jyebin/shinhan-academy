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

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

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
		String encoding = "utf-8";
		File currentDirPath = new File(System.getProperty("user.home") + "/Desktop"); // 업로드할 파일 경로 지정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); // 파일 경로를 설정
		factory.setSizeThreshold(1024 * 1024); // 최대 업로드 가능한 파일 크기 설정
		ServletFileUpload upload = new ServletFileUpload(factory); // 생성자가 fileItemFactory 객체를 받음
		try {
			List<FileItem> items = upload.parseRequest(request); // request 객체에서 매개변수를 List로 가져옴
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = items.get(i); // 파일 업로드창에서 업로드된 항목들을 하나씩 가져옴
				if (fileItem.isFormField()) { // 폼 필드이면
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding)); // 전송된 매개변수 값을 출력(이름, 값)
				} else { // 폼 필드가 아니면
					System.out.println("매개변수이름:" + fileItem.getString(encoding));
					System.out.println("파일이름:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
					if (fileItem.getSize() > 0) { // 파일 업로드 기능 수행
						int idx = fileItem.getName().lastIndexOf("/");
						if (idx == -1) { // 파일 경로에서 슬래시를 찾지 못한 경우
							idx = fileItem.getName().lastIndexOf("\\"); // Windows에서의 역슬래시도 확인
						}
						String fileName = fileItem.getName().substring(idx + 1); // 업로드한 파일 이름을 가져옴
						File uploadFile = new File(currentDirPath + "/" + fileName); // 맥 환경에서는 슬래시를 사용
						fileItem.write(uploadFile); // 업로드한 파일 이름으로 저장소에 파일을 업로드
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
