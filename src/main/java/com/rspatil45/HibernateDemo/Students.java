package com.rspatil45.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Students {
	@Id
	int rollno;
	int marks;
	String name;
//	@OneToOne
//	private Laptop laptop;
//	public Laptop getLaptop() {
//		return laptop;
//	}
//	public void setLaptop(Laptop laptop) {
//		this.laptop = laptop;
//	}
	
//	@OneToMany(mappedBy = "student")  //mapped by student variable (inside Laptop POJO)
//	List<Laptop> laptop = new ArrayList<>();
	
	@ManyToMany(mappedBy = "student")
	List<Laptop> laptop = new ArrayList<>();
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Students [rollno=" + rollno + ", marks=" + marks + ", name=" + name + "]";
	}
	
}
