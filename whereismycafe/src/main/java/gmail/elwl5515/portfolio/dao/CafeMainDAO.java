package gmail.elwl5515.portfolio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.elwl5515.portfolio.domain.CafeMain;

@Repository
public class CafeMainDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//닉네임 중복 체크를 위한 메소드
	public String cafeNicknameCheck(String cafeNickname) {
		System.out.println("CafeMainDAO 닉네임체크 메소드 호출 확인");
		return sqlSession.selectOne("cafemain.nicknamecheck", cafeNickname);
	}
		
	//회원가입 처리를 위한 메소드
	public int join(CafeMain cafeMain) {
		System.out.println("CafeMainDAO join 메소드 호출 확인");
		return sqlSession.insert("cafemain.join", cafeMain);
	}
	
	//로그인 처리를 위한 메소드
	public List<CafeMain> login(){
		return sqlSession.selectList("cafemain.login");
	}
	
	//정보 수정 처리를 위한 메소드
	public int update(CafeMain cafeMain) {
		System.out.println("CafeMainDAO update 메소드 호출 확인");
		return sqlSession.update("cafemain.update", cafeMain);
	}
	
	//카페 리스트를 반환을 위한 메소드
	public List<CafeMain> list() throws Exception{
		System.out.println("CafeMainDAO list 메소드 호출 확인");
		return sqlSession.selectList("cafemain.list");
	};
}
