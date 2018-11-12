package com.daoImpl;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoginDao;
import com.domain.TypesData;
import com.domain.User;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {

	@Autowired SessionFactory sessionFactory;
	public boolean authenticateUser(String userName, String password) {
		
		String hql = "SELECT u.id FROM User u WHERE u.userName = :userName AND u.password = :password";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("userName", userName);
		query.setString("password", password);
		query.setMaxResults(1);
		Long id = (Long) query.uniqueResult();
		if(id == null) {
			return false;
		}
		return true;
	}
	
	public void save(User user) {
		
		this.sessionFactory.getCurrentSession().save(user);
		
	}

}
