package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CafeClientDAO;

@Service
public class CafeClientServiceImpl implements CafeClientService {
	@Autowired
	private CafeClientDAO cafeClientDao;
}
