package com.datazhen.storage.redis.jedis;

import java.io.Serializable;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Jedis;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * Redis
 * @author Ma Ding
 *
 */
@Component
public class Redis implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5968903603800545383L;
	
	/**
	 * logger
	 */
	private final Logger logger = LogManager.getLogger(this.getClass());

	/**
	 * Jedis Client Pool
	 */
	private JedisPool pool;
	
	 
	@Autowired
	public Redis(
			 @Value("${redis.host}") String host,
			 @Value("${redis.port}") int port,
			 @Value("${redis.password}") String password,
			 @Value("${redis.timeout}") int timeout,
			 @Value("${redis.database}") int database,
			 @Value("${redis.maxTotal}") int maxTotal,
			 @Value("${redis.maxIdle}") int maxIdle,
			 @Value("${redis.maxWaitMillis}") long maxWaitMillis) {

		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		
		//config
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		config.setMaxWaitMillis(maxWaitMillis);
		
		//pool
		pool = new JedisPool(config, host, port, timeout, password, database);
	}
	
	public JedisPool getPool() {
		return pool;
	}
	

	/**
	 * check actived
	 */
	public void ping() {
		try (Jedis j = pool.getResource()){
			String ret = j.ping();
			if (ret.equals("PONG"))
				logger.info("Redis服务器连接正常"); 
		} catch(Exception e) {
			logger.info("Redis服务器连接异常");
		}
	}
	
	
}
