package x.y.extra.cache;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import x.y.dao.UserDao;
import x.y.extra.CacheContext;
import x.y.model.User;

/**
 * 1、缓存代码和业务代码耦合度太高, getUser存在太多缓存的逻辑，不便于维护和变更
 * 2、不灵活，不支持某些条件下缓存，比如某些类型的user 需要缓存，这种需求会导致代码变更
 * 3、不能灵活切换第三方插件缓存
 * 
 * @author yangp
 * @date 2015年10月28日 下午9:32:21
 */
@Service
public class UserServiceWithCache implements IUserService {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private CacheContext<User> cache;
	
	@Resource
	private UserDao userDao;
	
	@Override
	public User getUser(String key) {
		User user = cache.get(key);
		if(user != null) {
			log.info("get from cache...");
			return user;
		}
		user = userDao.get(key);
		cache.put(key, user);
		return user;
	}
	
	public void reload() {
		cache.clear();
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
