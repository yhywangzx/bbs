package com.iflytek.bbs.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.iflytek.bbs.po.Reply;
import com.iflytek.bbs.service.ReplyService;

public class TestReplyServiceImpl {
	private ReplyService rs = new ReplyServiceImpl();
	@Test
	public void getReplyListByNewsId() {
		List<Reply> list = new ArrayList<Reply>();
		list = rs.getReplyListByNewsId(5);
		assertNotEquals(null, list);
	}
	@Test
	public void add(){
		Reply reply = new Reply();
		reply.setReplyDate(new Date());
		reply.setContent("震惊!深夜她居然和鹿晗发生这样的关系");
	//	reply.setUserId(5);
	//	reply.setNewsId(1);
		
		rs.add(reply);
		
	}

}
