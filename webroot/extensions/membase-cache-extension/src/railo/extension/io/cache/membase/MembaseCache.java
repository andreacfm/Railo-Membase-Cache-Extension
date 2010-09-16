package railo.extension.io.cache.membase;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;

import railo.commons.io.cache.Cache;
import railo.commons.io.cache.CacheEntry;
import railo.commons.io.cache.CacheEntryFilter;
import railo.commons.io.cache.CacheKeyFilter;
import railo.loader.engine.CFMLEngine;
import railo.loader.engine.CFMLEngineFactory;
import railo.runtime.type.Struct;
import railo.runtime.util.Cast;

public class MembaseCache implements Cache {
	
	private MemcachedClient mc;
	private List<InetSocketAddress> addrs;
	private String cacheName;
	private String host;

	@Override
	public void init(String cacheName, Struct arguments) throws IOException {
		this.cacheName = cacheName;
		CFMLEngine engine = CFMLEngineFactory.getInstance();
		Cast caster = engine.getCastUtil();

	    try {
	    	this.host = caster.toString(arguments.get("host"));   
	    	List<InetSocketAddress> addrs = AddrUtil.getAddresses(this.host);
        	this.mc = new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.TEXT).build(),addrs);                        
       
	    } catch (Exception e) {
            e.printStackTrace();
        }		

	}
	
	@Override
	public boolean contains(String key) {
		try{
			getCacheEntry(key);
			return true;
		}
		catch(IOException e){
			return false;
		}	
	}

	@Override
	public List entries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List entries(CacheKeyFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List entries(CacheEntryFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheEntry getCacheEntry(String key) throws IOException {
		Object obj = this.mc.get(key);
		MembaseCacheEntry entry = new MembaseCacheEntry(new MembaseCacheItem(mc, obj));
		return entry;
	}

	@Override
	public CacheEntry getCacheEntry(String arg0, CacheEntry arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct getCustomInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(String key) throws IOException {
		
		try{
			CacheEntry entry = getCacheEntry(key);
			Object result = entry.getValue();
			return result;
		}catch(IOException e){
			throw(e);
		}
		
	}

	@Override
	public Object getValue(String key, Object defaultValue) {
		try{
			Object result = getValue(key);
			return result;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long hitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List keys(CacheKeyFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List keys(CacheEntryFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long missCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void put(String key, Object value, Long idleTime, Long lifeSpan) {
		int span = lifeSpan==null?0:lifeSpan.intValue();
		this.mc.add(key.toLowerCase(),span,value);
	}

	@Override
	public boolean remove(String key) {
		this.mc.delete(key);
		return false;
	}

	@Override
	public int remove(CacheKeyFilter filter) {
		
		return 0;
	}

	@Override
	public int remove(CacheEntryFilter arg0) {
		
		return 0;
	}

	@Override
	public List values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List values(CacheKeyFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List values(CacheEntryFilter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
