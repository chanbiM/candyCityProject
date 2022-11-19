<%@page import="vo.NoticeVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/homepiStyle.css">
<%
	NoticeVO noticeData = (NoticeVO) request.getAttribute("noticeData");
%>

<!--공지사항-->
<div class="notice">
<% 
               			if(noticeData.getNoticeCode() == null){
               	%>
               				<p align="center">존재하지 않는 게시물 입니다.</p>		
               			<%
               			}
                %>
                			<h2 class="title">
								<%= noticeData.getTitle() %>
							</h2>
                			<p style="color: #804d66;"><%= noticeData.getWriteDate() %></p>
							
							<br> <br>
							<p id="notice_content">
								<%= noticeData.getContents() %>
							</p>
							<div id="notice_list">
								<button>
								<a href="/getNoticeList?type=<%= noticeData.getType() %>">다른 공지 더보기</a>
								</button>
							</div>
							
					<%
					if (adminVo != null) {
				%>
						<div id="endBtn">
								<a href="/eventUpdate?noticeCode=<%= noticeData.getNoticeCode()%>&type=<%= noticeData.getType() %>">이벤트 종료</a>
							</div>
				<%
				}%>
							
	
      </div>
<%@ include file="/footer.jsp"%>