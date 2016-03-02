package x.y.extra.cache;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import x.y.model.User;

public class UserServiceWithCacheTest {

	private IUserService service;
	
	private final Logger log = Logger.getLogger(this.getClass());
	
	@Before
	public void setup() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{ "app-hibernate-config.xml"});
		service = (IUserService)applicationContext.getBean("userServiceWithCache2");
	}
	
	@Test
	public void testInject() {
		Assert.assertNotNull(service);
	}
	
	@Test
	public void testCache() {
		User user = service.getUser("1");
		user = service.getUser("1");
		user.setUsername("wulala");
		service.updateUser(user);
		log.info("cache reload...");
		User user2 = service.getUser("1");
		System.out.println(user2);
		service.getUser("1");
		
	}
	
}
