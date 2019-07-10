package com.pengyuan.backstage;

import com.pengyuan.backstage.service.HotKeyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BackstageApplicationTests {

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	private HotKeyService hotKeyService;
	@Test
	public void contextLoads() {

		Set keys = redisTemplate.keys("goodsName:" + "*" + "拉" + "*");

		if(keys != null){
			keys.forEach(ele->{

				System.out.println(ele.toString().replaceAll("goodsName:", ""));
			});
		}

	}

}
