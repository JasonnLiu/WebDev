package com.jason.weixindev.model.inface.attendance;

import com.jason.weixindev.entity.attendance.Record;

public interface AttendanceDAO {

	String getStdId(String id);

	boolean record(Record r);

}
