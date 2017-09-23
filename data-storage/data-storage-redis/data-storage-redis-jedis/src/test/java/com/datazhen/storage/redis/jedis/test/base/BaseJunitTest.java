package com.datazhen.storage.redis.jedis.test.base;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datazhen.storage.redis.jedis.RedisTemplate;
/**
 * 
 * Redis Junit Base
 * @author Ma Ding
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class BaseJunitTest {

	
	@Autowired
	protected RedisTemplate redisTemplate;
}
