package com.rspatil45.HibernateDemo;

import javax.persistence.Embeddable;

@Embeddable   //will embed this object inside it create three below column in table instead aname column
public class AlienName {
	String fname;
	String mname;
	String lname;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "AlienName [fname=" + fname + ", mname=" + mname + ", lname=" + lname + "]";
	}
	
	

}
