package com.jayon.ssm.service;

import com.jayon.ssm.pojo.PermissionDO;

public interface PermissionService {
    public PermissionDO createPermission(PermissionDO permission);
    public void deletePermission(int permissionId);
}
