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

import gmail.elwl5515.portfolio.dao.ClientDAO;
import gmail.elwl5515.portfolio.dao.ClientPreferenceElementDAO;
import gmail.elwl5515.portfolio.domain.Client;
import gmail.elwl5515.portfolio.domain.ClientPreferenceElement;
import gmail.elwl5515.portfolio.util.CryptoUtil;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientDAO clientDao;
	@Autowired
	private ClientPreferenceElementDAO clientPreferenceElementDao;

	// 회원가입을 처리할 메소드
	@Transactional
	@Override
	public Map<String, Object> join(MultipartHttpServletRequest request, HttpServletResponse response) {
		System.out.println("ClientServiceImpl join 메소드 호출 확인 : 1");
		// 결과 저장할 객체
		Map<String, Object> map = new HashMap<String, Object>();
		// 성공과 실패 여부를 확인할 데이터
		map.put("result", false);
		// 실패했을 때 실패 이유를 저장하기 위한 데이터
		map.put("nicknamecheck", false);
		// 파라미터 읽기
		String clientAddress = request.getParameter("clientAddress");
		int clientAge = Integer.parseInt(request.getParameter("clientAge"));
		String clientEmail = request.getParameter("clientEmail");
		String clientName = request.getParameter("clientName");
		String clientNickname = request.getParameter("clientNickname");
		String clientPassword = request.getParameter("clientPassword");
		String clientPhoneNum = request.getParameter("clientPhoneNum");
		MultipartFile clientProfileImage = request.getFile("clientProfileImage");
		String preferConcent = request.getParameter("preferConcent");
		String preferNoKidsZone = request.getParameter("preferNoKidsZone");
		String preferParking = request.getParameter("preferParking");
		String preferPat = request.getParameter("preferPat");
		String preferRefill = request.getParameter("preferRefill");
		String preferWifi = request.getParameter("preferWifi");

		System.out.println("ClientServiceImpl join 메소드 호출 확인 : 2");

		// 데이터베이스 구조에 맞추어 데이터 값 변경 체크하지 않은 경우 0 체크한 경우 1
		if (preferConcent == null) {
			preferConcent = "0";
		} else {
			preferConcent = "1";
		}
		if (preferNoKidsZone == null) {
			preferNoKidsZone = "0";
		} else {
			preferNoKidsZone = "1";
		}
		if (preferParking == null) {
			preferParking = "0";
		} else {
			preferParking = "1";
		}
		if (preferPat == null) {
			preferPat = "0";
		} else {
			preferPat = "1";
		}
		if (preferRefill == null) {
			preferRefill = "0";
		} else {
			preferRefill = "1";
		}
		if (preferWifi == null) {
			preferWifi = "0";
		} else {
			preferWifi = "1";
		}

		// 닉네임 중복 검사 수행
		String nicknameCheckResult = clientDao.clientNicknameCheck(clientNickname);
		if (nicknameCheckResult == null) {
			System.out.println("ClientServiceImpl join 메소드 호출 확인 : 3");
			map.put("nicknamecheck", true);
		}

		// nickname 중복 검사를 통과한 경우에만 데이터 삽입
		if (nicknameCheckResult == null) {
			System.out.println("ClientServiceImpl join 메소드 호출 확인 : 4");
			// 프로필 파일의 기본 이름 설정
			String image = "default.jpg";
			// 파일을 선택한 경우에만 파일을 서버에 복사
			if (clientProfileImage.isEmpty() == false) {
				// 저장할 디렉토리 경로 생성
				String uploadPath = request.getServletContext().getRealPath("client/profile");
				// 파일 이름을 랜덤하게 설정
				image = UUID.randomUUID() + clientProfileImage.getOriginalFilename();
				uploadPath = uploadPath + "/" + image;
				System.out.println(uploadPath);
				// 파일 객체 생성
				File file = new File(uploadPath);
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(file);
				}catch(Exception e) {
					System.err.println("FileNotFoundException : " + e.getMessage());
					e.printStackTrace();
				}
				try {
					fos.write(clientProfileImage.getBytes());
				} catch (Exception e) {
					System.err.println("파일 서버 전송 실패 : " + e.getMessage());
					e.printStackTrace();
				}
			}
			// 공개키 암호화에 사용할 키 생성
			String key = "elwl5515";
			Client client = new Client();
			ClientPreferenceElement clientPreferenceElement = new ClientPreferenceElement();
			try {
				// nickname 및 password는 암호화해서 저장하고 나머지 데이터는 바로 저장
				client.setClientAddress(clientAddress);
				client.setClientAge(clientAge);
				client.setClientEmail(CryptoUtil.encryptAES256(clientEmail, key));
				client.setClientName(clientName);
				client.setClientNickname(clientNickname);
				client.setClientPassword(BCrypt.hashpw(clientPassword, BCrypt.gensalt()));
				client.setClientPhoneNum(clientPhoneNum);
				client.setClientProfileImage(image);
				clientPreferenceElement.setClientNickname(clientNickname);
				clientPreferenceElement.setPreferConcent(preferConcent);
				clientPreferenceElement.setPreferNoKidsZone(preferNoKidsZone);
				clientPreferenceElement.setPreferParking(preferParking);
				clientPreferenceElement.setPreferPat(preferPat);
				clientPreferenceElement.setPreferRefill(preferRefill);
				clientPreferenceElement.setPreferWifi(preferWifi);

				// 데이터베이스에 저장
				int row1 = clientDao.join(client);
				if (row1 > 0) {
					int row2 = clientPreferenceElementDao.join(clientPreferenceElement);
					// 저장에 성공하면 map의 result에 true를 저장
					if (row1 > 0 && row2 > 0) {
						map.put("result", true);
					}
				}
			} catch (Exception e) {
				System.err.println("데이터베이스 데이터 삽입 실패 : " + e.getMessage());
				e.printStackTrace();
			}
		}
		return map;
	}

	// client 로그인 처리를 위한 메소드
	@Override
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("client 로그인 처리를 위한 메소드 확인 : 1");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", false);
		String clientEmail = request.getParameter("clientEmail");
		String clientPassword = request.getParameter("clientPassword");
		
		System.out.println("client 로그인 처리를 위한 메소드 확인 : 2");
		List<Client> list = clientDao.login();
		String key = "elwl5515";
		System.out.println(list);
		try {
			for (Client client : list) {
				if(CryptoUtil.decryptAES256(client.getClientEmail().trim(), key).equals(clientEmail) && 
						BCrypt.checkpw(clientPassword, client.getClientPassword())) {
					System.out.println("client 로그인 처리를 위한 메소드 확인 : 3");
					result.put("result", true);
					result.put("clientEmail", clientEmail);
					result.put("clientPassword", clientPassword);
					result.put("clientNickname", client.getClientNickname());
					result.put("clientProfileImage", client.getClientProfileImage());
					result.put("clientAge", client.getClientAge());
					result.put("clientName", client.getClientName());
				}
			}
		} catch (Exception e) {
			System.err.println("로그인 처리 실패 : " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println(result);
		request.getSession().setAttribute("clientinfo", result);
		return result;
		
	}

	//client 회원 정보 갱신을 위한 메소드
	@Transactional
	@Override
	public Map<String, Object> update(MultipartHttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		System.out.println("ClientServiceImpl의 update 메소드 확인 : 1");
		// 파라미터 읽기
		String clientAddress = request.getParameter("clientAddress");
		int clientAge = Integer.parseInt(request.getParameter("clientAge"));
		String clientEmail = request.getParameter("clientEmail");
		String clientName = request.getParameter("clientName");
		String clientNickname = request.getParameter("clientNickname");
		String clientPassword = request.getParameter("clientPassword");
		String clientPhoneNum = request.getParameter("clientPhoneNum");
		MultipartFile clientProfileImage = request.getFile("clientProfileImage");
		String oldClientProfileImage = request.getParameter("oldClientProfileImage");
		String preferConcent = request.getParameter("preferConcent");
		String preferNoKidsZone = request.getParameter("preferNoKidsZone");
		String preferParking = request.getParameter("preferParking");
		String preferPat = request.getParameter("preferPat");
		String preferRefill = request.getParameter("preferRefill");
		String preferWifi = request.getParameter("preferWifi");

		// 데이터베이스 구조에 맞추어 데이터 값 변경 체크하지 않은 경우 0 체크한 경우 1
		if (preferConcent == null) {
			preferConcent = "0";
		} else {
			preferConcent = "1";
		}
		if (preferNoKidsZone == null) {
			preferNoKidsZone = "0";
		} else {
			preferNoKidsZone = "1";
		}
		if (preferParking == null) {
			preferParking = "0";
		} else {
			preferParking = "1";
		}
		if (preferPat == null) {
			preferPat = "0";
		} else {
			preferPat = "1";
		}
		if (preferRefill == null) {
			preferRefill = "0";
		} else {
			preferRefill = "1";
		}
		if (preferWifi == null) {
			preferWifi = "0";
		} else {
			preferWifi = "1";
		}
		
		String image = null;
		//저장할 디렉토리 경로 생성
		String uploadPath = request.getServletContext().getRealPath("client/profile");
		if(clientProfileImage.isEmpty() == true) {
			System.out.println("ClientServiceImpl의 update 메소드 확인 : 2");
			//이전 이미지 파일 이름으로 설정
			image = oldClientProfileImage;
		}else {
			System.out.println("ClientServiceImpl의 update 메소드 확인 : 2");
			//업로드한 파일 이름 랜덤하게 설정
			image = UUID.randomUUID() + clientProfileImage.getOriginalFilename();
		}
		//저장할 때 사용할 전체 경로 생성
		uploadPath = uploadPath + "/" + image;
		//파일 객체 생성
		File file = new File(uploadPath);
		FileOutputStream fos = null;
		//파일 전송 요청
		try {
			fos = new FileOutputStream(file);
			fos.write(clientProfileImage.getBytes());
		}catch(Exception e) {
			System.err.println("프로필 이미지 전송 실패 : " + e.getMessage());
			e.printStackTrace();
		}
			//파라미터로 받은 데이터를 저장할 client, clientPreferenceElement DTO 객체 생성
			Client client = new Client();
			ClientPreferenceElement clientPreferenceElement = new ClientPreferenceElement();
			String key = "elwl5515";
			try {
				System.out.println("ClientServiceImpl의 update 메소드 확인 : 3");
				// 갱신 요청한 회원 정보 저장
				client.setClientAddress(clientAddress);
				client.setClientAge(clientAge);
				client.setClientEmail(CryptoUtil.encryptAES256(clientEmail, key));
				client.setClientName(clientName);
				client.setClientNickname(clientNickname);
				client.setClientPassword(BCrypt.hashpw(clientPassword, BCrypt.gensalt()));
				client.setClientPhoneNum(clientPhoneNum);
				client.setClientProfileImage(image);
				clientPreferenceElement.setClientNickname(clientNickname);
				clientPreferenceElement.setPreferConcent(preferConcent);
				clientPreferenceElement.setPreferNoKidsZone(preferNoKidsZone);
				clientPreferenceElement.setPreferParking(preferParking);
				clientPreferenceElement.setPreferPat(preferPat);
				clientPreferenceElement.setPreferRefill(preferRefill);
				clientPreferenceElement.setPreferWifi(preferWifi);
			}catch(Exception e) {
				System.err.println("파라미터 데이터 저장 실패 : " + e.getMessage());
				e.printStackTrace();
			}
			//clientDAO, clientPreferenceElementDAO의 update 메소드 호출하여 결과 저장
			int r1 = clientDao.update(client);
			int r2 = clientPreferenceElementDao.update(clientPreferenceElement);
			//각 결과를 확인하여 두 결과 모두 성공인 경우에 map의 result value를 true로 저장
			if(r1 == 1 && r2 == 1) {
				System.out.println("ClientServiceImpl의 update 메소드 확인 : 4");
				map.put("result", true);
			}
		
		return map;
	}
}
