package x.y.extra.cache;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import x.y.dao.UserDao;
import x.y.extra.CacheContext;
import x.y.model.User;

/**
 * 1����������ҵ�������϶�̫��, getUser����̫�໺����߼���������ά���ͱ��
 * 2��������֧��ĳЩ�����»��棬����ĳЩ���͵�user ��Ҫ���棬��������ᵼ�´�����
 * 3����������л��������������
 * 
 * @author yangp
 * @date 2015��10��28�� ����9:32:21
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
