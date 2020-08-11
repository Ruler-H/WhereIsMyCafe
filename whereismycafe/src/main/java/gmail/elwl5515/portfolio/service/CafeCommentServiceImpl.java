package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CafeCommentDAO;

@Service
public class CafeCommentServiceImpl implements CafeCommentService {
	@Autowired
	private CafeCommentDAO cafeCommentDao;
}
