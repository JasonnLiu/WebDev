package com.jason.weixindev.model.mybatis.attendance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jason.weixindev.entity.attendance.Record;
import com.jason.weixindev.model.inface.attendance.AttendanceDAO;
import com.jason.weixindev.model.mybatis.BaseMyBatisDAO;
import com.jason.weixindev.service.impl.attendance.AttendanceServiceImpl;

@Repository(value = "attendanceDAO")
public class AttendanceDAOImpl extends BaseMyBatisDAO implements AttendanceDAO {

	private static Logger log = LoggerFactory
			.getLogger(AttendanceDAOImpl.class);

	@Override
	public String getStdId(String id) {
		String stdId = null;
		SqlSession s = getSqlSession();
		stdId = s.selectOne(
				"com.jason.weixindev.model.mybatis.attendance.getStdId", id);

		return stdId;
	}

	@Override
	public boolean record(Record r) {
		SqlSession s = getSqlSession();
		int i = s.insert(
				"com.jason.weixindev.model.mybatis.attendance.addRecord", r);
		if (i == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Record> getRecordDetail(String date) {
		SqlSession s = getSqlSession();
		List<Record> l = s.selectList(
				"com.jason.weixindev.model.mybatis.attendance.getRecordDetail",
				date);
		return l;
	}

	@Override
	public String getUsernameByStdId(String stdId) {
		String username = null;
		SqlSession s = getSqlSession();
		username = s.selectOne(
				"com.jason.weixindev.model.mybatis.attendance.getUsernameByStdId", stdId);

		return username;
	}

}
