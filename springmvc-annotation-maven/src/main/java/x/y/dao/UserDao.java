package x.y.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import x.y.model.User;

@Repository
public class UserDao {
	
	private Log logger = LogFactory.getLog(getClass());
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public void add(User u){
		logger.info("hibernateTemplate.save");
		u.setId(1);
		hibernateTemplate.save(u);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<User> queryAll() {
		return this.hibernateTemplate.find("from User");
	}
	
	public User get(String id) {
		logger.info("hibernateTemplate.get...");
		return this.hibernateTemplate.get(User.class, Integer.parseInt(id));
	}

	public void update(User user) {
		this.hibernateTemplate.update(user);
		
	}
	
}
