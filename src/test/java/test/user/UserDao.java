package test.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayon.ssm.mapper.UserMapper;
import com.jayon.ssm.pojo.UserDO;

import test.base.BaseTest;

public class UserDao extends BaseTest<UserDO>{
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void add() {
		UserDO user = new UserDO();
		user.setUserName("adf"+new Random().nextInt(10));
		user.setPassword("asdf");
		user.setLocked(true);
		userMapper.add(user);
		System.out.println(user.getId());
	}
	@Test
	public void update() {
		UserDO user = new UserDO();
		user.setId(7);
		user.setPassword("ggg");
		user.setSalt("adf");
		user.setUserName("bbb");
		int i = userMapper.update(user);
		System.out.println(i);
	}
	@Test
	public void delete() {
		UserDO user = new UserDO();
		user.setId(7);
		int i = userMapper.delete(user);
		System.out.println(i);
	}
	@Test
	public void query() {
		UserDO user = new UserDO();
		user.setLocked(null);
		List<UserDO> list = userMapper.query(user);
		for (UserDO userDO : list) {
			System.out.println(userDO);
		}
	}
	@Test
	public void addUR(){
		Map<String,Object> params = new HashMap<>();
		params.put("userId", 1L);
		List<Long> roleIds = new ArrayList<>();
		roleIds.add(3L);
		params.put("roleIds", roleIds);
		
		int i = userMapper.addUserRoles(params);
		System.out.println(i);
	}
	@Test
	public void delUR(){
		Map<String,Object> params = new HashMap<>();
		params.put("userId", 1L);
		List<Long> roleIds = new ArrayList<>();
		roleIds.add(3L);
		roleIds.add(5L);
		params.put("roleIds", roleIds);
		
		int i = userMapper.deleteUserRoles(params);
		System.out.println(i);
		
	}
	@Test
	public void queryRoles(){
		UserDO user = new UserDO();
		user.setUserName("adf");
		Set<String> set = userMapper.queryRoles(user);
		System.out.println(set);
	}
	@Test
	public void queryPermission(){
		UserDO user = new UserDO();
		user.setUserName("adf");
		Set<String> set = userMapper.queryPermissioins(user);
		System.out.println(set);
	}

}
