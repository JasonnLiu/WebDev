package com.jason.weixindev.entity.attendance;

import java.sql.Timestamp;

public class Record {
	
	private String stdId;
	private String CreateTime;
	private Timestamp attenTime;
	private String Location_X;
	private String Location_Y;
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public Timestamp getAttenTime() {
		return attenTime;
	}
	public void setAttenTime(Timestamp attenTime) {
		this.attenTime = attenTime;
	}
	public String getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}
	public String getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}
	
	

}
