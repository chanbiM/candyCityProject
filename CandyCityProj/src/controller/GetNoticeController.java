package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDAO;
import dao.adminDAO;
import vo.NoticeVO;
import vo.PostVO;


@WebServlet("/getNotice")
public class GetNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetNoticeController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		adminDAO dao = new adminDAO();
		
		String noticeCode = request.getParameter("noticeCode");
		
		if(noticeCode == null) {
			out.println("<script>alert('잘못된 경로입니다'); history.back(); </script>");
		}
		
		NoticeVO noticeData = dao.getNoticeInfo(noticeCode);
		
		request.setAttribute("noticeData", noticeData);
		request.getRequestDispatcher("/member/event/notice.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
