package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Developers")
public class Developer {
	
	@Id
   
    @Column(name="DevId")	
	private int devId;
	 @Column(name="DevName")
	private String devName;
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	@Override
	public String toString() {
		return "Developer [devId=" + devId + ", devName=" + devName + "]";
	}
	 
	 
	
	
	
	
	

}
