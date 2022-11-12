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

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8;");
		
		//나머지도 겟하기
		String id, pwd;
		boolean result = false;
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		pwd = request.getParameter("pwd");
		System.out.println(request.getParameter("pwd"));
		
		MemberDAO dao = new MemberDAO();
		result = dao.getMemberPwd(id, pwd);
				
		if(result) {
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginOK", vo);
			
			boolean managerRs = dao.getAdmin(id);
			if(managerRs) {
				session.setAttribute("manager", vo);
				System.out.println("관리자입니다.");
				response.sendRedirect("../index.jsp");
			} else {
				response.sendRedirect("../index.jsp");
			}
			
			
		} else {
			out.println("<script> alert('회원정보가 맞지 않습니다.'); history.back(); </script>");
		}
	}

}
