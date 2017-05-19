package com.iflytek.bbs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.iflytek.bbs.po.News;
import com.iflytek.bbs.po.User;
import com.iflytek.bbs.util.HibernateUtil;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.QEncoderStream;

public class TestHibernateMethod {

	private  SessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Test
	public void save() {
		User u = new User();
		u.setEmail("123@163.com");
		u.setName("kawen");
		u.setPassword("1111");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.save(u);
		
		session.getTransaction().commit();
	}
	@Test
	public void update() {
		User u = new User();
		u.setId(49);
		u.setEmail("123@163.com");
		u.setName("kawen");
		u.setPassword("1111");
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.update(u);
		
		session.getTransaction().commit();
	}
	@Test
	public void update2(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User u = (User)session.get(User.class, 49);
		
		u.setPassword("1212");
		
		session.update(u);
		
		session.getTransaction().commit();
	}
	@Test
	public void update3(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("update User u set u.password = :password where u.id = :userid");
		query.setParameter("password", "1234");
		query.setParameter("userid", 50);
		
		query.executeUpdate();
		
		session.getTransaction().commit();
	}
	@Test
	public void get(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User u = (User)session.get(User.class, 49);
		System.out.println(u.getName());
		session.getTransaction().commit();
	}
	@Test
	public void load(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//load默认延迟加载,放你访问的时候才会真正地去访问数据库
		User u = (User) session.load(User.class, 49);
		System.out.println(u.getPassword());
		session.getTransaction().commit();
	}
	@Test
	public void delete(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		User u = new User();
		u.setId(49);
		session.delete(u);
		session.getTransaction().commit();
	}
	@Test
	public void delete1(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("delete from User u where u.id = :userid");
		query.setParameter("userid", 48);
		query.executeUpdate();
		
		session.getTransaction().commit();
	}
	@Test
	public void delete2(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//级联删除,前提是先获取对象
		User u = (User) session.get(User.class,47);
		session.delete(u);
		
		session.getTransaction().commit();
	}
	@Test
	public void query1(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//HQL
		Query query = session.createQuery("from User");
		List<User> list = (List<User>)query.list();
		
		session.getTransaction().commit();
		for(User u : list){
			System.out.println(u.getName());
			System.out.println(u.getNewses().size());
		}
	}
	@Test
	public void query2(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from News");
		List<News> list = (List<News>)query.list();
		session.getTransaction().commit();
		for(News n : list){
			System.out.println(n.getTitle());
			
		}
	}
	@Test
	public void query3(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User u where u.email = :email and u.password = :password");
		
		query.setParameter("email", "123@163.com");
		query.setParameter("password", "1111");
		
		List<User> list = (List<User>)query.list();
		
		session.getTransaction().commit();
		
		if(list != null &&list.size()>0){
			System.out.println(list.get(0).getName());
		}
		
	}
	@Test
	public void query4(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from News n where n.user.id = :userId order by n.browserCount desc");
		
		query.setParameter("userId",8);
		
		List<News> list = (List<News>)query.list();
		
		session.getTransaction().commit();
		
		for(News u : list){
			System.out.println(u.getTitle());
		}
		
	}
	@Test
	public void query5(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from News n where n.user.id = :userId order by n.browserCount desc");
		
		query.setParameter("userId", 8);
		
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		List <News> list = (List<News>)query.list();
		
		session.getTransaction().commit();
		
		for(News u : list){
			System.out.println(u.getTitle());
		}
		
	}
	@Test
	public void query6(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select count(*) from News");
		
		Long row = (Long)query.uniqueResult();
		
		session.getTransaction().commit();
		
		System.out.println(row);
	}
	@Test
	public void query7(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from News n where n.user is null");
		
		session.getTransaction().commit();
	}
	@Test
	public void query8(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User u where u.newses is empty");
		
		session.getTransaction().commit();
	}
	@Test
	public void query9(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from News n where n.title like :title");
		query.setParameter("title", "%啦%");
		List<News> list = (List<News>)query.list();
		
		session.getTransaction().commit();
		for(News n : list){
			System.out.println(n.getTitle());
		}
	}
	@Test
	public void query10(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select name,password from User");
		List<Object[]> list = (List<Object[]>)query.list();
		
		for(Object[] arr : list){
			System.out.println(arr[0]+"\t"+arr[1]);
		}
		session.getTransaction().commit();
	}
	@Test
	public void query11(){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select n.user.name,count(*) from News n group by n.user.id");
		List<Object[]> list =(List<Object[]>)query.list();
		
		for(Object[] arr:list){
			System.out.println(arr[0] + "\t"+arr[1]);
		}
		session.getTransaction().commit();
	}
	@Test
	public void query12(){
		//一级缓存(Session级别)
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		News u1 = (News) session.get(News.class, 2);
		News u2 = (News) session.get(News.class, 2);
		
		session.getTransaction().commit();
	}
	
	@Test
	public void query13(){
		//二级缓存
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		User u1 = (User) session.get(User.class, 2);
		session.getTransaction().commit();
		
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		User u2 = (User) session.get(User.class, 2);
		session2.getTransaction().commit();
		
	
	}
	@Test
	public void query14(){
		//查询缓存
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("from User");
		query.setCacheable(true);
		query.list();
		session.getTransaction().commit();
		
		Session session2 = sessionFactory.getCurrentSession();
		session2.beginTransaction();
		Query query2 = session2.createQuery("from User");
		query2.setCacheable(true);
		query2.list();
		session2.getTransaction().commit();
	}

}
