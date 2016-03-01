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
 * û���κλ����߼����룬ʵ���˻����Ļ��淽��
 * 
 * @author yangp
 * @date 2015��10��28�� ����9:32:21
 */
@Service
public class UserServiceWithCache2 implements IUserService {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private UserDao userDao;
	
	@Cacheable(value = "userCache")
	public User getUser(String key) {
		log.info("get user...");
		// �����ڲ�ʵ�ֲ����ǻ����߼���ֱ��ʵ��ҵ��
		User user = userDao.get(key);
		return user;
	}
	
	@CacheEvict(value = "userCache", key = "#user.getId()")
	public void updateUser(User user) {
		log.info("evit cache...");
		userDao.update(user);
	}
	
}
