<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 결과</title>
</head>
<body>
    <%--* 비밀번호와 비번확인이 일치하지 않는 경우 
        -> 비밀번호가 일치하지 않습니다.

        * 비밀번호와 비번확인이 일치하는 경우
        ->

            아이디 : user01
            비밀번호 : pass01
            이름 : 유저일
            이메일 : user01@gmail.com
            취미 : 게임 영화 코딩

            유저일의 회원가입이 완료되었습니다!

     --%>

     <%
        // 스크립틀릿(자바 코드 작성 영역)
        String id = request.getParameter("memberId");
        String[] pw = request.getParameterValues("memberPw");
        String name = request.getParameter("memberName");
        String email = request.getParameter("memberEmail");
        String[] hobby = request.getParameterValues("hobby");
     %>

	<!-- 비밀번호 불일치 -->
    <% if (!pw[0].equals(pw[1])) { %>
    	<h3>비밀번호가 일치하지 않습니다.</h3>
    <% } else{%>
    
    <ul>
    	
    		<li>아이디 : <%= id %></li>
    		<li>비번 : <%= pw[0] %></li>
    		<li>이름 : <%= name %></li>
    		<li>이메일 : <%= email %></li>
    		<li>
    			취미: 

                <% for(String s : hobby ){%>
                 <%= s %> 

                <% }%>    
    		</li>
    </ul>
 
    <h3><%= name%>의 회원가입이 완료되었습니다.</h3>
    <% }%>    
</body>
</html>