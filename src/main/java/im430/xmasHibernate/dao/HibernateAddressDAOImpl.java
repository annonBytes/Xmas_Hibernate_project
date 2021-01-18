package im430.xmasHibernate.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import im430.xmasHibernate.business.Address;

@Repository
@Transactional
public class HibernateAddressDAOImpl extends GenericHibernateDAOImpl<Address> implements AddressDAO {

	public HibernateAddressDAOImpl() {
		super(Address.class);
	}

}
