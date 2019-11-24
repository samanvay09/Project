package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Attendance")
public class Attendance {
    @Id
    @GeneratedValue
    @Column(name="AttendId")
	private int attendId;
    @Column(name="Month")
	private String month;
    @Column(name="Year")
	private int year;
    @Column(name="HalfDay")
	private int halfDay;
    @Column(name="fullDay")
	private int fullDay;
    
    @OneToOne
    @JoinColumn(name="ProjectId")
	
    Projects projectId;
    
    @OneToOne
    @JoinColumn(name="DevId")
	Developer devId;
	
    public int getAttendId() {
		return attendId;
	}
	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHalfDay() {
		return halfDay;
	}
	public void setHalfDay(int halfDay) {
		this.halfDay = halfDay;
	}
	public int getFullDay() {
		return fullDay;
	}
	public void setFullDay(int fullDay) {
		this.fullDay = fullDay;
	}
	public Projects getProjectId() {
		return projectId;
	}
	public void setProjectId(Projects projectId) {
		this.projectId = projectId;
	}
	public Developer getDevId() {
		return devId;
	}
	public void setDevId(Developer devId) {
		this.devId = devId;
	}
	@Override
	public String toString() {
		return "Attendance [attendId=" + attendId + ", month=" + month + ", year=" + year + ", halfDay=" + halfDay
				+ ", fullDay=" + fullDay + ", projectId=" + projectId + ", devId=" + devId + "]";
	}
	
    
	
	
}
