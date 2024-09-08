package com.microservice.course.services;

import java.util.List;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;

public interface ICourseService {
	
	List<Course> findAll();
	Course findById(Long id);
	void save(Course course);
	StudentsByCourseResponse findStudentsByIdCourse(Long idCourse);
}
