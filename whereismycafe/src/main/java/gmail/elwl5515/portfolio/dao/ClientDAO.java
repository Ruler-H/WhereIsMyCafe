package gmail.elwl5515.portfolio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.elwl5515.portfolio.domain.Client;

@Repository
public class ClientDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//닉네임 중복 체크를 위한 메소드
	public String clientNicknameCheck(String clientNickname) {
		System.out.println("ClientDAO clientNicknameCheck 메소드 호출 확인");
		return sqlSession.selectOne("client.nicknamecheck", clientNickname);
	}
	
	//회원가입 처리를 위한 메소드
	public int join(Client client) {
		System.out.println("ClientDAO join 메소드 호출 확인");
		return sqlSession.insert("client.join", client);
	}
	
	//로그인 처리를 위한 메소드
	public List<Client> login(){
		return sqlSession.selectList("client.login 메소드 호출 확인");
	}
	
	//정보 수정 처리를 위한 메소드
	public int update(Client client) {
		System.out.println("ClientDAO update 메소드 호출 확인");
		return sqlSession.update("client.update", client);
	}
	
}
