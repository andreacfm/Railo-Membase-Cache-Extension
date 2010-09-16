package railo.extension.io.cache.membase;

import java.util.Date;

import railo.commons.io.cache.CacheEntry;
import railo.runtime.type.Struct;

public class MembaseCacheEntry implements CacheEntry {
	
	private MembaseCacheItem item;
	
	public MembaseCacheEntry(MembaseCacheItem item) {
		this.item = item;	
	}

	@Override
	public Date created() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct getCustomInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue() {
		return this.item.getValue();
	}

	@Override
	public int hitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long idleTimeSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date lastHit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date lastModified() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long liveTimeSpan() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
