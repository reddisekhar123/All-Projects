package com.service;

public class HelloWorld {

	private IBean ib;
	public void setIb(IBean ib) {
		this.ib=ib;
	}
	public String toString() {
		return "HelloWorld!\n"+ib;
	}
}
