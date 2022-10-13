package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.model.vo.Person;

@WebServlet("/elTest")
public class ELTestServlet extends HttpServlet{

	//** 데이터 전달 방식에 따라서
	//  하나의 요청 주소로 여러가지 처리가 가능하다!!
	
	
	//<a>태그로 요청해서 Get방식...
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//바로 그냥 JSP에 위임하는 코드
		RequestDispatcher dispatcher 
			= req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		
		// WEB-INF 폴더는
		// 외부 요청을 통해서 접근 불가
		// 단, 내부 접근(Servlet, JSP에서의 직접 접근)은 가능함.
		
		//위임...
		dispatcher.forward(req, resp);
			
	}
	
	//form 태그 요청(POST)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Post방식으로 하면 글자 깨지니까 (요청 데이터 문자 인코딩 지정)
		req.setCharacterEncoding("UTF-8");
		
//		System.out.println(req.getParameter("inputName"));
//		System.out.println(req.getParameter("inputAge"));
//		System.out.println(req.getParameter("inputAddress"));
		
		//파라미터 얻어오기
		String name = req.getParameter("inputName");
		int age = Integer.parseInt(req.getParameter("inputAge"));
		String address = req.getParameter("inputAddress");
		
		String message = name + "님은 " + age + "세이고 " + address +
				"에 거주 중입니다.";
		
		
		//person객체를 생성하기
		Person p = new Person();
		
		p.setName(name + "님");
		p.setAge(age + 10000);
		p.setAddress("대한민국 " + address);
		
		//요청 발송자 생성하기!
		RequestDispatcher dispatcher
		=req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp");//webapp 폴더를 기준으로 jsp 파일 경로를 작성한다.
		
		//message랑 person을 전달할거임...
		//요청 위임 시 추가할 값을 세팅!
		
		req.setAttribute("message", message); 
		req.setAttribute("person", p);
		
		List<String> list2 = null; //null
		List<String> list3 = new ArrayList<>(); //비어 있는 리스트
		List<String> list4 = new ArrayList<>(); //값이 있는 리스트
		list4.add("테스트");
		
		req.setAttribute("list2", list2);
		req.setAttribute("list3", list3);
		req.setAttribute("list4", list4);
		
		
		
		//JSP로 요청을 위임하기!
		dispatcher.forward(req, resp);
	}
}
