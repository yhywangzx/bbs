package com.iflytek.bbs.dao;

import static org.junit.Assert.*;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestHibernateConfig {


	@Test
	public void test() {
		new  SchemaExport(new Configuration().configure()).create(true, false);
	}

}
