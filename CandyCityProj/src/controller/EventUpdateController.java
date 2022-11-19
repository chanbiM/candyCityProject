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
import dao.adminDAO;
import vo.MemberVO;


@WebServlet("/eventUpdate")
public class EventUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EventUpdateController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		int result = 0;
		MemberVO memberVo = (MemberVO) session.getAttribute("manager");
		
		
		String noticeCode, type;
		noticeCode = request.getParameter("noticeCode");
		type = request.getParameter("type");
		
		adminDAO dao = new adminDAO();
		
		result = dao.updateEnd(noticeCode);
		
		
		if(result > 0) {
			out.print("<script>alert('수정 성공')</script>");
			
			response.sendRedirect(contextPath + "/getNoticeList?type="+type); 
		} else {
			out.print("<script>alert('수정 실패'); history.back(); </script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}