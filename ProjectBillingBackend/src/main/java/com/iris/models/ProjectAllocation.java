package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Allocation")
public class ProjectAllocation {
	
	@Id
    @GeneratedValue
    @Column(name="AllocId")
	private int allocId;
	 @OneToOne
	    @JoinColumn(name="DevId")
	Developer devId;
	 @OneToOne
	    @JoinColumn(name="ConfigId")
	Configuration configId;
	public int getAllocId() {
		return allocId;
	}
	public void setAllocId(int allocId) {
		this.allocId = allocId;
	}
	public Developer getDevId() {
		return devId;
	}
	public void setDevId(Developer devId) {
		this.devId = devId;
	}
	public Configuration getConfigId() {
		return configId;
	}
	public void setConfigId(Configuration configId) {
		this.configId = configId;
	}
	@Override
	public String toString() {
		return "ProjectAllocation [allocId=" + allocId + ", devId=" + devId + ", configId=" + configId + "]";
	}
	 
	
	
	
	

}
