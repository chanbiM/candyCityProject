<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/homepiStyle.css">
	<!-- 미니홈피 보기-->
        <br>
			<!-- 유저 정보-->
			<div class="member_info">
				<ul>
					<li>
						<div class="profile_char">
						</div>
					</li>

					<li>
						<div class="info">
							<p>닉네임(아이디) <br>
								한줄소개</p>
							<br>
							<p>가입일: 00.00.00 | 마지막 로그인: 00.00.00</p>
							<br>
							<br>
							
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
				<a href="#" style="color: #804d66;">캐릭터 설정</a><br><br>
				<button id="post_btn"><a href="#">글쓰기</a></button>

				<p style="font-size: 16px;">게시글 수: &nbsp; 댓글 수: </p>
			</div>

			<div class="post_search">
				<!--게시글 목록으로 가게 -->
				<form action="#">
					<input type="text" name="post" placeholder="게시글 검색">
					<input type="submit" value="검색">
				</form>
			</div>

			<!--대표 게시글(가장 최근에쓴거 or 공지 게시글)-->
			<div class="representative_post">
				<h2><a href="#">게시글 제목</a></h2>
				<!--최종 수정 날짜 기준으로-->
				<p style="color: #804d66;">날짜</p>
				<br><br>
				<p id="post_content"><a href="#">게시글 내용</a></p>
				
				<div id="post_list">
					<button><a href="#">다른 게시글 더보기</a></button>
				</div>
				
			</div>
<%@ include file="/footer.jsp" %>