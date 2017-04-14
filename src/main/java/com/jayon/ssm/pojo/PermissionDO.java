package com.jayon.ssm.pojo;

import com.jayon.ssm.pojo.base.BaseDO;

public class PermissionDO extends BaseDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3153988601196874891L;
	private int id;
	private String permission;
	private String description;
	private Boolean available = Boolean.FALSE;
	
	public PermissionDO() {
		super();
	}
	public PermissionDO(String permission, String description, Boolean available) {
		this.permission = permission;
		this.description = description;
		this.available = available;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
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
