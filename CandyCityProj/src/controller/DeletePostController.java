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
import vo.MemberVO;
import vo.PostVO;


@WebServlet("/deletePost")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeletePostController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String contextPath = request.getContextPath();
		PrintWriter out = response.getWriter();
		String postCode = request.getParameter("postCode");
		
		MemberVO memberVo = (MemberVO) session.getAttribute("loginOK");
		
		PostDAO dao = new PostDAO();
		int result = 0;
		
		result = dao.deletePost(postCode);
	
		if(result > 0) {
			int upReslut = 0;
			upReslut = dao.updateMinusPostNum(memberVo.getId());
			
			if(upReslut > 0) {
				session.setAttribute("loginOK", memberVo);
				
				response.sendRedirect(contextPath + "/GetPostList?id="+memberVo.getId());
			} else {
				out.print("<script>alert('게시글 삭제 실패'); history.back(); </script>");
			}
		} else {
			out.print("<script>alert('게시글 삭제 실패'); history.back(); </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
