package railo.extension.io.cache.membase;

import java.net.InetSocketAddress;
import java.util.List;

import net.spy.memcached.MemcachedClient;

public class MembaseCacheItem {
	
	private Object value;
	private MembaseCache cache;
	private String key;
	
	public MembaseCacheItem(MembaseCache cache,String key,Object obj) {
		this.cache = cache;
		this.value = obj;
		this.key = key;
	}

	
	public List<InetSocketAddress> getAddresses(){
		return this.cache.getAddresses();
	}

	public MemcachedClient getMc() {
		return this.cache.getMC();
	}
	
	public Object getValue() {
		return value;
	}
	
	public String getKey(){
		return key;
	}

}
