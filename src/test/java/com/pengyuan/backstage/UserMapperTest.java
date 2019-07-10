package com.pengyuan.backstage;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pengyuan.backstage.bean.User;
import com.pengyuan.backstage.mapper.FactoryMapper;
import com.pengyuan.backstage.mapper.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	UserMapper um;
	
	@Autowired
	FactoryMapper fm;
	
	
	@Test
	public void MapperTest() {
		
		
		List<User> u=um.getUserList();
		
		System.out.println(u.get(0));
		
		System.out.println(fm.selectFactoryByFid(1));
		
	}
	
}
