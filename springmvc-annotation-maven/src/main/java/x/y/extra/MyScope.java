package x.y.extra;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class MyScope implements Scope {

	private final ThreadLocal<Map> threadScope = new ThreadLocal<Map>() {

		@Override
		protected Map initialValue() {
			return new HashMap();
		}
		
	};
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		Map scope = threadScope.get();
		Object object = scope.get(name);
		if(object == null) {
			object = objectFactory.getObject();
			scope.put(name, object);
		}
		return object;
	}

	@Override
	public String getConversationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerDestructionCallback(String arg0, Runnable arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object remove(String name) {
		Map map = threadScope.get();
		return map.remove(name);
	}

	@Override
	public Object resolveContextualObject(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
