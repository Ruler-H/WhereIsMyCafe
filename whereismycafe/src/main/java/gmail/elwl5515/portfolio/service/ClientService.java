package gmail.elwl5515.portfolio.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ClientService {
	//회원가입을 처리하는 메소드
	public Map<String, Object> join(MultipartHttpServletRequest request, HttpServletResponse response);
	
	//로그인을 처리하는 메소드
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response);
	
	//회원 정보 갱신을 처리하는 메소드
	public Map<String, Object> update(MultipartHttpServletRequest request, HttpServletResponse response);
}
