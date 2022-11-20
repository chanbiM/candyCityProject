<%@page import="dao.CharacterDAO"%>
<%@page import="vo.CharacterVO"%>
<%@page import="vo.CostumeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/characterStyle.css">

	<br>
<%
	CharacterDAO charDao = new CharacterDAO();
	ArrayList<CostumeVO> costumeList = (ArrayList<CostumeVO>)request.getAttribute("costumeList");
	CharacterVO costume = (CharacterVO) request.getAttribute("costume");
	
	CostumeVO head = charDao.getCostumeInfo(costume.getHead());
	CostumeVO eyes = charDao.getCostumeInfo(costume.getEyes());
	CostumeVO body = charDao.getCostumeInfo(costume.getBody());
	CostumeVO shoes = charDao.getCostumeInfo(costume.getShoes());

%>
	<h2>의상 설정</h2> <br>
	<!-- 저장 -->
	<div class="info_character">
	
<%
			if(costume.getHead() != null){
%>
				<img alt="머리" src="/images/costume/<%= head.getName() %>" class="head" style="z-index: 60;">
<%
			}
			if(costume.getEyes() != null){
%>
				<img alt="눈" src="/images/costume/<%= eyes.getName() %>" class="eyes" style="z-index: 59;">
<%
			}if(costume.getBody() != null){
%>
				<img alt="몸" src="/images/costume/<%= body.getName() %>" class="body" style="z-index: 61;">
<%
			} if(costume.getShoes() != null){
%>
				<img alt="신발" src="/images/costume/<%= shoes.getName() %>" class="shoes" style="z-index: 57;">
<%
			}
			
%>

		<img alt="캐릭터" src="/images/costume/character.png" style="z-index: 40;">
	
	</div>
	<!-- 착용샷 보여주기 -->
	
	
	
	<!-- 의상 목록 -->
<%
	if(costumeList.isEmpty()){
%>
		<h3>의상이 없습니다.</h3>
<%
	} else {
%>
	
	<ul class="mainList">
	<% 
		int n = 1;
		for(CostumeVO data : costumeList) { 
	%>
		<li>
			<ul class="subList">
				<li><img alt="의상" src="/images/costume/<%= data.getName() %>"></li>
				<li><%= data.getCostumeName() %></li>
				<li><a href="/SetCos?costumeCode=<%= data.getCostumeCode() %>&parts=<%= data.getParts() %>" class="setBtn"><button class="setBtn">착용</button></a></li>
			</ul>		
		</li>
	<%
	}%>
	</ul>
	<% } %>
		
	

<%@ include file="/footer.jsp"%>