package pers.ylin.demo.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.ylin.demo.entity.BorrowingLog;
import pers.ylin.demo.mapper.BorrowingLogMapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Ylin on 2018/9/5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("hello", "redis");
        System.out.println("useRedisDao = " + valueOperations.get("hello"));
    }


}