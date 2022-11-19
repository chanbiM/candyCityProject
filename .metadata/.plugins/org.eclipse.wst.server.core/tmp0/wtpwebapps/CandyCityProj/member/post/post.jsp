<%@page import="vo.PostVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/homepiStyle.css">
<%
	PostVO postData = (PostVO) request.getAttribute("postData");
	String homepiName = (String) request.getAttribute("hompiName");
%>


<div class="character_info">
	<div class="info_character">
		<!-- 유저캐릭터 전신 삽입-->
	</div>

	<!--내 홈피일 경우-->
	<%
	if(vo == null) {
	%>
		<br><br><br><br>
		<p style="font-size: 20px;"><%= homepiName %>님의 게시글</p>
	<%
	} else {
	%>
		<% if(vo.getId().equals(postData.getId())) {%>
		<a href="#" style="color: #804d66;">캐릭터 설정</a><br> <br>
		<button id="post_btn">
			<a href="/member/post/insertPost.jsp">글쓰기</a>
		</button>
		<% } %>
		<p style="font-size: 16px;"><%= homepiName %>님의 게시글</p>
	<% } %>
</div>
	
<div class="post_search">
	<!--게시글 목록으로 가게 -->
	<form action="/searchHomepiPost" method="get">
		<input type="hidden" name="id" value="<%= postData.getId() %>"> 
		<input type="text" name="postSearch" placeholder="게시글 검색"> <input
			type="submit" value="검색">
	</form>
</div>

<!--게시글-->
<div class="post">
<% 
               			if(postData.getPostCode() == null){
               	%>
               				<p align="center">존재하지 않는 게시물 입니다.</p>		
               			<%
               			}
                %>
                			<h2 class="title">
								<%= postData.getTitle() %>
							</h2>
                			<!--최종 수정 날짜 기준으로-->
                			<%
                				if(postData.getUpdateDate() == null) {
                			%>
                				<p style="color: #804d66;"><%= postData.getWriteDate() %></p>
                			<%
                				} else {
                			%>
                					<p style="color: #804d66;"><%= postData.getUpdateDate() %></p>
                			<%
                				}
                			%>
							
							<br> <br>
							<p id="post_content">
								<%= postData.getContents() %>
							</p>
							<div id="post_list">
								<button>
								<a href="/GetPostList?id=<%= postData.getId() %>">다른 게시글 더보기</a>
								</button>
							</div>
	
							<%
								if(postData.getCommentO().equals("O")){
							%>
									<p>댓글창</p><br>
									<hr>
							<% } %>
							
               	
      </div>
<%@ include file="/footer.jsp"%>