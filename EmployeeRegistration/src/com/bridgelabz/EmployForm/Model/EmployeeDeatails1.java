package com.bridgelabz.EmployForm.Model;

import java.sql.ResultSet;

public class EmployeeDeatails1
{
	int id;
	String employeeName;
	String password;
	String gender;
	String emailId;
	String address;
	String specialized;
	String language;
	long contactNo;
	int age;
	float salary;
	
	
	public EmployeeDeatails1() {
	
	
	}
	public EmployeeDeatails1(ResultSet resultSet) {
		
		this.id = id;
		this.employeeName = employeeName;
		this.password = password;
		this.gender = gender;
		this.emailId = emailId;
		this.address = address;
		this.specialized = specialized;
		this.language = language;
		this.contactNo = contactNo;
		this.age = age;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpecialized() {
		return specialized;
	}
	public void setSpecialized(String specialized) {
		this.specialized = specialized;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
