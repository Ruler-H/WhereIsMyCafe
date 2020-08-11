package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.DrinkDAO;

@Service
public class DrinkServiceImple implements DrinkService {
	@Autowired
	private DrinkDAO drinkDao;
}
