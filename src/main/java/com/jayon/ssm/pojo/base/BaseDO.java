package com.jayon.ssm.pojo.base;


import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public abstract class BaseDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
