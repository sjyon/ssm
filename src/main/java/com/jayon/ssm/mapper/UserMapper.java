package com.jayon.ssm.mapper;

import java.util.Map;
import java.util.Set;

import com.jayon.ssm.mapper.base.BaseMapper;
import com.jayon.ssm.pojo.UserDO;

public interface UserMapper extends BaseMapper<UserDO>{
	public int addUserRoles(Map<String,Object> params);//Long userId,List<Long> roleIds
	
	public int deleteUserRoles(Map<String,Object> params);//Long userId,List<Long> roleIds
	
	public Set<String> queryRoles(UserDO userDO);
	
	public Set<String> queryPermissioins(UserDO userDO);
}
