package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CafeReviewSNSDAO;

@Service
public class CafeReviewSNSServiceImpl implements CafeReviewSNSService {
	@Autowired
	private CafeReviewSNSDAO cafeReviewSnsDao;
}
