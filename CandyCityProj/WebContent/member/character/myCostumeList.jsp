<%@page import="vo.CostumeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<link rel="stylesheet" href="/css/characterStyle.css">

	<br>
<%
	ArrayList<CostumeVO> costumeList = (ArrayList<CostumeVO>)request.getAttribute("costumeList");
	String userName = (String) request.getAttribute("name");
%>
	<h2>가지고 있는 의상</h2> <br>
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
			</ul>		
		</li>
	<%
	}%>
	</ul>
	<% } %>
		
	

<%@ include file="/footer.jsp"%>