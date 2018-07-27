package kr.or.ddit.board.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;











import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.kisa.seed.KISA_SEED_CBC;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostServiceInf postService = new PostService();
		
		List<PostVo> postList = postService.getAllPost();
		request.setAttribute("postList", postList);
		request.getRequestDispatcher("/jspBoard/newPost.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("지나갑니까");
		Map<String, String> stdInfo = new HashMap<String, String>();
		StudentVo studenVo = new StudentVo();

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		System.out.println("찍히나?");
		studenVo.setStd_id(request.getParameter("std_id"));
		studenVo.setPass(request.getParameter("pass"));
		
		String passEncrypt = KISA_SEED_CBC.Encrypt(studenVo.getPass());
		
		stdInfo.put("std_id", studenVo.getStd_id());
		stdInfo.put("pass", passEncrypt);
		
		StudentServiceInf studentService = new StudentService();
		StudentVo sv = studentService.getStudentInfo(stdInfo);
		
		if(sv == null){
			response.sendRedirect("/login.jsp");
			return;
		}
		
		if(sv.getStd_id().equals(studenVo.getStd_id()) && sv.getPass().equals(passEncrypt)){
			session.setAttribute("sv", sv);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
	}
}
