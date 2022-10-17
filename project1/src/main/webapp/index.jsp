<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 
    
    JSP 액션 태그  중 forward 
    -Servlet 에서 JSP(얘도 Servlet임...)로 요청 위임할 때 썼던 거야.
    즉. Servlet에서 Servlet으로 요청 위임...
    JSP 위임 시 JSP 파일 경로

    어차피 둘 다 Servlet이니까 반대도 가능함. 
    JSP에서 Servlet으로 요청 위임 가능
    Servlet 위임 시에는 요청 주소를 작성해야 한다.

--%>

<jsp:forward page = "main" />
<%-- 메인 페이지(index.jsp) 요청이 왔을 때
    요청 주소가 /main인 servlet으로 요청을 위임
    -> Servlet == Back-End -> DB 연결 가능
    -> 다시 JSP 위임 가능
--%>