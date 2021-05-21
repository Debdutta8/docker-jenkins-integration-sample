package com.example.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Alien {
@Id
@Column
private int aid;
@Column
private String aname;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
@Override
public String toString() {
	return "Alien [aid=" + aid + ", aname=" + aname + "]";
}


}
