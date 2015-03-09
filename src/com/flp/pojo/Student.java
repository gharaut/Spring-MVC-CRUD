package com.flp.pojo;

public class Student {
	private String name;
	private String role;
	private int age;
	private Address addrStudent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Address getAddrStudent() {
		return addrStudent;
	}
	public void setAddrStudent(Address addrStudent) {
		this.addrStudent = addrStudent;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", role=" + role + ", age=" + age
				+ ", addrStudent=" + addrStudent + "]";
	}
	
}
