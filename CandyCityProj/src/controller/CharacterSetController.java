package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CharacterDAO;
import vo.CharacterVO;
import vo.CostumeVO;
import vo.MemberVO;

@WebServlet("/characterSet")
public class CharacterSetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CharacterSetController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		CharacterDAO dao = new CharacterDAO();
		
		MemberVO memberVo = (MemberVO) session.getAttribute("loginOK");
		
		//입고있는 의상 조회
		CharacterVO charVo = dao.getCharacterCode(memberVo.getId());
		
		//가지고 있는 의상 리스트 조회
		ArrayList<CostumeVO> list = dao.getCosList(memberVo.getId());
		
		request.setAttribute("costume", charVo);
		request.setAttribute("costumeList", list);
		
		request.getRequestDispatcher("/member/character/characterSetting.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
