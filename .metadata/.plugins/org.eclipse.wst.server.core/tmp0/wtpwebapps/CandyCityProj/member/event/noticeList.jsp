<%@page import="vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/homepiStyle.css">
<link rel="stylesheet" href="/css/postListStyle.css">

	<br>
<%
	ArrayList<NoticeVO> noticeList = (ArrayList<NoticeVO>)request.getAttribute("noticeList");
	String type = (String)request.getAttribute("type");
%>
	<!--이벤트 목록-->
	<%
		if(type.equals("E")){
	%>
			<h2>이벤트 목록</h2> <br>
	<% } else if(type.equals("N")) {%>
			<h2>공지사항 목록</h2> <br>
	<% } else {%>
			<h2>당첨자 목록</h2> <br>
	<% } %>
	
			
			<table id="homepiList">
				<tr>
					<th class="number">
						번호
					</th>

					<th class="title">
						제목
					</th>

					<th class="date">
						날짜
					</th>
					
					<th class="end">
						종료 여부
					</th>
				</tr>

				<%
					int num = 1;
					for(NoticeVO data : noticeList) {
				%>
					<tr>
						<td>
							<a href="/getNotice?noticeCode=<%= data.getNoticeCode() %>"><%= num %></a>
						</td>
						<td>
							<a href="/getNotice?noticeCode=<%= data.getNoticeCode() %>"><%= data.getTitle() %></a>
						</td>
						<td>
							<a href="/getNotice?noticeCode=<%= data.getNoticeCode() %>"><%= data.getWriteDate() %></a>
						</td>
						<td>
							<% if(data.getEndO() == null){ %>
								<a href="/getNotice?noticeCode=<%= data.getNoticeCode() %>">진행중</a>
							<% } else {%>
								<a href="/getNotice?noticeCode=<%= data.getNoticeCode() %>">종료</a>
							<% } %>
						</td>
				</tr>
					<% num++; %>
				<% } %>
				
				
			</table>
			
<%@ include file="/footer.jsp"%>