package com.rspatil45.HibernateDemo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name="Alien")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) //strategy decides where to use cache, by default its None, here read_only means only while reading  
public class Alien {  	
	@Id
	private int aid;
	private AlienName aname;
	private String color;
	@Transient //basically we are ignoring below column in table
	private String other;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", name=" + aname + ", color=" + color + ", other=" + other + "]";
	}
	
	
}
