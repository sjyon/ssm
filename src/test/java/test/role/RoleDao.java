package test.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayon.ssm.mapper.RoleMapper;
import com.jayon.ssm.pojo.RoleDO;

import test.base.BaseTest;

public class RoleDao extends BaseTest<RoleDO>{
	@Autowired
	RoleMapper roleMapper;
	
	@Test
	public void add(){
		RoleDO role = new RoleDO();
		role.setRole("abc"+new Random().nextInt(100));
		role.setDescription("中华人民共和国");
		role.setAvailable(true);
		roleMapper.add(role);
		System.out.println(role);
	}
	@Test
	public void delete(){
		RoleDO role = new RoleDO();
		role.setId(1);
		int i = roleMapper.delete(role);
		System.out.println(i);
	}
	@Test
	public void query(){
		RoleDO role = new RoleDO();
		role.setAvailable(null);
		List<RoleDO> list = roleMapper.query(role);
		for (RoleDO roleDO : list) {
			System.out.println(roleDO);
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void addRP(){
		Map<String,Object> params = new HashMap<>();
		params.put("roleId", 3L);
		List<Integer> permissionIds = new ArrayList<>();
		permissionIds.add(2);
		permissionIds.add(4);
		params.put("permissionIds", permissionIds);
		int i = roleMapper.addRolePermission(params);
		System.out.println(i);
		
	}
	@Test
	public void delRP(){
		Map<String,Object> params = new HashMap<>();
		params.put("roleId", 3);
		List<Integer> permissionIds = new ArrayList<>();
		permissionIds.add(2);
		permissionIds.add(4);
		params.put("permissionIds", permissionIds);
		int i = roleMapper.deleteRolePermission(params);
		System.out.println(i);
	}
}
