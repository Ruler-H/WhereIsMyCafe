package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CouponDAO;

@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
	private CouponDAO couponDao;
}
