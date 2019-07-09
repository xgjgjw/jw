package com.mj.jw.cache.impl;


import com.mj.jw.cache.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("redisService")
public class RedisCache<K,HK, V> implements CacheService<K,HK, V> {
	private static final Long COUNT=1L;
	@Autowired
	private RedisTemplate<K, V> redisTemplate;

	public void set(K k, V v) {

		redisTemplate.opsForValue().set(k, v);

	}

	@Override
	public V getAndSet(K k, V v) {

		return redisTemplate.opsForValue().getAndSet(k, v);
	}

	@Override
	public V get(K k) {
		//
		return redisTemplate.opsForValue().get(k);
	}

	@Override
	public void del(K k) {
		redisTemplate.delete(k);

	}

	@Override
	public void delPattern(K p) {
		//
		Set<K> keys = redisTemplate.keys(p);
		redisTemplate.delete(keys);
	}

	@Override
	public Long lSize(K k) {
		//
		return redisTemplate.opsForList().size(k);
	}

	@Override
	public void lPush(K k, V v) {
		//
		redisTemplate.opsForList().leftPush(k, v);
	}

	@Override
	public void lRemove(K k, V v) {
		redisTemplate.opsForList().remove(k, COUNT, v);
	}


	@Override
	public void mapPut(K k, HK hk, V v) {
		redisTemplate.opsForHash().put(k, hk, v);
	}

	@Override
	public void mapPutAll(K k, Map<HK, V> map) {
		redisTemplate.opsForHash().putAll(k, map);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<V> mapGets(K k, Object... fs) {

		return (List<V>) redisTemplate.opsForHash().multiGet(k, Arrays.asList(fs));
	}

	@Override
	public boolean mapHasKey(K k, HK hk) {
		return redisTemplate.opsForHash().hasKey(k, hk);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<HK> mapKeys(K k) {

		return (Set<HK>) redisTemplate.opsForHash().keys(k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<V> mapValues(K k) {
		return (List<V>) redisTemplate.opsForHash().values(k);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<HK, V> mapGetAll(K k) {

		return 	(Map<HK, V>) redisTemplate.opsForHash().entries(k);
	}

	@Override
	public long ins(K k, long v) {

		return redisTemplate.opsForValue().increment(k, v);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V mapGet(K k, HK hk) {

		return (V) redisTemplate.opsForHash().get(k, hk);
	}

	@Override
	public void mapDel(K k, Object... ks) {
		redisTemplate.opsForHash().delete(k, ks);

	}


}
