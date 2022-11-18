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
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/UpdatePwd")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdatePwdController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		int result = 0;
		boolean getResult = false;
		MemberVO vo = (MemberVO) session.getAttribute("loginOK");
		
		String password, newPassword;
		String id = vo.getId();
		password = request.getParameter("password");
		newPassword = request.getParameter("newPassword");
		
		
		MemberDAO dao = new MemberDAO();
		getResult = dao.getMemberPwd(id, password);
		if (getResult) {
			result = dao.updatePwd(id, newPassword);
			if(result > 0) {
				out.print("<script>alert('수정 성공')</script>");
				
				response.sendRedirect(contextPath + "/member/myPage.jsp"); 
			} else {
				out.print("<script>alert('수정 실패'); history.back(); </script>");
			}
			
		} else {
			out.print("<script>alert('비밀번호가 맞지 않습니다'); history.back(); </script>");
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
