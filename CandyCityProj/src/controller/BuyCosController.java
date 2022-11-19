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
import dao.MemberDAO;
import vo.CostumeVO;
import vo.MemberVO;

@WebServlet("/buyCos")
public class BuyCosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuyCosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String costumeCode = request.getParameter("costumeCode");
		int price = Integer.parseInt(request.getParameter("price"));
		CharacterDAO dao = new CharacterDAO(); 
		MemberVO memberVo = (MemberVO) session.getAttribute("loginOK");
		
		if (memberVo.getCandy() < price) {
			out.print("<script>alert('캔디가 부족합니다.'); history.back(); </script>");
		} else {
			//구매하기
			int result = dao.buyCos(id, costumeCode);
			
			
			if(result > 0) {
				int upRs = dao.updateCandyNum(id, price);
				if(upRs > 0) {
					memberVo.setCandy(memberVo.getCandy()-price);
					session.setAttribute("loginOK", memberVo);
					
					response.sendRedirect("/getShopList?id="+id); 
				} else {
					out.print("<script>alert('구매 실패'); history.back(); </script>");
				}
				
			} else {
				out.print("<script>alert('구매 실패'); history.back(); </script>");
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
