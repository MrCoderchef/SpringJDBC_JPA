package com.alok.springboot.learnJPAandHibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alok.springboot.learnJPAandHibernate.course.Course;

@Repository
public class CourseJDBCRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String INSERT_QUERY = """
			                                 insert into course (id, name, author)
                                             values (?, ?, ?);
			                                                                       """ ;
	
	private static String DELETE_QUERY = """
										   DELETE FROM COURSE WHERE ID = ?
										                                   """;
	
	private static String SELECT_QUERY = """  
			                                  SELECT * FROM COURSE WHERE ID = ? 
																				""";
	public void insert(Course course) {
		jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	}
	public void deleteById(long id) {
		jdbcTemplate.update(DELETE_QUERY,id);
	}
	public Course findById(long id) {
		return jdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class),id);
	}
	
}
