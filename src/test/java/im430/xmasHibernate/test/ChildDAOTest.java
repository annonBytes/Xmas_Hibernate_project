package im430.xmasHibernate.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import im430.xmasHibernate.dao.GiftDAO;
import im430.xmasHibernate.business.Address;
import im430.xmasHibernate.business.Child;
import im430.xmasHibernate.business.Gift;
import im430.xmasHibernate.dao.AddressDAO;
import im430.xmasHibernate.dao.ChildDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("DAOTest-context.xml")
@Transactional
public class ChildDAOTest {

	@Autowired
	private ChildDAO childDAO;

	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private GiftDAO giftDAO;

	@Test
    public void shouldAddChildToAddress() {
		Address  address1 = new Address();
		address1.setText("test entry" + new Date());
		addressDAO.saveOrUpdate(address1);
		
		Child child1 = new Child();
		child1.setName("Daniel");
		
		address1.addChild(child1);
		
		Address address2 = addressDAO.getById(address1.getId());
		
		assertEquals(address1.getChildren().size(), address2.getChildren().size());
		
		address2.removeChild(child1);
		
		assertEquals(address1.getChildren().size(), address2.getChildren().size());
	}
	
	@Test
	public void compareTwoChildren() {
		Address  address1 = new Address();
		address1.setText("test entry" + new Date());
		addressDAO.saveOrUpdate(address1);
		
		Child child1 = new Child();
		child1.setName("Daniel");
		
		address1.addChild(child1);
		
		childDAO.saveOrUpdate(child1);
		
		Child child2 = childDAO.getById(child1.getId());
		
		assertEquals(child1.getAddress(), child2.getAddress());
		assertEquals(child1, child2);

	}
	
	@Test
	public void shouldTestGiftChildRelation() {
		Address  address1 = new Address();
		address1.setText("test entry" + new Date());
		addressDAO.saveOrUpdate(address1);
		
		Child child1 = new Child();
		child1.setName("Daniel");
		
		address1.addChild(child1);
		
		Gift gift1 = new Gift();
		gift1.setDescription("Testgift " + new Date());
		child1.addGift(gift1);
		
		childDAO.saveOrUpdate(child1);
		giftDAO.saveOrUpdate(gift1);

		
		Child child2 = childDAO.getById(child1.getId());
		
		assertEquals(child1.getGifts().size(), child2.getGifts().size());
		assertTrue(child2.getGifts().contains(gift1));
		assertTrue(gift1.getChildren().contains(child1));
		assertTrue(gift1.getChildren().contains(child2));
	}
		
}



