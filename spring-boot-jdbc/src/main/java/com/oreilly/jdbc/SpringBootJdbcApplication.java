package com.oreilly.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootJdbcApplication {

	@Autowired
	JdbcTemplate template;

	@RequestMapping("/stocks")
	public List<Map<String, Object>> stocks(){
		return template.queryForList("select * from stock");
	}
	
	@RequestMapping("/loadsql")
	public String outputLoad() {
		return SpringBootJdbcApplication.class.getResource("/schema.sql").getFile();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

}