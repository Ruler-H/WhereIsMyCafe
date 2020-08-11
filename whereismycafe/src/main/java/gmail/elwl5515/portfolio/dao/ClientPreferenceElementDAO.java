package gmail.elwl5515.portfolio.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.elwl5515.portfolio.domain.ClientPreferenceElement;

@Repository
public class ClientPreferenceElementDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//client 회원가입을 처리할 메소드 - clientServiceImpl에서 바로 처리함
	public int join(ClientPreferenceElement clientPreferenceElement) {
		return sqlSession.insert("clientpreferenceelement.join", clientPreferenceElement);
	}
	
	//client 회원 정보 갱신을 처리할 메소드 - clientServiceImpl에서 바로 처리함
	public int update(ClientPreferenceElement clientPreferenceElement) {
		System.out.println("ClientPreferenceElementDAO update 메소드 호출 확인");
		return sqlSession.update("clientpreferenceelement.update", clientPreferenceElement);
	}
}
