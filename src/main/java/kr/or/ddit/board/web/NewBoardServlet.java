package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class NewBoardServlet
 */
@WebServlet("/newBoard")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class NewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/SE2/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("std_id");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setStd_id(id);
		boardVo.setBoard_title(request.getParameter("board_title"));
		boardVo.setBoard_content(request.getParameter("smarteditor"));
		boardVo.setBoard_file(request.getParameter("file_id"));
		String fileName = request.getParameter("board_fileName");
		
		if(fileName == null){
			boardVo.setBoard_filename("기본이미지.jpg");
		}else{
			boardVo.setBoard_filename(fileName);
		}
		boardVo.setBoard_delete("n");
		
		BoardServiceInf boardService = new BoardService();
		
		boardService.insertBoard(boardVo);
		response.sendRedirect("/boardServlet?page=1&pageSize=10&postSelect=");
	}
}
