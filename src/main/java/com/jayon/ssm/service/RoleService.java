package com.jayon.ssm.service;

import java.util.List;

import com.jayon.ssm.pojo.RoleDO;

public interface RoleService {

    public RoleDO createRole(RoleDO role);
    public void deleteRole(int roleId);
    public void correlationPermissions(int roleId, List<Integer> permissionIds);
    public void uncorrelationPermissions(int roleId, List<Integer> permissionIds);

}
