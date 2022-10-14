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

@WebServlet("/forEach")
public class ForEachServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Person> pList = new ArrayList<>();
		pList.add(new Person("가길동",25,"서울시 마포구"));
		pList.add(new Person("나길동",26,"서울시 서대문구"));
		pList.add(new Person("다길동",27,"서울시 중구"));
		pList.add(new Person("라길동",28,"서울시 종로구"));
		pList.add(new Person("마길동",29,"서울시 성북구"));
		pList.add(new Person("바길동",30,"서울시 광진구"));
		
		req.setAttribute("pList", pList); //request에 값을 세팅한당!
		
		
		//바로 요청 위임할거임
		RequestDispatcher dispatcher 
			= req.getRequestDispatcher("WEB-INF/views/forEach.jsp");
		
		dispatcher.forward(req, resp);
			
		
		
		
	}

}
