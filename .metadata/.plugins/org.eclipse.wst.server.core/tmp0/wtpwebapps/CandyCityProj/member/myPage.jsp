<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
	<h2>마이페이지</h2>
		<div class="content">
			<div class="myInfo">

			<form action="/UpdateName" method="get">
				<table class="info">
					<tr>
						<th rowspan="4">내정보</th>
						<td>아이디 </td>
						<td><input type="text" readonly value="<%= vo.getId() %>" name="id" class="infoText"></td>
					</tr>
					<tr>
						<td>닉네임</td>
						<td><input type="text" value="<%= vo.getName() %>" name="name" class="infoText"></td>
						<td><input type="submit" value="변경" class="updatebtn"></td>
					</tr>
					<tr><td>성별</td>
						<td><input type="text" readonly value=<%= vo.getGender() %> class="infoText"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td></td>
						<td class="open_popup">변경</td>
					</tr>
					<tr>
						<td colspan="4"><hr></td>
					<tr>
					
					<tr>
						<th rowspan="6">활동정보</th>
					</tr>
					<tr>
						<td>가입날짜</td>
						<td><%= vo.getJoinDate() %></td>
						<td class="open_popup_del">회원 탈퇴</td>
					</tr>
					<tr>
						<td>마지막 로그인</td>
						<td><%= vo.getLoginDate() %></td>
					</tr>
					
					
					<tr>
						<td>게시글 수</td>
						<td><%= vo.getPostNum() %>개</td>
					</tr>
					<tr>
						<td>캔디 수</td>
						<td><%= vo.getCandy() %>개</td>
					</tr>
				</table>
			</form>
				
			</div>
			
			<div class="popup_back">
				<div class="popup">
					<div class="window">
							<button class="widow_btn" id="-_btn">-</button>
							<button class="widow_btn" id="x_btn">X</button>
					</div>
					<br>
					<form action="/UpdatePwd">
						
						<h3>비밀번호 변경</h3> <br><br>
						현재 비밀번호: <input type="password" name="password"><br><br>
						바꿀 비밀먼호: <input type="password" name="newPassword"><br>
						<input type="reset" class="popup_close" value="닫기"> <input type="submit" value="변경" class="pwdUpdateBtn">
					</form>
				</div>
			</div>
			
			<div class="popup_back_del">
				<div class="popup_del">
					<div class="window">
							<button class="widow_btn" id="-_btn">-</button>
							<button class="widow_btn" id="x_btn">X</button>
					</div>
					<br>
					<form action="/memberDelete">
						
						<h3>정말로 탈퇴하시겠습니까?</h3> <br><br>
						<input type="reset" class="popup_close" value="아니요"> <input type="submit" value="탈퇴" class="pwdUpdateBtn">
					</form>
				</div>
			</div>
		</div>
<%@ include file="/footer.jsp" %>