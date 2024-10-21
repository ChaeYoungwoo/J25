package com.pcwk.ehr.ed02;

public class User {

	private String name; // 이름
	private int age; // 나이
	private boolean isActive;

	public User() {
		super();

	}

	public User(String name, int age, boolean isActive) {
		super();
		this.name = name;
		this.age = age;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", isActive=" + isActive + "]";
	}

}
