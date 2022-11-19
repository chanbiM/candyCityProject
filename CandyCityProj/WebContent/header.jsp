<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candy City</title>
<link rel="stylesheet" href="/css/mainStyle.css">
<script src="/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<!-- 창 바 -->
		<div class="window">
			<button class="widow_btn" id="-_btn">-</button>
			<button class="widow_btn" id="x_btn">X</button>
		</div>

		<header>
			<!-- 로고 -->
			<div class="logo">
				<a href="/index.jsp"><img alt="로고" src="/images/logo.png"></a>
			</div>

			<!-- 기타 메뉴바 -->
			<div class="minimenu">

				<ul>
					<%
						MemberVO vo = (MemberVO) session.getAttribute("loginOK");
						if (vo == null) {
					%>
					<li><a href="/member/login.jsp">로그인</a></li>
					<li><a href="/member/insertMember.jsp">회원가입</a></li>
					<li><a href="#">이용안내</a></li>
					<%
						} else {
					%>
					<li><a href="/member/myPage.jsp"><%=vo.getName()%>님</a></li>
					<li><a href="/logout"> 로그아웃 </a></li>
					<li><a href="/member/myPage.jsp">마이페이지</a></li>
					<li><a href="#">이용안내</a></li>

					<%
						}
					%>
				</ul>

			</div>
		</header>

		<!-- 메뉴바 -->
		<nav>
			<ul class="mainmenu">
				<li><a href="/getHomepiList">미니홈피</a>
					<ul class="submenu">
					<%
						if (vo == null) {
					%>
						<li><a href="/member/login.jsp">내 미니홈피</a></li>
						<li><a href="/getHomepiList">미니홈피 목록</a></li>
					<%
						} else {
					%>
						
						<li><a href="/GetHomepi?id=<%= vo.getId() %>">내 미니홈피</a></li>
						<li><a href="/getHomepiList">미니홈피 목록</a></li>
					<%
						}
					%>
					</ul></li>

				<li><a href="/character/shop.jsp">의상</a>
					<ul class="submenu">
					<%
						if (vo == null) {
					%>
						<li><a href="/member/login.jsp">내 의상</a></li>
						<li><a href="/character/shop.jsp">의상 상점</a></li>
					<% } else {
					%>
						<li><a href="/getcCostumeList?id=<%= vo.getId() %>&name=<%= vo.getName() %>">내 의상</a></li>
						<li><a href="/character/shop.jsp">의상 상점</a></li>
					<%	
					} %>
					</ul></li>

				<li><a href="#">캔디시티</a>
					<ul class="submenu">
					</ul></li>

				<li><a href="/getNoticeList?type=E">공지사항</a>
					<ul class="submenu">
						<li><a href="/getNoticeList?type=E">이벤트</a></li>
						<li><a href="/getNoticeList?type=N">공지사항</a></li>
						<li><a href="/getNoticeList?type=R">당첨자 발표</a></li>
					</ul></li>

				<%
					MemberVO adminVo = (MemberVO) session.getAttribute("manager");
					if (adminVo != null) {
				%>
				<li><a href="/member/memberList_admin.jsp">관리자용 메뉴</a>
					<ul class="submenu">
						<li><a href="#">유저 리스트</a></li>
						<!-- <li><a href="#">문의글 확인</a></li>
						<li><a href="#">신고글 확인</a></li> -->
						<li><a href="/admin/noticeInsert.jsp">공지사항/이벤트 작성</a></li>
					</ul></li>
			<%
				}
			%>
			</ul>

		</nav>