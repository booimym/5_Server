package edu.kh.suvlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller : 요청에 따라 응답할 코드를 제어한다.

// Servlet  클래스를 만들기 위해서는
// javax.servlet.http.HttpServlet 추상클래스를 반드시 상속받아야 한다.
// (추상클래스: 직접 객체 생성 불가)
// - 요청, 응답을 위한 방법(메서드) 제공
// - tomcat에서 제공하는 클래스


@WebServlet("/login")
public class ServletEx1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// HttpServletRequest : 클라이언트의 정보 + 요청 관련 정보가 담긴 객체
		
		// HttpServletResponse : 서버가 클라이언트에게 응답하는 방법을 제공하는 객체
		
		System.out.println("이름,나이를 제출 받아서 처리할 코드 수행");
		
		// 요청 시 함께 전달된 input 태그의 값(파라미터)을 얻어오는 방법
		
		// req.getParameter("input 태그의 name 속성 값");
		// -> String 형태로 입력된 값 반환
		// ** 얻어온 파라미터는 무조건 String **
		
		String inputName = req.getParameter("inputName");
		String inputAge = req.getParameter("inputAge");
		
		System.out.println(inputName +" / " + inputAge );
		
		// resp.getWriter() : 서버가 클라이언트에게 응답할 수 있는 스트림을 얻어옴.
		// -> PrintWriter : 출력 전용 스트림
		
		//resp.setCharacterEncoding("UTF-8"); -> 사용하면 안됨!!!!
		
		//문서 형식과 문자 인코딩을 지정함
		//-> html 문서이고 문자는 UTF-8형식으로 인코딩 되어있다.
		// --> 브라우저에 해당 내용에 맞게 해석
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		out.println(inputName + "님의 나이는 " + inputAge + "세 입니다.");
	}

}
