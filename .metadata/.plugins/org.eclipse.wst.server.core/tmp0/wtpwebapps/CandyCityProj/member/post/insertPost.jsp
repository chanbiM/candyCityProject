<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<link rel="stylesheet" href="/css/postStyle.css">
        <!-- 게시글 작성-->
        <br>
        <form action="/postInsert" method="post">
            <div class="top">
                <h2>게시글 작성</h2>
                
                <div class="right">
                    <ul>
                        <li>
                            <input type="radio" value="O" name="comment" checked>댓글허용
                        </li>
                        <li>
                            <select name="postOption">
                                <option value="basic">전체 게시글</option>
                                <option value="secret">비밀 게시글</option>
                            </select>
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
            
            <textarea placeholder="내용을 입력해주세요." name="post"></textarea>
        </form>
<%@ include file="/footer.jsp" %>