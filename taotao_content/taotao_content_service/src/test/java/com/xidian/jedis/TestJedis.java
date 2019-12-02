package com.xidian.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class TestJedis {

    @Test
    public void testJedis() throws Exception{
        //创建jedis对象，指定ip和端口
        Jedis jedis=new Jedis("192.168.25.150",6379);
        jedis.set("jedis-key","1234");
        String string=jedis.get("jedis-key");
        System.out.println(string);
        jedis.close();
    }


    public void testJedisPool()throws Exception{
        //创建连接池对象，指定端口和Ip
        JedisPool jedisPool=new JedisPool("192.168.25.150",6379);
        //从连接池中获得连接
        Jedis jedis=jedisPool.getResource();
        //使用jedis操作数据库
        String result=jedis.get("jedis-key");
        System.out.println(result);
        //关闭jedis连接
        jedis.close();
        //系统关闭前关闭连接
        jedisPool.close();

    }

    @Test
    public void testJedisCluster() throws Exception{
        //创建一个JedisCluster对象，构造参数Set类型，集合中每个元素是HostAndPort
        Set<HostAndPort> nodes=new HashSet<>();
        nodes.add(new HostAndPort("192.168.25.133",7001));
        nodes.add(new HostAndPort("192.168.25.133",7002));
        nodes.add(new HostAndPort("192.168.25.133",7003));
        nodes.add(new HostAndPort("192.168.25.133",7004));
        nodes.add(new HostAndPort("192.168.25.133",7005));
        nodes.add(new HostAndPort("192.168.25.133",7006));
        JedisCluster jedisCluster=new JedisCluster(nodes);
        jedisCluster.set("cluster-test","hello jedis cluster");
        String string =jedisCluster.get("cluster-test");
        System.out.println(string);
        jedisCluster.close();

    }
}
