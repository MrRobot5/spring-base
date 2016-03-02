package x.y.extra.cache;

import x.y.model.User;

public interface IUserService {

	public abstract User getUser(String key);
	
	public void updateUser(User user);

}