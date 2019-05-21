import redis.clients.jedis.Jedis;

public class Main {

    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("zs","很棒");
        String str=jedis.get("zs");
        jedis.disconnect();
        System.out.println(str);
    }
}
