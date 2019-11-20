package com.iris.models;

public class ProjectAllocation {
	
	private int AllocId;
	Developer DevId;
	Configuration ConfigId;
	public int getAllocId() {
		return AllocId;
	}
	public void setAllocId(int allocId) {
		AllocId = allocId;
	}
	public Developer getDevId() {
		return DevId;
	}
	public void setDevId(Developer devId) {
		DevId = devId;
	}
	public Configuration getConfigId() {
		return ConfigId;
	}
	public void setConfigId(Configuration configId) {
		ConfigId = configId;
	}
	
	
	
	

}
