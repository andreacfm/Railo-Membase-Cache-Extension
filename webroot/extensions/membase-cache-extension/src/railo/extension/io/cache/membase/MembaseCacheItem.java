package railo.extension.io.cache.membase;

import net.spy.memcached.MemcachedClient;

public class MembaseCacheItem {
	
	private Object value;
	private MemcachedClient mc;
	
	public MembaseCacheItem(MemcachedClient mc,Object obj) {
		this.mc = mc;
		this.value = obj;	
	}
	
	public MemcachedClient getMc() {
		return mc;
	}
	
	public Object getValue() {
		return value;
	}

}
