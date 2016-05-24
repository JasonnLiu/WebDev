package com.jason.weixindev.controller.attendance;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.weixindev.entity.attendance.Record;
import com.jason.weixindev.entity.attendance.RecordFacade;
import com.jason.weixindev.message.resp.Article;
import com.jason.weixindev.message.resp.NewsMessage;
import com.jason.weixindev.message.resp.TextMessage;
import com.jason.weixindev.service.inface.attendance.AttendanceService;
import com.jason.weixindev.util.MessageUtil;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	private static Logger log = LoggerFactory
			.getLogger(AttendanceController.class);

	@Resource(name = "attendanceService")
	private AttendanceService attendanceService;

	@RequestMapping("/begin")
	public void atten(HttpServletRequest req, HttpServletResponse resp) {
		Map map = (Map) req.getAttribute("map");
		String id = (String) map.get("FromUserName");
		String Location_X = (String) map.get("Location_X");
		String Location_Y = (String) map.get("Location_Y");
		String CreateTime = (String) map.get("CreateTime");
		String stdId = attendanceService.getStdId(id);

		Record r = new Record();
		r.setCreateTime(CreateTime);
		r.setLocation_X(Location_X);
		r.setLocation_Y(Location_Y);
		r.setStdId(stdId);
		r.setAttenTime(new Timestamp(System.currentTimeMillis()));

		String respContent;

		if (attendanceService.record(r)) {
			respContent = "签到成功";
		} else {
			respContent = "签到失败";
		}

		String respXml = null;

		TextMessage tm = new TextMessage();
		tm.setFromUserName((String) map.get("ToUserName"));
		tm.setToUserName((String) map.get("FromUserName"));
		tm.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		tm.setCreateTime(new Date().getTime());
		tm.setContent(respContent);
		respXml = MessageUtil.message2xml(tm);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(respXml);
		out.close();
		out = null;

	}

	@RequestMapping("/end")
	public void attEnd(HttpServletRequest req, HttpServletResponse resp) {
		Map map = (Map) req.getAttribute("map");
		NewsMessage nm = new NewsMessage();
		nm.setFromUserName((String) map.get("ToUserName"));
		nm.setToUserName((String) map.get("FromUserName"));
		nm.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		nm.setCreateTime(new Date().getTime());
		Article a = new Article();
		a.setTitle("签到情况");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		String url = "http://115.29.141.152/WebDev/attendance/detail/" + date;
		a.setUrl(url);
		List<Article> list = new ArrayList<Article>();
		list.add(a);
		nm.setArticleCount(1);
		nm.setArticles(list);
		String respXml;
		respXml = MessageUtil.message2xml(nm);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(respXml);
		out.close();
		out = null;
	}

	@RequestMapping("/detail/{date}")
	public String detail(@PathVariable String date, Map<String, Object> model) {
		log.info(date);
		List<Record> list = attendanceService.getRecordDetail(date);
		int size = list.size();
		int total = 26;
		int quexi = total - size;
		log.info(size + "");
		model.put("total", total);
		model.put("atten", size);
		model.put("quexi", quexi);
		List<RecordFacade> list1 = new ArrayList<RecordFacade>();
		for (Record r : list) {
			RecordFacade rf = new RecordFacade();
			rf.setStdId(r.getStdId());
			rf.setAttenTime(r.getAttenTime());
			rf.setUsername(attendanceService.getUsernameByStdId(r.getStdId()));
			list1.add(rf);
		}

		model.put("records", list1);
		return "attendance_detail";
	}

	@RequestMapping("/test/detail/{date}")
	public String detailtest(@PathVariable String date,
			Map<String, Object> model) {
		Date time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			time = sdf.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log.info(date);
		List<Record> list = attendanceService.getRecordDetail(date);
		int size = list.size();
		int total = 26;
		int quexi = total - size;
		log.info(size + "");
		model.put("total", total);
		model.put("atten", size);
		model.put("quexi", quexi);
		List<RecordFacade> list1 = new ArrayList<RecordFacade>();
		for (Record r : list) {
			RecordFacade rf = new RecordFacade();
			rf.setStdId(r.getStdId());
			rf.setAttenTime(r.getAttenTime());
			rf.setUsername(attendanceService.getUsernameByStdId(r.getStdId()));
			list1.add(rf);
		}

		model.put("records", list1);
		return "attendance_detail";
	}

	@RequestMapping("/test")
	public void test(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String stdId = attendanceService.getStdId(id);
		String Location_X = (String) req.getParameter("Location_X");
		String Location_Y = (String) req.getParameter("Location_Y");
		String CreateTime = (String) req.getParameter("CreateTime");
		Record r = new Record();
		r.setCreateTime(CreateTime);
		r.setLocation_X(Location_X);
		r.setLocation_Y(Location_Y);
		r.setStdId(stdId);
		r.setAttenTime(new Timestamp(System.currentTimeMillis()));
		attendanceService.record(r);
		try {
			resp.getWriter().print(attendanceService.record(r));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
