package gmail.elwl5515.portfolio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.elwl5515.portfolio.domain.CafeImage;

@Repository
public class CafeImageDAO {
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 처리를 위한 메소드
	public int join(CafeImage cafeImage) {
		System.out.println("CafeImageDAO join 메소드 호출");
		return sqlSession.insert("cafeimage.join", cafeImage);
	}

	//로그인 처리를 위한 메소드
	public List<CafeImage> login(){
		return sqlSession.selectList("cafeimage.login");
	}
}
