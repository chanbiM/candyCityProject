package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDAO;
import dao.adminDAO;
import vo.MemberVO;
import vo.NoticeVO;
import vo.PostVO;


@WebServlet("/noticeInsert")
public class noticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public noticeInsertController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		
		MemberVO memberVo = (MemberVO) session.getAttribute("manager");
		
		if (memberVo == null) {
			out.print("<script>alert('관리자가 아닙니다.') history.back(); </script>");
		}
		
		NoticeVO vo = new NoticeVO();
		adminDAO dao = new adminDAO();
		int result = 0;
		String type = request.getParameter("type");
		
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		vo.setType(type);
		
		if(request.getParameter("title") == null){
			out.print("<script>alert('제목을 입력해주세요.'); history.back(); </script>");
		} else {
			if(request.getParameter("contents") == null) {
				out.print("<script>alert('내용을 입력해주세요.'); history.back(); </script>");
			} else {
				result = dao.insertNotice(vo, memberVo);
				
				if(result > 0) {
					out.print("<script>alert('게시글 작성 성공')</script>");
					session.setAttribute("loginOK", memberVo);
						
					response.sendRedirect(contextPath + "/getNoticeList?type="+type); 
				} else {
					out.print("<script>alert('게시글 작성 실패'); history.back(); </script>");
				}
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
