package gmail.elwl5515.portfolio.service;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface CafeMainService {
	//회원가입을 처리하는 메소드
	public Map<String, Object> join(MultipartHttpServletRequest request, HttpServletResponse response);
}
