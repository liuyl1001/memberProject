package cn.mldn.vo;

import java.util.Date;

public class Member {
	private String mid;
	private String name;
	private Date birthday;
	private Double salary;
	private String note;
	private int del;
	public void setMid(String mid) {
		this.mid = mid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public String getMid() {
		return mid;
	}
	public String getName() {
		return name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public Double getSalary() {
		return salary;
	}
	public String getNote() {
		return note;
	}
	public int getDel() {
		return del;
	}
}
