package com.jason.weixindev.model.inface.attendance;

import java.util.List;

import com.jason.weixindev.entity.attendance.Record;

public interface AttendanceDAO {

	String getStdId(String id);

	boolean record(Record r);

	List<Record> getRecordDetail(String date);

	String getUsernameByStdId(String stdId);

}
