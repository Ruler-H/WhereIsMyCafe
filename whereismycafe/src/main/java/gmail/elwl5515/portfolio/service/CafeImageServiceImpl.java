package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.CafeImageDAO;

@Service
public class CafeImageServiceImpl implements CafeImageService {
	@Autowired
	private CafeImageDAO cafeImageDao;

}
