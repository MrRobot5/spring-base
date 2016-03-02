package x.y.extra.bean;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import x.y.model.User;

public class BeanWrapperTest {

	public static void main(String[] args) {
		User user = new User();
		BeanWrapper wrapper = new BeanWrapperImpl(user);
		wrapper.setPropertyValue("username", "jim");
		System.out.println(user.getUsername());
		
	}

}
