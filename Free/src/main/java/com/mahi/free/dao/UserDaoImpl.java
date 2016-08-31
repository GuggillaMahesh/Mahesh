package com.mahi.free.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahi.free.model.User;
import com.mahi.free.model.UserRole;
@Repository
public class UserDaoImpl implements UserDao{
@Autowired
	SessionFactory sessionFactory;
	public void addUser(User user) {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		user.setEnbaled(true);
	session.save(user);
	UserRole userRole=new UserRole();
	userRole.setAuthority("ROLE_USER");
	userRole.setId(user.getId());
	session.save(userRole);
		transaction.commit();
		System.out.println("i am done");
	}
	@Override
	public List<User> viewUser() {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		List<User> list=session.createCriteria(User.class).list();
		return list;
			}
	public User getUserByName(String name) {
		
			Session session=sessionFactory.getCurrentSession();
			Transaction transaction=session.beginTransaction();
			User user=(User) session.createCriteria(User.class).add(Restrictions.like("name", name)).uniqueResult();
			return user;
	
	}

}
