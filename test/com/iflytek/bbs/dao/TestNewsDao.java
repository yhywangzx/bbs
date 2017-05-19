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

import com.iflytek.bbs.po.News;

public class TestNewsDao {
	private static SqlSession session;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//读取mybaties配置文件
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
				
		//打开session,后期用于获取接口对象
		session = sessionFactory.openSession();
	}

	@Test
	public void testAdd() {
		NewsDao dao = session.getMapper(NewsDao.class);
		
		News n = new News();
		n.setTitle("你狠皮");
		n.setContent("你皮任你皮");
		n.setPublishDate(new Date());
		n.setBrowserCount(11);
	//	n.setUserId(8);
		
		dao.add(n);
		
		session.commit();
	}
	@Test
	public void testUpdate(){
		NewsDao dao = session.getMapper(NewsDao.class);
		
		News n = new News();
		n.setTitle("奥特曼大战葫芦娃");
		n.setContent("奥特曼大战葫芦娃可真精彩");
		n.setPublishDate(new Date());
		n.setBrowserCount(88);
	//	n.setUserId(8);
		n.setId(35);
		
		dao.update(n);
		
		session.commit();
	}
	@Test
	public void testGetNewsById(){
		NewsDao dao = session.getMapper(NewsDao.class);
		
		News news = dao.getNewsById(35);
		
		System.out.println(news.getContent());
		
		assertNotEquals(news, null);
	}
	@Test
	public void testGetNewsPageList(){
		NewsDao dao = session.getMapper(NewsDao.class);

		int pageIndex = 1;
		int count = (pageIndex-1)*5;
		List<News> list = dao.getNewsPageList(count,5);
		for(News news : list){
			System.out.println(news.getId());
		}
		assertNotEquals(list, null);
		
	}
	@Test
	public void testGetTotalCount(){
		NewsDao dao = session.getMapper(NewsDao.class);
		
		int a = dao.getTotalCount();
		
		System.out.println(a);
		
		
	}
	@Test
	public void testGetMyNewsPageList(){
		NewsDao dao = session.getMapper(NewsDao.class);
		
		int pageIndex = 1;
		int count = (pageIndex-1)*5;
		
		
		List<News> newsList = dao.getMyNewsPageList(8, "你", count, 5);
		for(News news : newsList){
			System.out.println(news.getId());
		}
		assertNotEquals(newsList, null);
	}
	@Test
	public void testGetMyTotalCount(){
		NewsDao dao = session.getMapper(NewsDao.class);
		
		int count = dao.getMyTotalCount(8, "你");
		
		System.out.println(count);
	}

}
