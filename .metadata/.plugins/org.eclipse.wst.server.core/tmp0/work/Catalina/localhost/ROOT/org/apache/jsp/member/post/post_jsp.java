/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-11-19 16:09:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member.post;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import vo.CostumeVO;
import vo.CharacterVO;
import dao.CharacterDAO;
import vo.PostVO;
import java.util.ArrayList;
import dao.PostDAO;
import vo.MemberVO;

public final class post_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1668743315413L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1668872956174L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("vo.CharacterVO");
    _jspx_imports_classes.add("dao.PostDAO");
    _jspx_imports_classes.add("vo.CostumeVO");
    _jspx_imports_classes.add("vo.MemberVO");
    _jspx_imports_classes.add("vo.PostVO");
    _jspx_imports_classes.add("dao.CharacterDAO");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Candy City</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/mainStyle.css\">\r\n");
      out.write("<script src=\"/js/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<div class=\"wrapper\">\r\n");
      out.write("		<!-- 창 바 -->\r\n");
      out.write("		<div class=\"window\">\r\n");
      out.write("			<button class=\"widow_btn\" id=\"-_btn\">-</button>\r\n");
      out.write("			<button class=\"widow_btn\" id=\"x_btn\">X</button>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<header>\r\n");
      out.write("			<!-- 로고 -->\r\n");
      out.write("			<div class=\"logo\">\r\n");
      out.write("				<a href=\"/index.jsp\"><img alt=\"로고\" src=\"/images/logo.png\"></a>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			<!-- 기타 메뉴바 -->\r\n");
      out.write("			<div class=\"minimenu\">\r\n");
      out.write("\r\n");
      out.write("				<ul>\r\n");
      out.write("					");

						MemberVO vo = (MemberVO) session.getAttribute("loginOK");
						if (vo == null) {
					
      out.write("\r\n");
      out.write("					<li><a href=\"/member/login.jsp\">로그인</a></li>\r\n");
      out.write("					<li><a href=\"/member/insertMember.jsp\">회원가입</a></li>\r\n");
      out.write("					");

						} else {
					
      out.write("\r\n");
      out.write("					<li><a href=\"/member/myPage.jsp\">");
      out.print(vo.getName());
      out.write("님</a></li>\r\n");
      out.write("					<li><a href=\"/logout\"> 로그아웃 </a></li>\r\n");
      out.write("					<li><a href=\"/member/myPage.jsp\">마이페이지</a></li>\r\n");
      out.write("\r\n");
      out.write("					");

						}
					
      out.write("\r\n");
      out.write("				</ul>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("		</header>\r\n");
      out.write("\r\n");
      out.write("		<!-- 메뉴바 -->\r\n");
      out.write("		<nav>\r\n");
      out.write("			<ul class=\"mainmenu\">\r\n");
      out.write("				<li><a href=\"/getHomepiList\">미니홈피</a>\r\n");
      out.write("					<ul class=\"submenu\">\r\n");
      out.write("					");

						if (vo == null) {
					
      out.write("\r\n");
      out.write("						<li><a href=\"/member/login.jsp\">내 미니홈피</a></li>\r\n");
      out.write("						<li><a href=\"/getHomepiList\">미니홈피 목록</a></li>\r\n");
      out.write("					");

						} else {
					
      out.write("\r\n");
      out.write("						\r\n");
      out.write("						<li><a href=\"/GetHomepi?id=");
      out.print( vo.getId() );
      out.write("\">내 미니홈피</a></li>\r\n");
      out.write("						<li><a href=\"/getHomepiList\">미니홈피 목록</a></li>\r\n");
      out.write("					");

						}
					
      out.write("\r\n");
      out.write("					</ul></li>\r\n");
      out.write("\r\n");
      out.write("				<li><a href=\"#\">의상</a>\r\n");
      out.write("					<ul class=\"submenu\">\r\n");
      out.write("					");

						if (vo == null) {
					
      out.write("\r\n");
      out.write("						<li><a href=\"/member/login.jsp\">내 의상</a></li>\r\n");
      out.write("						<li><a href=\"/member/login.jsp\">의상 상점</a></li>\r\n");
      out.write("					");
 } else {
					
      out.write("\r\n");
      out.write("						<li><a href=\"/getcCostumeList?id=");
      out.print( vo.getId() );
      out.write("&name=");
      out.print( vo.getName() );
      out.write("\">내 의상</a></li>\r\n");
      out.write("						<li><a href=\"/getShopList?id=");
      out.print( vo.getId() );
      out.write("\">의상 상점</a></li>\r\n");
      out.write("					");
	
					} 
      out.write("\r\n");
      out.write("					</ul></li>\r\n");
      out.write("\r\n");
      out.write("				<li><a href=\"#\">캔디시티</a>\r\n");
      out.write("					<ul class=\"submenu\">\r\n");
      out.write("					</ul></li>\r\n");
      out.write("\r\n");
      out.write("				<li><a href=\"/getNoticeList?type=E\">공지사항</a>\r\n");
      out.write("					<ul class=\"submenu\">\r\n");
      out.write("						<li><a href=\"/getNoticeList?type=E\">이벤트</a></li>\r\n");
      out.write("						<li><a href=\"/getNoticeList?type=N\">공지사항</a></li>\r\n");
      out.write("						<li><a href=\"/getNoticeList?type=R\">당첨자 발표</a></li>\r\n");
      out.write("					</ul></li>\r\n");
      out.write("\r\n");
      out.write("				");

					MemberVO adminVo = (MemberVO) session.getAttribute("manager");
					if (adminVo != null) {
				
      out.write("\r\n");
      out.write("				<li><a href=\"/member/memberList_admin.jsp\">관리자용 메뉴</a>\r\n");
      out.write("					<ul class=\"submenu\">\r\n");
      out.write("						<li><a href=\"#\">유저 리스트</a></li>\r\n");
      out.write("						<!-- <li><a href=\"#\">문의글 확인</a></li>\r\n");
      out.write("						<li><a href=\"#\">신고글 확인</a></li> -->\r\n");
      out.write("						<li><a href=\"/admin/noticeInsert.jsp\">공지사항/이벤트 작성</a></li>\r\n");
      out.write("					</ul></li>\r\n");
      out.write("			");

				}
			
      out.write("\r\n");
      out.write("			</ul>\r\n");
      out.write("\r\n");
      out.write("		</nav>");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/css/homepiStyle.css\">\r\n");

	PostVO postData = (PostVO) request.getAttribute("postData");
	String homepiName = (String) request.getAttribute("hompiName");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"character_info\">\r\n");
      out.write("	<div class=\"info_character\">\r\n");
 
			CharacterDAO charDao = new CharacterDAO();
			CharacterVO charVo = new CharacterVO();
			
			charVo = charDao.getCharacterCode(postData.getId());
			
			CostumeVO head = new CostumeVO();
			CostumeVO eyes = new CostumeVO();
			CostumeVO body = new CostumeVO();
			CostumeVO shoes = new CostumeVO();
			
			head = charDao.getCostumeInfo(charVo.getHead());
			eyes = charDao.getCostumeInfo(charVo.getEyes());
			body = charDao.getCostumeInfo(charVo.getBody());
			shoes = charDao.getCostumeInfo(charVo.getShoes());
			
			if(charVo.getHead() != null){

      out.write("\r\n");
      out.write("				<img alt=\"머리\" src=\"/images/costume/");
      out.print( head.getName() );
      out.write("\" class=\"head\">\r\n");

			}
			if(charVo.getEyes() != null){

      out.write("\r\n");
      out.write("				<img alt=\"눈\" src=\"/images/costume/");
      out.print( eyes.getName() );
      out.write("\" class=\"eyes\">\r\n");

			}if(charVo.getBody() != null){

      out.write("\r\n");
      out.write("				<img alt=\"몸\" src=\"/images/costume/");
      out.print( body.getName() );
      out.write("\" class=\"body\">\r\n");

			} if(charVo.getShoes() != null){

      out.write("\r\n");
      out.write("				<img alt=\"신발\" src=\"/images/costume/");
      out.print( shoes.getName() );
      out.write("\" class=\"shoes\">\r\n");

			}
			

      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<img alt=\"캐릭터\" src=\"/images/costume/character.png\">\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!--내 홈피일 경우-->\r\n");
      out.write("	");

	if(vo == null) {
	
      out.write("\r\n");
      out.write("		<br><br><br><br>\r\n");
      out.write("		<p style=\"font-size: 20px;\">");
      out.print( homepiName );
      out.write("님의 게시글</p>\r\n");
      out.write("	");

	} else {
	
      out.write("\r\n");
      out.write("		");
 if(vo.getId().equals(postData.getId())) {
      out.write("\r\n");
      out.write("		<p style=\"font-size: 16px;\">");
      out.print( homepiName );
      out.write("님의 게시글</p> <br>\r\n");
      out.write("		<button id=\"post_btn\">\r\n");
      out.write("			<a href=\"/member/post/insertPost.jsp\">글쓰기</a>\r\n");
      out.write("		</button><br>\r\n");
      out.write("		<a href=\"/characterSet?id=");
      out.print( postData.getId() );
      out.write("\" style=\"color: #804d66;\">캐릭터 설정</a><br> <br>\r\n");
      out.write("		");
 } 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("<div class=\"post_search\">\r\n");
      out.write("	<!--게시글 목록으로 가게 -->\r\n");
      out.write("	<form action=\"/searchHomepiPost\" method=\"get\">\r\n");
      out.write("		<input type=\"hidden\" name=\"id\" value=\"");
      out.print( postData.getId() );
      out.write("\"> \r\n");
      out.write("		<input type=\"text\" name=\"postSearch\" placeholder=\"게시글 검색\"> <input\r\n");
      out.write("			type=\"submit\" value=\"검색\">\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--게시글-->\r\n");
      out.write("<div class=\"post\">\r\n");
 
               			if(postData.getPostCode() == null){
               	
      out.write("\r\n");
      out.write("               				<p align=\"center\">존재하지 않는 게시물 입니다.</p>		\r\n");
      out.write("               			");

               			}
                
      out.write("\r\n");
      out.write("                			<h2 class=\"title\">\r\n");
      out.write("								");
      out.print( postData.getTitle() );
      out.write("\r\n");
      out.write("							</h2>\r\n");
      out.write("                			<!--최종 수정 날짜 기준으로-->\r\n");
      out.write("                			");

                				if(postData.getUpdateDate() == null) {
                			
      out.write("\r\n");
      out.write("                				<p style=\"color: #804d66;\">");
      out.print( postData.getWriteDate() );
      out.write("</p>\r\n");
      out.write("                			");

                				} else {
                			
      out.write("\r\n");
      out.write("                					<p style=\"color: #804d66;\">");
      out.print( postData.getUpdateDate() );
      out.write("</p>\r\n");
      out.write("                			");

                				}
                			
      out.write("\r\n");
      out.write("							\r\n");
      out.write("							<br> <br>\r\n");
      out.write("							<p id=\"post_content\">\r\n");
      out.write("								");
      out.print( postData.getContents() );
      out.write("\r\n");
      out.write("							</p>\r\n");
      out.write("							<div id=\"post_list\">\r\n");
      out.write("								<button>\r\n");
      out.write("								<a href=\"/GetPostList?id=");
      out.print( postData.getId() );
      out.write("\">다른 게시글 더보기</a>\r\n");
      out.write("								</button>\r\n");
      out.write("							</div>\r\n");
      out.write("	\r\n");
      out.write("							");

								if(postData.getCommentO().equals("O")){
							
      out.write("\r\n");
      out.write("									<p>댓글창</p><br>\r\n");
      out.write("									<hr>\r\n");
      out.write("							");
 } 
      out.write("\r\n");
      out.write("							\r\n");
      out.write("               	\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- 푸터 영역 -->\r\n");
      out.write("        <footer>\r\n");
      out.write("            <!-- 하단로고 -->\r\n");
      out.write("            <div>\r\n");
      out.write("                <a href=\"/index.jsp\" class=\"logo\">\r\n");
      out.write("                    <img src=\"/images/logo.png\" alt=\"로고\" >\r\n");
      out.write("                </a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- 카피라이트 -->\r\n");
      out.write("            <div class=\"copyright\">\r\n");
      out.write("                <p> Copyright &copy; 2022 chanbi all rights reserved</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- SNS -->\r\n");
      out.write("            <div>\r\n");
      out.write("                <ul class=\"sns\">\r\n");
      out.write("                    <li><a href=\"https://www.youtube.com/@rorochanbi\"><img src=\"/images/youtube.png\" alt=\"유튜브\" height=\"40\"></a></li>\r\n");
      out.write("                    <li><a href=\"#\"><img src=\"/images/facebook.png\" alt=\"페이스북\" height=\"40\"></a></li>\r\n");
      out.write("                    <li><a href=\"https://open.kakao.com/o/s1olGebe\"><img src=\"/images/kakao.png\" alt=\"카카오톡\" height=\"40\"></a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("    </div>\r\n");
      out.write("	<script src=\"/js/script.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
