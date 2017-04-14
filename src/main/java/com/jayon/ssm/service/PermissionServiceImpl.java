package com.jayon.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayon.ssm.mapper.PermissionMapper;
import com.jayon.ssm.pojo.PermissionDO;
@Service
public class PermissionServiceImpl implements PermissionService {
	@Autowired
    private PermissionMapper permissionMapper;

    public PermissionDO createPermission(PermissionDO permission) {
    	permissionMapper.add(permission);
        return permission;
    }

    public void deletePermission(int permissionId) {
    	PermissionDO permission = new PermissionDO();
    	permission.setId(permissionId);
        permissionMapper.delete(permission);
    }
}
