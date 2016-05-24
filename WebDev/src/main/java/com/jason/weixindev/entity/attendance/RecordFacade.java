package com.jason.weixindev.entity.attendance;

import java.sql.Timestamp;

public class RecordFacade {
	private String stdId;
	private Timestamp attenTime;
	public String getStdId() {
		return stdId;
	}
	public void setStdId(String stdId) {
		this.stdId = stdId;
	}
	public Timestamp getAttenTime() {
		return attenTime;
	}
	public void setAttenTime(Timestamp attenTime) {
		this.attenTime = attenTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
}
