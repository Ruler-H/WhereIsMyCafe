package gmail.elwl5515.portfolio;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import gmail.elwl5515.portfolio.domain.CafeImage;
import gmail.elwl5515.portfolio.domain.CafeMain;
import gmail.elwl5515.portfolio.domain.CafeSub;
import gmail.elwl5515.portfolio.domain.Client;
import gmail.elwl5515.portfolio.domain.ClientPreferenceElement;


//Spring에서 Unit4 라이브러리를 사용하기 위한 설정
@RunWith(SpringJUnit4ClassRunner.class)


//locations에 설정된 파일들을 실행시켜 메모리에 로드하기 위한 설정
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class PortfolioTest {
	
	//데이터베이스 연결 확인 시 필요한 DataSource 주입
	@Autowired
	private DataSource dataSource;
	
	//연결 테스트를 위한 메소드
	@Test
	public void connectTest() {
		try {
			System.out.println(dataSource.getConnection());
		}catch(Exception e){
			System.out.println("연결 테스트 실패");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void sqlTest() {
		
		//System.out.println(sqlSession.toString());
		//닉네임 중복검사 - 존재하는 닉네임으로 확인
		String nickname = sqlSession.selectOne("client.nicknamecheck", "흠븜흠");
		//System.out.println(nickname);
		//닉네임 중복검사 - 존재하지 않는 닉네임으로 확인확인
		nickname = sqlSession.selectOne("client.nicknamecheck", "븜즘음");
		//System.out.println(nickname);
		//회원가입 확인을 위한 데이터 삽입 확인
		Client client = new Client();
		client.setClientAddress("일산");
		client.setClientAge(20);
		client.setClientEmail("gjs5515@naver.com");
		client.setClientName("황병헌");
		client.setClientNickname("흠븜흠");
		client.setClientPassword("qwerqwerqwe");
		client.setClientPhoneNum("031-964-6216");
		client.setClientProfileImage("gg");
	
		//System.out.println(sqlSession.insert("client.join", client));
		
		//회원가입 중 선호 요소 확인을 위한 데이터 삽입
		ClientPreferenceElement clientPreferenceElement = new ClientPreferenceElement();
		clientPreferenceElement.setClientNickname("흠븜흠");
		clientPreferenceElement.setPreferConcent("1");
		clientPreferenceElement.setPreferNoKidsZone("1");
		clientPreferenceElement.setPreferParking("1");
		clientPreferenceElement.setPreferPat("1");
		clientPreferenceElement.setPreferRefill("1");
		clientPreferenceElement.setPreferWifi("1");
		
		//System.out.println(sqlSession.insert("clientpreferenceelement.join", clientPreferenceElement));
		
		//System.out.println(sqlSession.update("client.update", client));
		//System.out.println(sqlSession.update("clientpreferenceelement.update", clientPreferenceElement));
		
		
		//카페 닉네임 중복검사 - 존재하는 닉네임으로 확인
		nickname = sqlSession.selectOne("cafemain.nicknamecheck", "huge cafe");
		System.out.println(nickname);
		
		//카페 닉네임 중복검사 - 존재하지 않는 닉네임으로 확인
		nickname = sqlSession.selectOne("cafemain.nicknamecheck", "hu cafe");
		System.out.println(nickname);
		
		CafeMain cafeMain = new CafeMain();
		cafeMain.setCafeAddress("경기");
		cafeMain.setCafeCommentary("좋아요");
		cafeMain.setCafeLogo("이쁜 로고");
		cafeMain.setCafeName("GRATIA");
		cafeMain.setCafeNickname("GRATIA");
		cafeMain.setCafeParking("0");
		cafeMain.setCafePassword("qudgjs01");
		cafeMain.setCafePhoneNum("031-963-6631");
		cafeMain.setCafeRefill("1");
		cafeMain.setCafeTableNum(20);
		cafeMain.setCafeWifi("1");
		cafeMain.setConcentTableNum(6);
		
		//System.out.println(sqlSession.insert("cafemain.join", cafeMain));
		
		CafeSub cafeSub = new CafeSub();
		cafeSub.setCafeCoupon("1");
		cafeSub.setCafeHomepage("www.gratia.com");
		cafeSub.setCafeNickname("GRATIA");
		cafeSub.setCafeSNS("instagram");
		cafeSub.setNoKidsZone("0");
		cafeSub.setOutdoorTableNum(0);
		cafeSub.setSirenOrder("0");
		cafeSub.setTumblerDiscount("0");
		
		//System.out.println(sqlSession.insert("cafesub.join", cafeSub));
		
		CafeImage cafeImage = new CafeImage();
		cafeImage.setCafeImage("이쁜 사진");
		cafeImage.setCafeNickname("huge cafe");
		
		System.out.println(sqlSession.insert("cafeimage.join", cafeImage));
		
		
	}

}
