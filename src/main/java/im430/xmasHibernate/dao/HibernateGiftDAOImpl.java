package im430.xmasHibernate.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im430.xmasHibernate.business.Gift;

@Repository
@Transactional
public class HibernateGiftDAOImpl extends GenericHibernateDAOImpl<Gift> implements GiftDAO {

	public HibernateGiftDAOImpl() {
		super(Gift.class);
	}
}
