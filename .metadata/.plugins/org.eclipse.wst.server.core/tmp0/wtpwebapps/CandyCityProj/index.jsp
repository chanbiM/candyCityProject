<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
        <!-- 슬라이드 영역 -->
        <div id="slide">
            <ul>
                <li><a href="#"><img src="./images/slide1.jpg" alt="슬라이드1"></a></li>
                <li><a href="#"><img src="./images/slide2.jpg" alt="슬라이드2"></a></li>
                <li><a href="#"><img src="./images/slide3.jpg" alt="슬라이드3"></a></li>
            </ul>
        </div>
        <!-- 섹션영역 -->
        <!-- section>div*3 -->
        <section>

            <!-- 공지사항 / 갤러리 영역 -->
            <div id="content_container">
                <!-- 탭 요소들 -->
                <div class="tab">
                    <!-- 활성화돼있는 탭을 구분하기 위해 active 클래스 사용 -->
                    <!-- 기본적으로 활성화 돼있는 요소는 공지사항 -->
                    <div id="post_tab" class="active"><a href="#">공지사항</a></div>
                    <div id="gallary_tab"><a href="#">갤러리</a></div>
                </div>
                <!-- 내용 요소들 -->
                <!-- post, gallary 둘 중 하나는 기본적으로 가림 -->
                <!-- 상단의 활성화된 탭에 의해 보여줄 요소가 달라지게 될것 -->
                <div class="content">
                    <!-- 공지사항 -->
                    <div id="post">
                        <!-- ul>li*5>a -->
                        <ul>
                            <!-- 첫번째 요소 클릭시 팝업 보이게 해야됨 -->
                            <li id="open_popup"><a href="#">에베베베ㅔ에베베베ㅔ에베베베ㅔ에베베베ㅔ</a></li>
                            <li><a href="#">에베베베ㅔ에베베베ㅔ에베베베ㅔ</a></li>
                            <li><a href="#">에베베베ㅔ에베베베ㅔ에베베베ㅔ</a></li>
                            <li><a href="#">에베베베ㅔ에베베베ㅔ에베베베ㅔ에베베베ㅔ</a></li>
                            <li><a href="#">에베베베ㅔ에베베베ㅔ에베베베ㅔ에베베베ㅔ</a></li>
                        </ul>
                    </div>
                    <!-- 갤러리 -->
                    <div id="gallary">
                        <!-- ul>li*3>a>img -->
                        <ul>
                            <li><a href="#"><img src="./images/gallery1.jpg" alt="갤러리1"></a></li>
                            <li><a href="#"><img src="./images/gallery2.jpg" alt="갤러리2"></a></li>
                            <li><a href="#"><img src="./images/gallery3.jpg" alt="갤러리3"></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="link_container">
           		 <h4>랭킹</h4>
                <ul>
                    <li><a href="#">1위: </a></li>
                    <li><a href="#">2위 </a></li>
                    <li><a href="#">3위 </a></li>
                    <li><a href="#">4위 </a></li>
                </ul>
            </div>
        </section>
<%@ include file="footer.jsp" %>