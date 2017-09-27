package com.datazhen.storage.redis.jedis;
import redis.clients.jedis.Jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Redis 操作模板
 * @author Administrator
 *
 */
@Component
public class RedisTemplate {

	/**
	 * Redis handle
	 */
	@Autowired
	private Redis redis;
	
	public List<String> mget(String... keys) {
		try(Jedis j = redis.getPool().getResource()){
			List<String> ret = j.mget(keys);
			return ret;
		}
	}
	
	
	public String hget(String key, String field) {
		try (Jedis j = redis.getPool().getResource()){
			String ret = j.hget(key, field);
			return ret;
		}
	}
	
	
}
