package test;

import redis.clients.jedis.Jedis;

import java.util.Map;

public class test01 {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.del("zs");
        jedis.hset("zs","name","张三");
        jedis.hset("zs","age","18");

        Map<String,String> map=jedis.hgetAll("zs");
        String str=jedis.hget("zs","age");
        jedis.disconnect();
        System.out.println(map.get("name"));
        System.out.println(str);
    }
}
