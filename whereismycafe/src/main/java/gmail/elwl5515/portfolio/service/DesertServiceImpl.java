package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.DesertDAO;

@Service
public class DesertServiceImpl implements DesertService {
	@Autowired
	private DesertDAO desertDao;
}
