package com.smallcode.sample.springboot.jdbc;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import net.minidev.json.JSONUtil;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleSpringbootJdbcApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void testDataSourceInitializer(){
		try {
			System.out.println(dataSource.getConnection());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void jdbcTemplate(){
		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from b_article");

	}
}
