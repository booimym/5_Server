package edu.kh.project.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.project.member.model.service.MemberService;
import edu.kh.project.member.model.vo.Member;

@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/member/myPage-info.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//인코딩 필터 때문에 문자인코딩 따로 안 해도 됨......!
		
		//파라미터 얻어오기
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		
		String[] arr = req.getParameterValues("memberAddress");
		
		String memberAddress = null;
		if(!arr[0].equals("") && !arr[1].equals("") ) {
			memberAddress = String.join(",,",arr);
		}
		
		//**로그인한 회원의 정보 얻어오기 **
		
		HttpSession session = req.getSession();
		
		
		//세션에 저장된 로그인 Member 객체의 참조 주소를 복사
		// == 얕은 복사
		Member loginMember = (Member)session.getAttribute("loginMember");
							//다운캐스팅 해줘야대
		
		int memberNo = loginMember.getMemberNo();
		
		//멤버객체를 생성해서, update sql에 필요한 값을 세팅하겠다!!!
		Member member = new Member();
		
		member.setMemberNo(memberNo);
		member.setMemberNickname(memberNickname);
		member.setMemberTel(memberTel);
		member.setMemberAddress(memberAddress);
		
		//jdbc
		try {
			
						//서비스 객체를 생성해봤자 한번밖에 사용 안하기 때문에
						//객체를 1회성으로 사용....
			int result = new MemberService().updateMember(member); 
			
			String message = null; //
			if (result > 0) { // 성공
				message = "회원정보가 수정되었습니다.";
				//DB 데이터 수정 성공 시
				//Session에 담긴 로그인 회원 정보도 같이 수정해야한다!!!!
				//(데이터 동기화)
				
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
				
				
				
			} else { //실패
				message = "회원정보 수정 실패.... ㅠ ";
			}
			
			session.setAttribute("message", message);
			
			//성공, 실패 상관없이 내정보 페이지 재요청을 하겠다...!
			resp.sendRedirect("/member/myPage/info");
			
		}catch(Exception e) {
			e.printStackTrace();
			
			//req.resp는 controller벗어나는 걸 권장하지 않기 때문에
			//직접 매번 복사해서 씀......
			String errorMessage = "회원 정보 수정 중 문제가 발생했습니다.";
			
			req.setAttribute("errorMessage", errorMessage);
			req.setAttribute("e", e); //e : 예외객체임.
			
			String path = "/WEB-INF/views/common/error.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
		}
		
	}
}
