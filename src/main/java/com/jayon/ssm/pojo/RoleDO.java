package com.jayon.ssm.pojo;

import java.util.List;

import com.jayon.ssm.pojo.base.BaseDO;

public class RoleDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7954136080448606956L;
	private int id;
	private String role;
	private String description;
	private Boolean available = Boolean.FALSE;
	
	private List<PermissionDO> permissions;
	
	public RoleDO() {
	}
	public RoleDO(String role, String description, Boolean available) {
		this.role = role;
		this.description = description;
		this.available = available;
	}
	public List<PermissionDO> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionDO> permissions) {
		this.permissions = permissions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
}
