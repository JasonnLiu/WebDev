package com.jason.weixindev.service.inface.attendance;

import java.util.List;

import com.jason.weixindev.entity.attendance.Record;

public interface AttendanceService {
	
	public boolean record(Record r);

	public String getStdId(String id);

	public List<Record> getRecordDetail(String date);

	public String getUsernameByStdId(String stdId);

}
