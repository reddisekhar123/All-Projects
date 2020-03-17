package com.service;

public class IBean {

	private String name;
	
	private String getName() {
		return name;
		
	}
	public void setName(String name) {
		this.name=name;
	}
	@Override
	public String toString() {
		return "I am"+name+"of inner bean";
		
	}
}
