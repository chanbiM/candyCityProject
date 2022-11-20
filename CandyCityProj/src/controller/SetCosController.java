package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CharacterDAO;
import vo.CharacterVO;
import vo.MemberVO;


@WebServlet("/SetCos")
public class SetCosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SetCosController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String costumeCode = request.getParameter("costumeCode");
		String parts = request.getParameter("parts");
		
		CharacterDAO dao = new CharacterDAO();
		
		MemberVO memberVo = (MemberVO) session.getAttribute("loginOK");
		
		//입고있는 의상 조회
		CharacterVO charVo = dao.getCharacterCode(memberVo.getId());
		
		int n = 0;
		System.out.println(parts);
		//수정하고 셋
		if(parts.equals("head")) {
			n = dao.updateHeadCos(memberVo.getId(), costumeCode);
		} else if (parts.equals("eyes")) {
			n = dao.updateEyesCos(memberVo.getId(), costumeCode);
		} else if (parts.equals("body")) {
			n = dao.updateBodyCos(memberVo.getId(), costumeCode);
		} else if (parts.equals("shoes")) {
			n = dao.updateShoesCos(memberVo.getId(), costumeCode);
		} else {
			out.print("<script>alert('잘못된 접근'); history.back(); </script>");
		}
		
		if(n > 0) {
			response.sendRedirect("/characterSet"); 
		} else {
			out.print("<script>alert('수정 실패'); history.back(); </script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
