package com.jayon.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayon.ssm.mapper.RoleMapper;
import com.jayon.ssm.pojo.RoleDO;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
    private RoleMapper roleMapper;

    public RoleDO createRole(RoleDO role) {
    	roleMapper.add(role);
    	return role;
    }

    public void deleteRole(int roleId) {
    	RoleDO role = new RoleDO();
        roleMapper.delete(role);
    }

    public void correlationPermissions(int roleId, List<Integer> permissionIds) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("roleId", roleId);
    	params.put("permissionIds", permissionIds);
        roleMapper.addRolePermission(params);
    }

    public void uncorrelationPermissions(int roleId, List<Integer> permissionIds) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("roleId", roleId);
    	params.put("permissionIds", permissionIds);
        roleMapper.deleteRolePermission(params);
    }

}
