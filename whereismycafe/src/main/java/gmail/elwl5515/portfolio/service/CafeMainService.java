package gmail.elwl5515.portfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import gmail.elwl5515.portfolio.domain.CafeMain;

public interface CafeMainService {
	//회원가입을 처리하는 메소드
	public Map<String, Object> join(MultipartHttpServletRequest request, HttpServletResponse response);
	
	//로그인을 처리하는 메소드
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response);
	
	//정보 수정을 처리하는 메소드
	public Map<String, Object> update(MultipartHttpServletRequest request, HttpServletResponse response);
	
	//카페리스트를 반환할 메소드
	public List<CafeMain> list() throws Exception;
}
