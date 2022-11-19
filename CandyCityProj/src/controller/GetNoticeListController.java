package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dao.adminDAO;
import vo.MemberVO;
import vo.NoticeVO;

@WebServlet("/getNoticeList")
public class GetNoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetNoticeListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		adminDAO dao = new adminDAO();
		String type = request.getParameter("type");
		System.out.println(type);
		
		ArrayList<NoticeVO> noticeList = dao.getNoticeList(type);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/member/event/noticeList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
