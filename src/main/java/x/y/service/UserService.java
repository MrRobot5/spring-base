package x.y.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import x.y.dao.UserDao;
import x.y.model.User;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;

	public void add(String uname) {
		User u = new User();
		u.setUsername(uname);
		userDao.add(u);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> listAll() {
		return this.userDao.queryAll();
		
	}

}
