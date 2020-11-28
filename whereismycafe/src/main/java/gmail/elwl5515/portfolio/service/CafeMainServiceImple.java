package gmail.elwl5515.portfolio.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gmail.elwl5515.portfolio.dao.CafeImageDAO;
import gmail.elwl5515.portfolio.dao.CafeMainDAO;
import gmail.elwl5515.portfolio.dao.CafeSubDAO;
import gmail.elwl5515.portfolio.domain.CafeImage;
import gmail.elwl5515.portfolio.domain.CafeMain;
import gmail.elwl5515.portfolio.domain.CafeSub;
import gmail.elwl5515.portfolio.util.CryptoUtil;

@Service
public class CafeMainServiceImple implements CafeMainService {
	@Autowired
	private CafeMainDAO cafeMainDao;
	@Autowired
	private CafeSubDAO cafeSubDao;
	@Autowired
	private CafeImageDAO cafeImageDao;

	@Override
	@Transactional
	public Map<String, Object> join(MultipartHttpServletRequest request, HttpServletResponse response) {
		System.out.println("CafeMainService join 메소드 호출 1");
		//결과를 저장할 객체
		Map<String, Object> map = new HashMap<String, Object>();
		//성공과 실패 여부를 확인할 데이터
		map.put("result", false);
		//실패했을 때 닉네임 때문에 실패한지 여부를 저장하기 위한 데이터
		map.put("nicknamecheck", false);
		//파라미터 읽기
		String cafeAddress = request.getParameter("cafeAddress");
		String cafeName = request.getParameter("cafeName");
		String cafeNickname = request.getParameter("cafeNickname");
		String cafePassword = request.getParameter("cafePassword");
		String cafePhoneNum = request.getParameter("cafePhoneNum");
		int cafeTableNum = Integer.parseInt(request.getParameter("cafeTableNum"));
		int outdoorTableNum = Integer.parseInt(request.getParameter("outdoorTableNum"));
		int concentTableNum = Integer.parseInt(request.getParameter("concentTableNum"));
		String cafeHomepage = request.getParameter("cafeHomepage");
		String cafeSNS = request.getParameter("cafeSNS");
		String cafeCommentary = request.getParameter("cafeCommentary");
		MultipartFile cafeLogo = request.getFile("cafeLogo");
		List<MultipartFile> imageList = request.getFiles("cafeImage");
		String cafeParking = request.getParameter("cafeParking");
		String cafeRefill = request.getParameter("cafeRefill");
		String cafeCoupon = request.getParameter("cafeCoupon");
		String noKidsZone = request.getParameter("noKidsZone");
		String sirenOrder = request.getParameter("sirenOrder");
		String tumblerDiscount = request.getParameter("tumblerDiscount");
		String cafeWifi = request.getParameter("cafeWifi");
		
		//데이터베이스 구조에 맞추어 데이터 값 변경 체크하지 않은 경우 0 체크한 경우 1
		if(cafeParking == null) {
			cafeParking = "0";
		}else {
			cafeParking = "1";
		}
		
		if(cafeRefill == null) {
			cafeRefill = "0";
		}else {
			cafeRefill = "1";
		}
		
		if(cafeCoupon == null) {
			cafeCoupon = "0";
		}else {
			cafeCoupon = "1";
		}
		
		if(noKidsZone == null) {
			noKidsZone = "0";
		}else {
			noKidsZone = "1";
		}
		
		if(sirenOrder == null) {
			sirenOrder = "0";
		}else {
			sirenOrder = "1";
		}
		
		if(tumblerDiscount == null) {
			tumblerDiscount = "0";
		}else {
			tumblerDiscount = "1";
		}
		
		if(cafeWifi == null) {
			cafeWifi = "0";
		}else {
			cafeWifi = "1";
		}
		System.out.println("CafeMainService join 메소드 호출 2");
		//닉네임 중복 검사 수행
		String nicknameCheckResult = cafeMainDao.cafeNicknameCheck(cafeNickname);
		if(nicknameCheckResult == null) {
			//닉네임 중복 검사 결과 저장 - 통과
			map.put("nicknamecheck", true);
			//카페 로고 파일의 기본 이름 설정
			String logo = "default.jpg";
			//파일을 선택한 경우에만 파일을 서버에 복사
			if(!cafeLogo.isEmpty()) {
				//저장할 디렉토리 경로 생성
				String uploadPath = request.getServletContext().getRealPath("cafe/logo");
				//저장할 파일 이름을 랜덤하게 설정
				logo = UUID.randomUUID() + cafeLogo.getOriginalFilename();
				uploadPath = uploadPath + "/" + logo;
				FileOutputStream fos = null;
				try {
					//파일 객체 생성
					File file = new File(uploadPath);
					fos = new FileOutputStream(file);
				}catch(Exception e) {
					System.err.println("파일 객체 생성 실패 : " + e.getMessage());
					e.printStackTrace();
				}
				try {
					fos.write(cafeLogo.getBytes());
				}catch(Exception e) {
					System.err.println("파일 서버 전송 실패 : " + e.getMessage());
					e.printStackTrace();
				}
			}
			
			//공개키 암호화에 사용할 키 생성
			String key = "elwl5515";
			try {
				System.out.println("CafeMainService join 메소드 호출 3");
				cafeNickname = CryptoUtil.encryptAES256(cafeNickname, key);
			}catch(Exception e) {
				System.err.println("카페 닉네임 암호화 실패 : " + e.getMessage());
				e.printStackTrace();
			}
			
			//카페 이미지 파일의 기본 이름 설정
			String imageName = "default.jpg";
			Boolean flag = true;
			for(MultipartFile image : imageList) {
				System.out.println("CafeMainService join 메소드 호출 4");
				//저장할 디렉토리 경로 생성
				String uploadPath = request.getServletContext().getRealPath("cafe/logo");
				//저장할 파일 이름을 랜덤하게 설정
				imageName = UUID.randomUUID() + image.getOriginalFilename();
				uploadPath = uploadPath + "/" + imageName;
				FileOutputStream fos = null;
				try {
					//파일 객체 생성
					File file = new File(uploadPath);
					fos = new FileOutputStream(file);
				}catch(Exception e) {
					System.err.println("파일 객체 생성 실패 : " + e.getMessage());
					e.printStackTrace();
				}
				try {
					fos.write(image.getBytes());
				}catch(Exception e) {
					System.err.println("파일 서버 전송 실패 : " + e.getMessage());
					e.printStackTrace();
				}
				try {
					//카페 이미지 데이터베이스에 전송할 객체 생성 및 데이터 저장
					CafeImage cafeImageDto = new CafeImage();
					cafeImageDto.setCafeImage(imageName);
					cafeImageDto.setCafeNickname(cafeNickname);
					//카페 이미지 DAO의 join메소드 호출
					int row1 = cafeImageDao.join(cafeImageDto);
					if(row1 < 1) {
						flag = false;
					}
				}catch(Exception e) {
					System.err.println("이미지 데이터베이스 저장 실패 : " + e.getMessage());
					e.printStackTrace();
				}
			}
			
			//카페 메인, 서브 데이터베이스에 전송할 객체 생성 및 데이터 저장
			CafeMain cafeMain = new CafeMain();
			CafeSub cafeSub = new CafeSub();
			try {
				System.out.println("CafeMainService join 메소드 호출 5");
				//암호화해둔 nickname은 바로 저장하고 password는 암호화해서 저장, 나머지 데이터는 바로 저장
				cafeMain.setCafeNickname(cafeNickname);
				cafeMain.setCafeName(cafeName);
				cafeMain.setCafeAddress(cafeAddress);
				cafeMain.setCafeWifi(cafeWifi);
				cafeMain.setCafeParking(cafeParking);
				cafeMain.setCafeRefill(cafeRefill);
				cafeMain.setCafeTableNum(cafeTableNum);
				cafeMain.setConcentTableNum(concentTableNum);
				cafeMain.setCafeLogo(logo);
				cafeMain.setCafePhoneNum(cafePhoneNum);
				cafeMain.setCafeCommentary(cafeCommentary);
				cafeMain.setCafePassword(BCrypt.hashpw(cafePassword, BCrypt.gensalt()));
				cafeSub.setCafeNickname(cafeNickname);
				cafeSub.setTumblerDiscount(tumblerDiscount);
				cafeSub.setNoKidsZone(noKidsZone);
				cafeSub.setCafeHomepage(cafeHomepage);
				cafeSub.setSirenOrder(sirenOrder);
				cafeSub.setCafeCoupon(cafeCoupon);
				cafeSub.setOutdoorTableNum(outdoorTableNum);
				cafeSub.setCafeSNS(cafeSNS);
				System.out.println(cafeCommentary);
				
				//데이터베이스에 저장
				int row2 = cafeMainDao.join(cafeMain);
				int row3 = cafeSubDao.join(cafeSub);
				if(row2 < 1 || row3 < 1) {
					flag = false;
				}
				
				//각 데이터베이스로 데이터 저장에 성공하면 map의 result에 true를 저장
				if(flag = true) {
					System.out.println("CafeMainService join 메소드 호출 6");
					map.put("result", true);
				}
			}catch(Exception e) {
				System.err.println("데이터베이스 데이터 삽입 실패 : " + e.getMessage());
				e.printStackTrace();
			}
		}
		return map;
	}

	// cafe 로그인 처리를 위한 메소드
	@Transactional
	@Override
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("cafe serviceImpl login 메소드 호출 확인 : 1");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("reuslt", false);
		String cafeNickname = request.getParameter("cafeNickname");
		String cafePassword = request.getParameter("cafePassword");
		
		List<CafeMain> cafeMainList = cafeMainDao.login();
		List<CafeSub> cafeSubList = cafeSubDao.login();
		List<CafeImage> cafeImageList = cafeImageDao.login();
		System.out.println("cafe serviceImpl login 메소드 호출 확인 : 2");

		String key = "elwl5515";
		try {
			for(CafeMain cafeMain : cafeMainList) {
				if(CryptoUtil.decryptAES256(cafeMain.getCafeNickname().trim(), key).equals(cafeNickname) &&
				BCrypt.checkpw(cafePassword, cafeMain.getCafePassword())){
					result.put("result", true);
					result.put("cafeNickname", cafeNickname);
					result.put("cafePassword", cafePassword);
					result.put("cafeName", cafeMain.getCafeName());
					result.put("cafeAddress", cafeMain.getCafeAddress());
					result.put("signatureDrink", cafeMain.getSignatureDrink());
					result.put("signatureDesert", cafeMain.getSignatureDesert());
					result.put("cafeWifi", cafeMain.getCafeWifi());
					result.put("cafeTableNum", cafeMain.getCafeTableNum());
					result.put("concentTableNum", cafeMain.getConcentTableNum());
					result.put("cafeLogo", cafeMain.getCafeLogo());
					result.put("cafePhoneNum", cafeMain.getCafePhoneNum());
					result.put("cafeCommentary", cafeMain.getCafeCommentary());
				}
			}
			for(CafeSub cafeSub : cafeSubList) {
				if((boolean)result.get("result")) {
					result.put("tumblerDiscount", cafeSub.getTumblerDiscount());
					result.put("noKidsZone", cafeSub.getNoKidsZone());
					result.put("cafeHomepage", cafeSub.getCafeHomepage());
					result.put("sirenOrder", cafeSub.getSirenOrder());
					result.put("cafeCoupon", cafeSub.getCafeCoupon());
					result.put("outdoorTableNum", cafeSub.getOutdoorTableNum());
					result.put("cafeSNS", cafeSub.getCafeSNS());
					result.put("toiletGrade", cafeSub.getToiletGrade());
				}
			}
			for(CafeImage cafeImage : cafeImageList) {
				if((boolean)result.get("result")) {
					result.put("cafeImageNum", cafeImage.getCafeImageNum());
					result.put("cafeImage", cafeImage.getCafeImage());
				}
			}
		}catch(Exception e) {
			System.err.println("로그인 처리 실패 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(result);
		request.getSession().setAttribute("cafeinfo", result);
		return result;
	}

	//cafe 정보 수정을 위한 메소드
	@Override
	@Transactional
	public Map<String, Object> update(MultipartHttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		//파라미터 읽기
		String cafeAddress = request.getParameter("cafeAddress");
		String cafeName = request.getParameter("cafeName");
		String cafeNickname = request.getParameter("cafeNickname");
		String cafePassword = request.getParameter("cafePassword");
		String cafePhoneNum = request.getParameter("cafePhoneNum");
		int cafeTableNum = Integer.parseInt(request.getParameter("cafeTableNum"));
		int outdoorTableNum = Integer.parseInt(request.getParameter("outdoorTableNum"));
		int concentTableNum = Integer.parseInt(request.getParameter("concentTableNum"));
		String cafeHomepage = request.getParameter("cafeHomepage");
		String cafeSNS = request.getParameter("cafeSNS");
		String cafeCommentary = request.getParameter("cafeCommentary");
		MultipartFile cafeLogo = request.getFile("cafeLogo");
		List<MultipartFile> imageList = request.getFiles("cafeImage");
		String cafeParking = request.getParameter("cafeParking");
		String cafeRefill = request.getParameter("cafeRefill");
		String cafeCoupon = request.getParameter("cafeCoupon");
		String noKidsZone = request.getParameter("noKidsZone");
		String sirenOrder = request.getParameter("sirenOrder");
		String tumblerDiscount = request.getParameter("tumblerDiscount");
		String cafeWifi = request.getParameter("cafeWifi");
		String oldCafeLogo = request.getParameter("oldCafeLogo");
		
		//데이터베이스 구조에 맞추어 데이터 값 변경 체크하지 않은 경우 0 체크한 경우 1
		if(cafeParking == null) {
			cafeParking = "0";
		}else {
			cafeParking = "1";
		}
		
		if(cafeRefill == null) {
			cafeRefill = "0";
		}else {
			cafeRefill = "1";
		}
		
		if(cafeCoupon == null) {
			cafeCoupon = "0";
		}else {
			cafeCoupon = "1";
		}
		
		if(noKidsZone == null) {
			noKidsZone = "0";
		}else {
			noKidsZone = "1";
		}
			
		if(sirenOrder == null) {
			sirenOrder = "0";
		}else {
			sirenOrder = "1";
		}
		
		if(tumblerDiscount == null) {
			tumblerDiscount = "0";
		}else {
			tumblerDiscount = "1";
		}
		
		if(cafeWifi == null) {
			cafeWifi = "0";
		}else {
			cafeWifi = "1";
		}
		
		String logo_image = null;
		//저장할 디렉토리 경로 생성
		String logo_uploadPath = request.getServletContext().getRealPath("cafe/logo");
		if(cafeLogo.isEmpty() == true) {
			//이전 이미지 파일 이름으로 설정
			logo_image = oldCafeLogo;
		}else {
			//업로드한 파일 이름 랜덤하게 설정
			logo_image = UUID.randomUUID() + cafeLogo.getOriginalFilename();
		}
		//저장할 떄 사용할 전체 경로 생성
		logo_uploadPath = logo_uploadPath + "/" + logo_image;
		//파일 객체 생성
		File logo_file = new File(logo_uploadPath);
		FileOutputStream logo_fos = null;
		//파일 전송 요청
		try {
			logo_fos = new FileOutputStream(logo_file);
			logo_fos.write(cafeLogo.getBytes());
		}catch(Exception e) {
			System.out.println("로고 이미지 전송 실패 : " + e.getMessage());
			e.printStackTrace();
		}
		
		//카페 이미지 파일의 기본 이름 설정
		String imageName = "default.jpg";
		//여러 데이터베이스 접근 시 데이터베이스 접근이 실패했을 때를 확인할 flag
		Boolean flag = true;
		if(imageList.isEmpty() == true) {
			
		}else {
			for(MultipartFile image : imageList) {
				//저장할 디렉토리 경로 생성
				String uploadPath = request.getServletContext().getRealPath("cafe/logo");
				//저장할 파일 이름을 랜덤하게 설정
				imageName = UUID.randomUUID() + image.getOriginalFilename();
				uploadPath = uploadPath + "/" + imageName;
				FileOutputStream fos = null;
				try {
					//파일 객체 생성
					File file = new File(uploadPath);
					fos = new FileOutputStream(file);
				}catch(Exception e) {
					System.err.println("파일 객체 생성 실패 : " + e.getMessage());
					e.printStackTrace();
				}
				try {
					fos.write(image.getBytes());
				}catch(Exception e) {
					System.err.println("파일 서버 전송 실패 : " + e.getMessage());
					e.printStackTrace();
				}
				try {
					//카페 이미지 데이터베이스에 전송할 객체 생성 및 데이터 저장
					CafeImage cafeImageDto = new CafeImage();
					cafeImageDto.setCafeImage(imageName);
					cafeImageDto.setCafeNickname(cafeNickname);
					//카페 이미지 DAO의 join메소드 호출
					int row1 = cafeImageDao.update(cafeImageDto);
					if(row1 < 1) {
						flag = false;
					}
				}catch(Exception e) {
					System.err.println("이미지 데이터베이스 저장 실패 : " + e.getMessage());
					e.printStackTrace();
				}
			}
		}
		//카페 메인, 서브 데이터베이스에 전송할 객체 생성 및 데이터 저장
		CafeMain cafeMain = new CafeMain();
		CafeSub cafeSub = new CafeSub();
		try {
			//암호화해둔 nickname은 바로 저장하고 password는 암호화해서 저장, 나머지 데이터는 바로 저장
			cafeMain.setCafeNickname(cafeNickname);
			cafeMain.setCafeName(cafeName);
			cafeMain.setCafeAddress(cafeAddress);
			cafeMain.setCafeWifi(cafeWifi);
			cafeMain.setCafeParking(cafeParking);
			cafeMain.setCafeRefill(cafeRefill);
			cafeMain.setCafeTableNum(cafeTableNum);
			cafeMain.setConcentTableNum(concentTableNum);
			cafeMain.setCafeLogo(logo_image);
			cafeMain.setCafePhoneNum(cafePhoneNum);
			cafeMain.setCafeCommentary(cafeCommentary);
			cafeMain.setCafePassword(BCrypt.hashpw(cafePassword, BCrypt.gensalt()));
			cafeSub.setCafeNickname(cafeNickname);
			cafeSub.setTumblerDiscount(tumblerDiscount);
			cafeSub.setNoKidsZone(noKidsZone);
			cafeSub.setCafeHomepage(cafeHomepage);
			cafeSub.setSirenOrder(sirenOrder);
			cafeSub.setCafeCoupon(cafeCoupon);
			cafeSub.setOutdoorTableNum(outdoorTableNum);
			cafeSub.setCafeSNS(cafeSNS);
			
			//데이터베이스에 반영
			int row2 = cafeMainDao.update(cafeMain);
			int row3 = cafeSubDao.update(cafeSub);
			if(row2 < 1 || row3 < 1) {
				flag = false;
			}
			
			//각 데이터베이스로 데이터 저장에 성공하면 map의 result에 true를 저장
			if(flag = true) {
				map.put("result", true);
			}
		}catch(Exception e) {
			System.err.println("데이터베이스 데이터 삽입 실패 : " + e.getMessage());
			e.printStackTrace();
		}
		return map;
	}
}