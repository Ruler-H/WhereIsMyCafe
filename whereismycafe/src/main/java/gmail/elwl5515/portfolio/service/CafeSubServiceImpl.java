package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CafeSubDAO;

@Service
public class CafeSubServiceImpl implements CafeSubService {
	@Autowired
	private CafeSubDAO cafeSubDao;
}
