package com.ksshlee.study;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * DataSourceTest
 * @Test
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)


public class testDataSource {

	@Inject
	private DataSource dataSource;
	
	
	@Test
	public void testConnection() throws Exception {
		try(Connection conn = dataSource.getConnection()){
			System.out.println(conn);
			System.out.println("kyakya");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
