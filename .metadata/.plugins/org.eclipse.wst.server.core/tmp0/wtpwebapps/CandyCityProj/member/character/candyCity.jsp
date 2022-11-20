<%@page import="dao.CharacterDAO"%>
<%@page import="vo.CharacterVO"%>
<%@page import="vo.CostumeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/homepiStyle.css">
<link rel="stylesheet" href="/css/postListStyle.css">


<br>
<%
	ArrayList<MemberVO> candiCityList = (ArrayList<MemberVO>) request.getAttribute("candiCityList");
%>
<h2>캔디시티</h2>
<br>

<div class="candyCity">
	<ul class="mainList">
		<%
			for (MemberVO data : candiCityList) {
				//아바타 출력
				CharacterDAO charDao = new CharacterDAO();
				CharacterVO costume = charDao.getCharacterCode(data.getId());

				CostumeVO head = charDao.getCostumeInfo(costume.getHead());
				CostumeVO eyes = charDao.getCostumeInfo(costume.getEyes());
				CostumeVO body = charDao.getCostumeInfo(costume.getBody());
				CostumeVO shoes = charDao.getCostumeInfo(costume.getShoes());
		%>
				<li>
					<ul class="subList">
						<li class="char">
<%
						if (costume.getHead() != null) {
%> 							<a href="/GetHomepi?id=<%=data.getId()%>"><img alt="머리" src="/images/costume/<%=head.getName()%>" class="head"></a> <%
 						}
 						if (costume.getEyes() != null) {
 %> 			
 							<a href="/GetHomepi?id=<%=data.getId()%>"><img alt="눈" src="/images/costume/<%=eyes.getName()%>" class="eyes"></a>
<%
						}
						if (costume.getBody() != null) {
%> 
							<a href="/GetHomepi?id=<%=data.getId()%>"><img alt="몸" src="/images/costume/<%=body.getName()%>" class="body"></a>
<%
						}
						if (costume.getShoes() != null) {
%> 				
							<a href="/GetHomepi?id=<%=data.getId()%>"><img alt="신발" src="/images/costume/<%=shoes.getName()%>" class="shoes"></a> <%
 						}
%> 
 				
 						<a href="/GetHomepi?id=<%=data.getId()%>"> <img alt="캐릭터" src="/images/costume/character.png" class="character"></a>
					</li>
					</ul>
					
				</li>
	
		<%
			}
		%>		

	</ul>
		<img alt="캔디시티 배경" src="/images/candycityBack.png" id="candy_back"
		width="1280" height="300"> 
</div>
<br>

<!--미니홈피 목록-->
<table id="homepiList">
	<tr>
		<th class="number">번호</th>

		<th class="nickName">닉네임</th>
	</tr>

	<%
		int num = 1;
		for (MemberVO data : candiCityList) {
	%>
	<tr>
		<td><a href="/GetHomepi?id=<%=data.getId()%>"><%=num%></a></td>
		<td><a href="/GetHomepi?id=<%=data.getId()%>"><%=data.getName()%></a>
		</td>
	</tr>
	<%
		num++;
	%>
	<%
		}
	%>


</table>



<%@ include file="/footer.jsp"%>