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
	
	//�땳�꽕�엫 以묐났 泥댄겕瑜� �쐞�븳 硫붿냼�뱶
	public String clientNicknameCheck(String clientNickname) {
		System.out.println("ClientDAO clientNicknameCheck 硫붿냼�뱶 �샇異� �솗�씤");
		return sqlSession.selectOne("client.nicknamecheck", clientNickname);
	}
	
	//�쉶�썝媛��엯 泥섎━瑜� �쐞�븳 硫붿냼�뱶
	public int join(Client client) {
		System.out.println("ClientDAO join 硫붿냼�뱶 �샇異� �솗�씤");
		return sqlSession.insert("client.join", client);
	}
	
	//濡쒓렇�씤 泥섎━瑜� �쐞�븳 硫붿냼�뱶
	public List<Client> login(){
		return sqlSession.selectList("client.login");
	}
	
	//�쉶�썝 �젙蹂� 媛깆떊�쓣 泥섎━瑜� �쐞�븳 硫붿냼�뱶
	public int update(Client client) {
		System.out.println("ClientDAO update 硫붿냼�뱶 �샇異� �솗�씤");
		return sqlSession.update("client.update", client);
	}
	
}
