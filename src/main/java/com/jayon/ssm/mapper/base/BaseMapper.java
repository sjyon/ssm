package com.jayon.ssm.mapper.base;

import java.util.List;


public interface BaseMapper <T>{
	public void add(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public List<T> query(T t);
}
