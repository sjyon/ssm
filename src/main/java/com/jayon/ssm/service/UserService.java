package com.jayon.ssm.service;


import java.util.List;
import java.util.Set;

import com.jayon.ssm.pojo.UserDO;

public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public UserDO createUser(UserDO user);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Long userId, List<Integer> roleIds);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, List<Integer> roleIds);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public UserDO findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);

}
