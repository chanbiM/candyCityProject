/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.76
 * Generated at: 2022-11-20 07:49:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.MemberDAO;
import vo.MemberVO;

public final class myPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1668743315413L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1668922031363L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("dao.MemberDAO");
    _jspx_imports_classes.add("vo.MemberVO");
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
      out.write("						<li><a href=\"/member/login.jsp\">의상 설정</a></li>\r\n");
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
      out.write("						<li><a href=\"/characterSet\">의상 설정</a></li>\r\n");
      out.write("					");
	
					} 
      out.write("\r\n");
      out.write("					</ul></li>\r\n");
      out.write("\r\n");
      out.write("				<li><a href=\"/getCandyCityList\">캔디시티</a>\r\n");
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
      out.write("				<li><a href=\"/getUserList\">관리자용 메뉴</a>\r\n");
      out.write("					<ul class=\"submenu\">\r\n");
      out.write("						<li><a href=\"/getUserList\">유저 리스트</a></li>\r\n");
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
      out.write("	<h2>마이페이지</h2>\r\n");
      out.write("		<div class=\"content\">\r\n");
      out.write("			<div class=\"myInfo\">\r\n");
      out.write("\r\n");
      out.write("			<form action=\"/UpdateName\" method=\"get\">\r\n");
      out.write("				<table class=\"info\">\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th rowspan=\"4\">내정보</th>\r\n");
      out.write("						<td>아이디 </td>\r\n");
      out.write("						<td><input type=\"text\" readonly value=\"");
      out.print( vo.getId() );
      out.write("\" name=\"id\" class=\"infoText\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>닉네임</td>\r\n");
      out.write("						<td><input type=\"text\" value=\"");
      out.print( vo.getName() );
      out.write("\" name=\"name\" class=\"infoText\"></td>\r\n");
      out.write("						<td><input type=\"submit\" value=\"변경\" class=\"updatebtn\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr><td>성별</td>\r\n");
      out.write("						<td><input type=\"text\" readonly value=");
      out.print( vo.getGender() );
      out.write(" class=\"infoText\"></td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>비밀번호</td>\r\n");
      out.write("						<td></td>\r\n");
      out.write("						<td class=\"open_popup\">변경</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td colspan=\"4\"><hr></td>\r\n");
      out.write("					<tr>\r\n");
      out.write("					\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th rowspan=\"6\">활동정보</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>가입날짜</td>\r\n");
      out.write("						<td>");
      out.print( vo.getJoinDate() );
      out.write("</td>\r\n");
      out.write("						<td class=\"open_popup_del\">회원 탈퇴</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>마지막 로그인</td>\r\n");
      out.write("						<td>");
      out.print( vo.getLoginDate() );
      out.write("</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>게시글 수</td>\r\n");
      out.write("						<td>");
      out.print( vo.getPostNum() );
      out.write("개</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td>캔디 수</td>\r\n");
      out.write("						<td>");
      out.print( vo.getCandy() );
      out.write("개</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</table>\r\n");
      out.write("			</form>\r\n");
      out.write("				\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"popup_back\">\r\n");
      out.write("				<div class=\"popup\">\r\n");
      out.write("					<div class=\"window\">\r\n");
      out.write("							<button class=\"widow_btn\" id=\"-_btn\">-</button>\r\n");
      out.write("							<button class=\"widow_btn\" id=\"x_btn\">X</button>\r\n");
      out.write("					</div>\r\n");
      out.write("					<br>\r\n");
      out.write("					<form action=\"/UpdatePwd\">\r\n");
      out.write("						\r\n");
      out.write("						<h3>비밀번호 변경</h3> <br><br>\r\n");
      out.write("						현재 비밀번호: <input type=\"password\" name=\"password\"><br><br>\r\n");
      out.write("						바꿀 비밀먼호: <input type=\"password\" name=\"newPassword\"><br>\r\n");
      out.write("						<input type=\"reset\" class=\"popup_close\" value=\"닫기\"> <input type=\"submit\" value=\"변경\" class=\"pwdUpdateBtn\">\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			\r\n");
      out.write("			<div class=\"popup_back_del\">\r\n");
      out.write("				<div class=\"popup_del\">\r\n");
      out.write("					<div class=\"window\">\r\n");
      out.write("							<button class=\"widow_btn\" id=\"-_btn\">-</button>\r\n");
      out.write("							<button class=\"widow_btn\" id=\"x_btn\">X</button>\r\n");
      out.write("					</div>\r\n");
      out.write("					<br>\r\n");
      out.write("					<form action=\"/memberDelete\">\r\n");
      out.write("						\r\n");
      out.write("						<h3>정말로 탈퇴하시겠습니까?</h3> <br><br>\r\n");
      out.write("						<input type=\"reset\" class=\"popup_close\" value=\"아니요\"> <input type=\"submit\" value=\"탈퇴\" class=\"pwdUpdateBtn\">\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
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
