package com.iflytek.bbs.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.iflytek.bbs.po.News;
import com.iflytek.bbs.service.NewsService;

public class TestNewsServiceImpl {
	private NewsService ns = new NewsServiceImpl();
	@Test
	public void getNewsById() {
		News n = ns.getNewsById(1);
		System.out.println(n.getTitle());
		assertNotEquals(null, n);
	}
	@Test
	public void add(){
		News n = new News();
		n.setTitle("震惊!!");
		n.setContent("他看到老奶奶过马路居然这样做!");
		n.setPublishDate(new Date());
		n.setBrowserCount(20);
	//	n.setUserId(8);
		
		ns.add(n);
	}
	@Test
	public void update(){
		News n = new News();
		
		n.setTitle("震惊!!");
		n.setContent("他好好学习为的居然是..");
		n.setPublishDate(new Date());
		n.setBrowserCount(5);
		//n.setUserId(6);
		n.setId(2);
		
		ns.update(n);
	}
	@Test
	public void getNewsPageList(){
		List<News> list = new ArrayList<News>();
		list = ns.getNewsPageList(1, 2);
		assertNotEquals(null, list);
	}
	@Test
	public void getTotalPage(){
		int i = ns.getTotalPage(2);
		assertEquals(3, i);
	}
	@Test
	public void delete(){
		ns.delete(1);
	}
	@Test
	public void getMyNewsPageList(){
		List<News> list = new ArrayList<News>();
		list = ns.getMyNewsPageList(5,"震惊!!", 1, 2);
		assertNotEquals(null, list);
	}
	@Test
	public void getMyTotalPage(){
		int i = ns.getMyTotalPage(8, "震惊!!", 2);
		assertEquals(2, i);
		}
}
