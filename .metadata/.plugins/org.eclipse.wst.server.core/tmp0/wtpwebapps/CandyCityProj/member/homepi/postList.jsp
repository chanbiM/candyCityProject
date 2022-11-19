<%@page import="vo.PostVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/homepiStyle.css">
<link rel="stylesheet" href="/css/postListStyle.css">
<%
	MemberVO hompiData = (MemberVO) request.getAttribute("homepiUser");
	ArrayList<PostVO> postData = (ArrayList<PostVO>) request.getAttribute("postData");
%>
	        <!-- 미니홈피 보기-->
        <br>
        <h2><%= hompiData.getName() %>님의 게시글</h2>
			<!-- 버튼박스-->
			<div class="buttonBox">
			<button class="listBtn">
				<a href="/GetHomepi?id=<%= hompiData.getId() %>">미니홈피 보기</a>
			</button>
			<%
			if(vo != null) {
				
			%>
			<button class="listBtn">
				<a href="/GetHomepi?id=<%= vo.getId() %>">내 미니홈피로</a>
			</button>
			<%
			}
			%>
			
			</div>
			
			<div class="character_info">
	<div class="info_character">
		<!-- 유저캐릭터 전신 삽입-->
	</div>

	<!--내 홈피일 경우-->
	<%
	if(vo == null) {
	%>
		<br><br><br><br>
		<p style="font-size: 20px;">게시글 수: <%= hompiData.getPostNum() %> &nbsp; 댓글 수: <%= hompiData.getCommentNum() %></p>
	<%
	} else {
	%>
		<% if(vo.getId().equals(hompiData.getId())) {%>
		<a href="#" style="color: #804d66;">캐릭터 설정</a><br> <br>
		<button id="post_btn">
			<a href="/member/post/insertPost.jsp">글쓰기</a>
		</button>
		<% } %>
		<p style="font-size: 16px;">게시글 수: <%= hompiData.getPostNum() %> &nbsp; 댓글 수: <%= hompiData.getCommentNum() %></p>
	<% } %>

</div>

			<!--대표 게시글 목록-->
			<table id="post_list">
				<tr>
					<th class="number">
						번호
					</th>

					<th class="title">
						제목
					</th>

					<th class="name">
						날짜
					</th>
				</tr>

				<%
					int num = 1;
					for(PostVO data : postData) {
				%>
					<tr>
						<td>
							<a href="/GetPost?id=<%= data.getId() %>&postCode=<%= data.getPostCode() %>&name=<%= hompiData.getName() %>"><%= num %></a>
						</td>
						<td>
							<a href="/GetPost?id=<%= data.getId() %>&postCode=<%= data.getPostCode() %>&name=<%= hompiData.getName() %>"><%= data.getTitle() %></a>
						</td>
						<td>
						<%
                				if(data.getUpdateDate() == null) {
                			%>
                				<a href="/GetPost?id=<%= data.getId() %>&postCode=<%= data.getPostCode() %>&name=<%= hompiData.getName() %>"><%= data.getWriteDate() %></a>
                			<%
                				} else {
                			%>
                					<a href="/GetPost?id=<%= data.getId() %>&postCode=<%= data.getPostCode() %>&name=<%= hompiData.getName() %>"><%= data.getUpdateDate() %></a>
                			<%
                				}
                			%>
						</td>
				</tr>
					<% num++; %>
				<% } %>
				
				
			</table>
			
<%@ include file="/footer.jsp"%>