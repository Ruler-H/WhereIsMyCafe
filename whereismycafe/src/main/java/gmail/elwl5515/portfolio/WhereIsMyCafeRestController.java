package gmail.elwl5515.portfolio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gmail.elwl5515.portfolio.service.CafeClientService;
import gmail.elwl5515.portfolio.service.CafeCommentService;
import gmail.elwl5515.portfolio.service.CafeMainService;
import gmail.elwl5515.portfolio.service.CafeOperationHoursService;
import gmail.elwl5515.portfolio.service.CafeReviewSNSService;
import gmail.elwl5515.portfolio.service.CafeSubService;
import gmail.elwl5515.portfolio.service.ClientPreferenceElementService;
import gmail.elwl5515.portfolio.service.ClientService;
import gmail.elwl5515.portfolio.service.CouponService;
import gmail.elwl5515.portfolio.service.DesertService;
import gmail.elwl5515.portfolio.service.DrinkService;
import gmail.elwl5515.portfolio.domain.CafeMain;

//데이터를 제공하기 위한 Controller
@RestController
public class WhereIsMyCafeRestController {
	
	@Autowired
	private CafeClientService cafeClientService;
	@Autowired
	private CafeCommentService cafeCommentService;
	@Autowired
	private CafeMainService cafeMainService;
	@Autowired
	private CafeOperationHoursService cafeOperationHoursService;
	@Autowired
	private CafeReviewSNSService cafeReviewSnsService;
	@Autowired
	private CafeSubService cafeSubService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientPreferenceElementService clientPreferenceElementService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private DesertService desertService;
	@Autowired
	private DrinkService drinkService;
	
	//회원가입을 처리하는 메소드
	@RequestMapping(value = "client/join", method = RequestMethod.POST)
	public Map<String, Object> clientJoin(MultipartHttpServletRequest request, HttpServletResponse response){
		//서비스의 회원가입 메소드 호출
		System.out.println("RestController join 메소드 호출 확인");
		Map<String, Object> map = clientService.join(request, response);
		return map;
	}
	
	//로그인을 처리하는 메소드
	@RequestMapping(value = "client/login", method = RequestMethod.POST)
	public Map<String, Object> clientLogin(HttpServletRequest request, HttpServletResponse response){
		//서비스의 로그인 메소드 호출
		Map<String, Object> result = clientService.login(request, response);
		System.out.println(result);
		return result;
	}
	
	//회원 정보 갱신을 처리하는 메소드
	@RequestMapping(value = "client/update", method = RequestMethod.POST)
	public Map<String, Object> clientUpdate(MultipartHttpServletRequest request, HttpServletResponse response){
		//서비스의 회원 정보 갱신 메소드 호출
		Map<String, Object> result = clientService.update(request, response);
		return result;
	}
	
	//카페 회원가입을 처리하는 메소드
	@RequestMapping(value = "cafe/join", method = RequestMethod.POST)
	public Map<String, Object> cafeJoin(MultipartHttpServletRequest request, HttpServletResponse response){
		//카페 서비스의 회원가입 메소드 호출
		System.out.println("RestController cafe join 메소드 호출 확인");
		Map<String, Object> map = cafeMainService.join(request, response);
		return map;
	}
	
	//카페 로그인을 처리하는 메소드
	@RequestMapping(value = "cafe/login", method = RequestMethod.POST)
	public Map<String, Object> cafeLogin(HttpServletRequest request, HttpServletResponse response){
		//서비스의 로그인 메소드 호출
		Map<String, Object> result = cafeMainService.login(request, response);
		return result;
	}
	
	//카페 정보 갱신을 처리하는 메소드
	@RequestMapping(value = "cafe/update", method = RequestMethod.POST)
	public Map<String, Object> cafeUpdate(MultipartHttpServletRequest request, HttpServletResponse response){
		//서비스의 카페 정보 갱신 메소드 호출
		Map<String, Object> result = cafeMainService.update(request, response);
		return result;
	}

}
