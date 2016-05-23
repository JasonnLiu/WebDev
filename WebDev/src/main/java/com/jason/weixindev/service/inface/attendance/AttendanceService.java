package com.jason.weixindev.service.inface.attendance;

import com.jason.weixindev.entity.attendance.Record;

public interface AttendanceService {
	
	public boolean record(Record r);

	public String getStdId(String id);

}
