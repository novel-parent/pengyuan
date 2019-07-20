package com.pengyuan.backstage;

import com.pengyuan.backstage.mapper.OrderMapper;
import com.pengyuan.backstage.service.HotKeyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackstageApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	OrderMapper orderMapper;

	@Autowired
	private HotKeyService hotKeyService;
	@Test
	public void contextLoads() {

		Set<String> keys = stringRedisTemplate.keys("user:*");

		System.out.println(keys);

	}

}
