package x.y.extra;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * 自定义缓存实现
 * http://www.cnblogs.com/rollenholt/p/4202631.html
 * 
 * @author yangp
 * @date 2015年10月28日 下午10:19:32
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
