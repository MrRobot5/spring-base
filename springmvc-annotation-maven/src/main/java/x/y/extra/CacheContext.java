package x.y.extra;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * �Զ��建��ʵ��
 * http://www.cnblogs.com/rollenholt/p/4202631.html
 * 
 * @author yangp
 * @date 2015��10��28�� ����10:19:32
 * @param <T>
 */
@Component
public class CacheContext<T> {

	private ConcurrentHashMap<String, T> cache = new ConcurrentHashMap<String, T>();
	
	public T get(String key) {
		return cache.get(key);
	}
	
	public void put(String key, T value) {
		cache.put(key, value);
	}
	
	public void evit(String key) {
		cache.remove(key);
	}
	
	public void clear() {
		cache.clear();
	}
	
}
