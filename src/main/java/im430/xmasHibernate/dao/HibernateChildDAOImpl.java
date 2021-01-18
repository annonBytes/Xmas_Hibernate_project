package im430.xmasHibernate.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im430.xmasHibernate.business.Child;

@Repository
@Transactional
public class HibernateChildDAOImpl extends GenericHibernateDAOImpl<Child> implements ChildDAO {
	
	public HibernateChildDAOImpl() {
		super(Child.class);
	}

}
