package com.iflytek.bbs.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iflytek.bbs.po.Reply;

public class TestReplyDao {
	private static SqlSession session;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		
		session = sessionFactory.openSession();
	}

	@Test
	public void testAdd() {
		ReplyDao dao = session.getMapper(ReplyDao.class);
		
		Reply r = new Reply();
		r.setReplyDate(new Date());
		r.setContent("哈哈哈");
	//	r.setUserId(8);
	//	r.setNewsId(35);
		
		dao.add(r);
		
		session.commit();
		
	}
	@Test
	public void testGetReplyListByNewsId(){
		ReplyDao dao = session.getMapper(ReplyDao.class);
		List<Reply> list = dao.getReplyListByNewsId(35);
		for(Reply reply : list){
			System.out.println(reply.getId());
		}
	}
	@Test
	public void testDelete(){
		ReplyDao dao = session.getMapper(ReplyDao.class);
		dao.delete(30);
		session.commit();
	}
	@Test
	public void testDeleteReply(){
		ReplyDao dao = session.getMapper(ReplyDao.class);
		dao.deleteReply(14);
		session.commit();
	}

}
