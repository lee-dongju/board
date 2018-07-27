package kr.or.ddit.post.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

/**
 * Servlet implementation class NewBoard
 */
@WebServlet("/newPostServlet")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PostServiceInf postService = new PostService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<PostVo> postList = postService.getAllPost();
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("/jspBoard/newPost.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String postName = request.getParameter("name");
		String postSelect = request.getParameter("postSelect");
		
		PostVo postVo = new PostVo();
		
		postVo.setPostName(postName);
		postVo.setPostList_use(postSelect);
		
		postService.insertPost(postVo);
		
		List<PostVo> postList = postService.getAllPost();
		request.setAttribute("postList", postList);
		
		request.getRequestDispatcher("/jspBoard/newPost.jsp").forward(request, response);
	}
}
