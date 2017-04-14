package test.permission;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayon.ssm.mapper.PermissionMapper;
import com.jayon.ssm.pojo.PermissionDO;

import test.base.BaseTest;

public class PermissionDao extends BaseTest<PermissionDO>{
	@Autowired
	PermissionMapper permissionMapper;
	
	@Test
	public void add(){
		PermissionDO permission = new PermissionDO();
		permission.setDescription("login");
		permission.setPermission("login"+new Random().nextInt(100));
		permissionMapper.add(permission);
		
		System.out.println(permission);
	}

	@Override
	@Test
	public void delete() {
		PermissionDO permission = new PermissionDO();
		permission.setId(1);
		
		int i = permissionMapper.delete(permission);
		System.out.println(i);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Test
	public void query() {
		PermissionDO permission = new PermissionDO();
		permission.setAvailable(null);
		List<PermissionDO> list = permissionMapper.query(permission);
		for (PermissionDO permissionDO : list) {
			System.out.println(permissionDO);
		}
	};
}
