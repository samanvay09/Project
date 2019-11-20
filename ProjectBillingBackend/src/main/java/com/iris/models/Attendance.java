package com.iris.models;

public class Attendance {

	private int AttendId;
	private String Month;
	private int Year;
	private int HalfDay;
	private int fullDay;
	Projects ProjectId;
	Developer DevId;
	public int getAttendId() {
		return AttendId;
	}
	public void setAttendId(int attendId) {
		AttendId = attendId;
	}
	public String getMonth() {
		return Month;
	}
	public void setMonth(String month) {
		Month = month;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public int getHalfDay() {
		return HalfDay;
	}
	public void setHalfDay(int halfDay) {
		HalfDay = halfDay;
	}
	public int getFullDay() {
		return fullDay;
	}
	public void setFullDay(int fullDay) {
		this.fullDay = fullDay;
	}
	public Projects getProjectId() {
		return ProjectId;
	}
	public void setProjectId(Projects projectId) {
		ProjectId = projectId;
	}
	public Developer getDevId() {
		return DevId;
	}
	public void setDevId(Developer devId) {
		DevId = devId;
	}
	
	
	
}
