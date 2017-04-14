package com.jayon.ssm.pojo;

import java.util.List;

import com.jayon.ssm.pojo.base.BaseDO;

public class UserDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8758926264892779471L;
	
	private long id;
	private String userName;
	private String password;
	private String salt;
	private Boolean locked = Boolean.FALSE;
	
	public UserDO() {
		super();
	}
	public UserDO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	private List<RoleDO> roles;
	
	public List<RoleDO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDO> roles) {
		this.roles = roles;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCredentialsSalt(){
		return userName + salt;
	}
}
