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

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.file.FileUtil;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		BoardServiceInf boardService = new BoardService();
		BoardVo boardVo = boardService.getBoard(num);
		
		request.setAttribute("boardVo", boardVo);
		
		request.getRequestDispatcher("/jspBoard/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int board_num = Integer.parseInt(request.getParameter("board_num").trim());
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String file = request.getParameter("file");
		
		Part picPart = request.getPart("pic");
		
		BoardServiceInf boardService = new BoardService();
//		BoardVo boardVo = boardService.getBoard(num);
		
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoard_num(board_num);
		boardVo.setBoard_title(title);
		boardVo.setBoard_content(content);
		boardVo.setBoard_file(file);
		
		if(picPart.getSize() > 0){
			String contentDisposition = picPart.getHeader("Content-Disposition");
			String pic = FileUtil.getFileName(contentDisposition);
			String picpath = FileUtil.fileUploadPath;
			String picname = UUID.randomUUID().toString();
			
			boardVo.setBoard_pic(pic);
			boardVo.setBoard_file(picpath);
			boardVo.setBoard_filename(picname);
			
			picPart.write(picpath + File.separator + picname);
			picPart.delete();
		}
		
		boardService.updateBoard(boardVo);
		
		response.sendRedirect("/boardDetail?id=" + board_num);
	}

}
