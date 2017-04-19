package com.jayon.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayon.ssm.mapper.UserMapper;
import com.jayon.ssm.pojo.UserDO;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserMapper userMapper;
	@Autowired
    private PasswordHelper passwordHelper;

    public void setPasswordHelper(PasswordHelper passwordHelper) {
        this.passwordHelper = passwordHelper;
    }

    /**
     * 创建用户
     * @param user
     */
    public UserDO createUser(UserDO user) {
        passwordHelper.encryptPassword(user);
        userMapper.add(user);
        return user;
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
        UserDO user = new UserDO();
        user.setId(userId);
        List<UserDO> list = userMapper.query(user);
        user = list.get(0);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.update(user);
    }

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void correlationRoles(Long userId, List<Integer> roleIds) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("userId", userId);
    	params.put("roleIds", roleIds);
        userMapper.addUserRoles(params);
    }


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     */
    public void uncorrelationRoles(Long userId, List<Integer> roleIds) {
    	Map<String, Object> params = new HashMap<>();
    	params.put("userId", userId);
    	params.put("roleIds", roleIds);
        userMapper.deleteUserRoles(params);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public UserDO findByUsername(String username) {
    	UserDO user = new UserDO();
    	user.setUserName(username);
    	List<UserDO> users = userMapper.query(user);
        return users.size() > 0 ? users.get(0) : null;
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
    	UserDO user = new UserDO();
    	user.setUserName(username);
        return userMapper.queryRoles(user);
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
    	UserDO user = new UserDO();
    	user.setUserName(username);
        return userMapper.queryPermissioins(user);
    }

}
