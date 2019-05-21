package test;

import redis.clients.jedis.Jedis;
import util.RedisUtil;

public class test02 {
    public static void main(String[] args) {
        Jedis jedis=RedisUtil.getJedis();
        jedis.set("lisi","李四");
        RedisUtil.returnResource(jedis);

    }
}
