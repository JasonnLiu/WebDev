package com.jason.weixindev.service.impl.attendance;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jason.weixindev.entity.attendance.Record;
import com.jason.weixindev.model.inface.attendance.AttendanceDAO;
import com.jason.weixindev.service.inface.attendance.AttendanceService;

@Service(value = "attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	
	private static Logger log = LoggerFactory.getLogger(AttendanceServiceImpl.class);

	
	@Resource(name = "attendanceDAO")
	private AttendanceDAO attendanceDAO;


	@Override
	public boolean record(Record r) {
		return attendanceDAO.record(r);
	}

	@Override
	public String getStdId(String id) {
		return attendanceDAO.getStdId(id);
	}

}
