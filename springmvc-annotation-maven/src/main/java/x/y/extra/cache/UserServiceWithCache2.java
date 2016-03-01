package x.y.extra.cache;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import x.y.dao.UserDao;
import x.y.model.User;

/**
 * @Cacheable
 * 没有任何缓存逻辑代码，实现了基本的缓存方案
 * 
 * @author yangp
 * @date 2015年10月28日 下午9:32:21
 */
@Service
public class UserServiceWithCache2 implements IUserService {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UserDao userDao;
	
	@Cacheable(value = "userCache")
	public User getUser(String key) {
		log.info("get user...");
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		User user = userDao.get(key);
		return user;
	}
	
	@CacheEvict(value = "userCache", key = "#user.getId()")
	public void updateUser(User user) {
		log.info("evit cache...");
		userDao.update(user);
	}
	
}
