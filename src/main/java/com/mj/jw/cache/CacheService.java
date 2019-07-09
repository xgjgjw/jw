package com.mj.jw.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CacheService<K,HK,V>
{


	public void set(K k, V v);
	public V getAndSet(K k, V v);
	public V get(K k);
	public void del(K k);
	public void delPattern(K p);
	//  public long desr(K key);
	public Long lSize(K k);
	public void lPush(K k, V v);
	public void lRemove(K k, V v);
	public void mapPut(K k, HK hk, V v);
	public void mapPutAll(K k, Map<HK, V> map);
	public V mapGet(final K k, HK hk);
	public void mapDel(final K k, final Object... ks);
	public List<V> mapGets(final K k, final Object... fs);
	public Set<HK> mapKeys(final K k);
	public List<V> mapValues(final K k);
	public boolean mapHasKey(final K k, HK hk);
	public Map<HK,V> mapGetAll(final K k);
	public long ins(final K k, long v);

}
