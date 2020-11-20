package gmail.elwl5515.portfolio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.elwl5515.portfolio.domain.CafeSub;

@Repository
public class CafeSubDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 처리를 위한 메소드
	public int join(CafeSub cafeSub) {
		System.out.println("CafeSubDAO join 메소드 호출 확인");
		return sqlSession.insert("cafesub.join", cafeSub);
	}
	
	//로그인 처리를 위한 메소드
	public List<CafeSub> login(){
		return sqlSession.selectList("cafesub.login");
	}
	
	//정보 수정 처리를 위한 메소드
	public int update(CafeSub cafeSub){
		System.out.println("CafeSubDAO update 메소드 호출 확인");
		return sqlSession.update("cafesub.update", cafeSub);
	}
}
