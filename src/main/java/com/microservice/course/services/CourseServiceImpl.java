package com.microservice.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.entities.Course;
import com.microservice.course.persistence.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public List<Course> findAll() {
		return (List<Course>) courseRepo.findAll();
	}

	@Override
	public Course findById(Long id) {
		return courseRepo.findById(id).orElseThrow();
	}

	@Override
	public void save(Course course) {
		courseRepo.save(course);
	}
}
