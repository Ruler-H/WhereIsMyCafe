package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CafeMainDAO;

@Service
public class CafeMainServiceImple implements CafeMainService {
	@Autowired
	private CafeMainDAO cafeMainDao;
}
