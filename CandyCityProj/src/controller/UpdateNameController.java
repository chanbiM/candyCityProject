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


@WebServlet("/UpdateName")
public class UpdateNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateNameController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		int result = 0;
		MemberVO vo = (MemberVO) session.getAttribute("loginOK");
		
		
		String id, name;
		id = request.getParameter("id");
		name = request.getParameter("name");
		
		MemberDAO dao = new MemberDAO();
		
		
		result = dao.updateName(id, name);
		
		
		if(result > 0) {
			out.print("<script>alert('수정 성공')</script>");
			vo.setName(name);
			session.setAttribute("loginOK", vo);
			
			response.sendRedirect(contextPath + "/member/myPage.jsp"); 
		} else {
			out.print("<script>alert('수정 실패'); history.back(); </script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
