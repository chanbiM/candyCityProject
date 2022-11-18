package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		int result = 0;
		MemberVO vo = (MemberVO) session.getAttribute("loginOK");
		
		MemberDAO dao = new MemberDAO();
		String id = vo.getId();
		
		result = dao.deleteMember(id);
		
		if(result > 0) {
			out.print("<script>alert('삭제 성공')</script>");
			
			session.removeAttribute("loginOK");
			session.removeAttribute("manager");
			response.sendRedirect("/index.jsp");
		} else {
			out.print("<script>alert('삭제 실패'); history.back(); </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
