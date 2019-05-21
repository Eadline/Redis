package test;

import util.RedisUtil2;

public class test03 {
    public static void main(String[] args) {
        RedisUtil2.setValue(RedisUtil2.CRM_USER,"zs","张三的信息");
        System.out.println(RedisUtil2.getValue(RedisUtil2.CRM_USER,"zs"));
    }
}
