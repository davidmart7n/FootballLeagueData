package dao.utils;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;


public abstract class GenericHibernateDAO extends HibernateDaoSupport{

	public Session getSession() {
		return this.getSessionFactory().getCurrentSession();
	}
	
}
