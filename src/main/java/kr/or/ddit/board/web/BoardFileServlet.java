package kr.or.ddit.board.web;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.file.FileUtil;

/**
 * Servlet implementation class BoardFileServlet
 */
@WebServlet("/boardFile")
@MultipartConfig(maxFileSize=1024*1000*5, maxRequestSize=1024*1000*16)
public class BoardFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part uploadFilePart = request.getPart("uploadFile");
		
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		String fileName = FileUtil.getFileName(contentDisposition);
	
		String path = FileUtil.fileUploadPath;
		
		if(uploadFilePart.getSize() > 0){
			uploadFilePart.write(path + File.separator + UUID.randomUUID().toString());
			uploadFilePart.delete();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
