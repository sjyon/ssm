package com.jayon.ssm.mapper;

import java.util.Map;

import com.jayon.ssm.mapper.base.BaseMapper;
import com.jayon.ssm.pojo.RoleDO;

public interface RoleMapper extends BaseMapper<RoleDO>{
	public int addRolePermission(Map<String,Object> params);//long roleId,List<Long> permissionIds
	
	public int deleteRolePermission(Map<String,Object> params);//long roleId,List<Long> permissionIds
	
}