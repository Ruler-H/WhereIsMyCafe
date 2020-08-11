package gmail.elwl5515.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.elwl5515.portfolio.dao.ClientPreferenceElementDAO;

@Service
public class ClientPreferenceElementServiceImpl implements ClientPreferenceElementService {
	@Autowired
	private ClientPreferenceElementDAO clientPreferenceElementDao;
}
