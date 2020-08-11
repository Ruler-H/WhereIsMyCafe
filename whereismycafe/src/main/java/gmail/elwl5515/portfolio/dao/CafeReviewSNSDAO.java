package gmail.elwl5515.portfolio.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CafeReviewSNSDAO {
	@Autowired
	private SqlSession sqlSession;
}
