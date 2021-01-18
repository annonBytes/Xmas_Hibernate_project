package im430.xmasHibernate.test;


import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import im430.xmasHibernate.business.Address;
import im430.xmasHibernate.dao.AddressDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
@Transactional
public class AddressDAOTest {
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Test
	public void addAddress() {
		Address address1 = new Address();
		address1.setText("test entry" + new Date());
		
		int len1 = addressDAO.getAll().size();
		addressDAO.saveOrUpdate(address1);
		assertEquals(len1+1, addressDAO.getAll().size());
		
		Address address2 = addressDAO.getById(address1.getId());
		assertEquals(address1.getText(), address2.getText());
		assertEquals(address1,address2);
		
		addressDAO.delete(address2);
		assertEquals(len1,addressDAO.getAll().size());
	}
	

}
