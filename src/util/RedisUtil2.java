package util;

import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil2 {
	public static final String CRM_USER= "CRM-USER_";//用于标识是CRM系统的用户


	private static JedisPool jedisPool = null;//Redis连接池

	/**
	 * 初始化Redis连接池
	 */
	static {
		try {
			Properties p = new Properties();
			p.load(RedisUtil2.class.getClassLoader().getResourceAsStream("redis.properties"));
			JedisPoolConfig config = new JedisPoolConfig();
			//config.setTestOnBorrow(TEST_ON_BORROW);
			config.setMaxActive(Integer.parseInt(p.getProperty("MAX_ACTIVE")));//最大连接
			config.setMaxIdle(Integer.parseInt(p.getProperty("MAX_IDLE")));//最大空闲
			config.setMaxWait(Long.parseLong(p.getProperty("MAX_WAIT")));//等待可用连接的最大时间，单位毫秒
			//config.setTestOnBorrow(true);
			jedisPool = new JedisPool(config, p.getProperty("ADDR"), Integer.parseInt(p.getProperty("PORT")), Integer.parseInt(p.getProperty("TIMEOUT")),null);
			//jedisPool = new JedisPool(config, p.getProperty("ADDR"), Integer.parseInt(p.getProperty("PORT")), Integer.parseInt(p.getProperty("TIMEOUT")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据table+key,获得value
	 * @param table
	 * @param key
	 * @return
	 */
	public static String getValue(String table , String key ){
		Jedis jedis = jedisPool.getResource();
		String back = jedis.get(table+key);
		jedisPool.returnResource(jedis);
		return back;
	}
	/**
	 * 根据table+key,存入value
	 * @param table
	 * @param key
	 * @param value
	 * @return
	 */
	public static String setValue(String table ,String key, String value ){
		Jedis jedis = jedisPool.getResource();
		String back = jedis.set(table+key, value);
		jedisPool.returnResource(jedis);
		return back;
	}

}
