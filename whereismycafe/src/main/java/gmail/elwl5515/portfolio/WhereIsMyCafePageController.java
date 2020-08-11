package gmail.elwl5515.portfolio;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//웹 페이지 이동에만 사용되는 컨트롤러
@Controller
public class WhereIsMyCafePageController {
	//client의 join 페이지 이동을 위한 메소드
	@RequestMapping(value = "client/join", method = RequestMethod.GET)
	public String join() {
		System.out.println("PageController join 메소드 호출 확인");
		return "client/join";
	}
	
	//client의 login 페이지 이동을 위한 메소드
	@RequestMapping(value = "client/login", method = RequestMethod.GET)
	public String login() {
		return "client/login";
	}
	
	//client의 logout 처리를 위한 메소드
	@RequestMapping(value = "client/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}
	
	//client의 회원정보 수정 처리를 위한 메소드
	@RequestMapping(value="client/update", method = RequestMethod.GET)
	public String update() {
		return "client/update";
	}
}
