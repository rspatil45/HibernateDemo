package com.rspatil45.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	int lid;
	String lname;
//	@ManyToOne
//	Students student;
	@ManyToMany
	List<Students> student = new ArrayList<Students>();
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public List<Students> getStudent() {
		return student;
	}
	public void setStudent(List<Students> student) {
		this.student = student;
	}
	//	public Students getStudent() {
//		return student;
//	}
//	public void setStudent(Students student) {
//		this.student = student;
//	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", lname=" + lname + "]";
	}
	

}
