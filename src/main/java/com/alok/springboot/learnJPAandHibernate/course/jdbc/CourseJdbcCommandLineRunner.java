package com.alok.springboot.learnJPAandHibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alok.springboot.learnJPAandHibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
	
	@Autowired
	private CourseJDBCRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1,"learn AWS now", "in.28Minuts"));
		repository.insert(new Course(2,"learn Trading", "alok.stockMarket"));
		repository.insert(new Course(3,"learn Investing", "alok.stockMarket"));
		repository.insert(new Course(4,"learn Full Stack Development", "in.takeUForword"));
		repository.deleteById(3);
		System.out.println(repository.findById(1));
		System.out.println(repository.findById(4));
	}
	
	
}
