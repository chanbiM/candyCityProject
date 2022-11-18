<%@page import="java.util.ArrayList"%>
<%@page import="dao.PostDAO"%>
<%@page import="vo.PostVO"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/homepiStyle.css">

<!-- 미니홈피 보기-->
<br>
<%
	MemberVO hompiData = (MemberVO) request.getAttribute("homepiUser");
%>

<!-- 유저 정보-->
<div class="member_info">
	<ul>
		<li>
			<div class="profile_char"></div>
		</li>

		<li>
			<div class="info">
				<p><%=hompiData.getName()%>(<%=hompiData.getId()%>) <br>
					<%
						if (hompiData.getIntroduce() == null) {
					%>
					한줄 소개가 없습니다.
					<%
						} else {
					%>
					<%=hompiData.getJoin_num()%>
					<%
						}
					%>
				</p>
				<br>
				<p>
					가입일:
					<%=hompiData.getJoinDate()%>


					| 마지막 로그인:
					<%=hompiData.getLoginDate()%>
				</p>
				<br> <br>

			</div>
		</li>
		<li>
			<!--팝업형식-->
			<button id="homepi_info">미니홈피 정보</button>
		</li>
	</ul>


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

<div class="post_search">
	<!--게시글 목록으로 가게 -->
	<form action="/searchHomepiPost" method="get">
		<input type="hidden" name="id" value="<%= hompiData.getId() %>"> 
		<input type="text" name="postSearch" placeholder="게시글 검색"> <input
			type="submit" value="검색">
	</form>
</div>

<!--대표 게시글(가장 최근에쓴거 or 공지 게시글)-->
<div class="representative_post">
<% 
                	PostDAO dao = new PostDAO();
               		ArrayList<PostVO> list = dao.getRepresentativePost(hompiData.getId());
               			if(list.isEmpty()){
               	%>
               				<p align="center">게시물이 없습니다.</p>		
               			<%
               			}
               			for(PostVO data : list) {
                %>
                			<h2>
								<a href="#"><%= data.getTitle() %></a>
							</h2>
                			<!--최종 수정 날짜 기준으로-->
                			<%
                				if(data.getUpdateDate() == null) {
                			%>
                				<p style="color: #804d66;"><%= data.getWriteDate() %></p>
                			<%
                				} else {
                			%>
                					<p style="color: #804d66;"><%= data.getUpdateDate() %></p>
                			<%
                				}
                			%>
							
							<br> <br>
							<p id="post_content">
								<a href="#"><%= data.getContents() %></a>
							</p>
							<div id="post_list">
								<button>
								<a href="/GetPostList?id=<%= data.getId() %>">다른 게시글 더보기</a>
								</button>
							</div>
	
							<%
								if(data.getCommentO().equals("O")){
							%>
									<p>댓글창</p><br>
									<hr>
							<% } %>
							
				<%
               	}  %>
               	
      </div>
<%@ include file="/footer.jsp"%>