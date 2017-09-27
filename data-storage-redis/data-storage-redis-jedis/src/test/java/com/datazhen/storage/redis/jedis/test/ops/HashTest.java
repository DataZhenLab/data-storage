package com.datazhen.storage.redis.jedis.test.ops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.datazhen.storage.redis.jedis.test.base.BaseJunitTest;

/**
 * 
 * HASH Test
 * @author Ma Ding
 *
 */
public class HashTest extends BaseJunitTest{

	/**
	 * 
	 */
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Test
	public void query() {
		String key ="website";
		String field = "google";
		String value = redisTemplate.hget(key, field);
		
		logger.info(String.format("value:%s", value));
	}
}
