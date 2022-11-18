<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/postStyle.css">
        <!-- 게시글 작성-->
        <br>
        <form action="/noticeInsert" method="get">
            <div class="top">
                <h2>게시글 작성</h2>
                
                <div class="right">
                    <ul>
                        <li>
                            <input type="radio" value="E" name="type" checked> 이벤트
                            <input type="radio" value="N" name="type" > 공지사항
                            <input type="radio" value="R" name="type" > 당첨자발표
                        </li>
                        <li>
                            <input type="reset" value="삭제">
                            
                        </li>
                        <li>
                            <input type="submit" value="등록">
                        </li>
                    </ul>        
                </div>
                
            </div>
            <hr>
            <input type="text" placeholder="제목을 입력해주세요." name="title">
            <br>
            <hr class="title-line">
            
            <textarea placeholder="내용을 입력해주세요." name="contents"></textarea>
        </form>
<%@ include file="/footer.jsp" %>