package com.microservice.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.course.entities.Course;
import com.microservice.course.services.ICourseService;

@RestController
@RequestMapping("api/course")
public class CourseController {
	
	@Autowired
	private ICourseService courseService;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllCourses() {
		
		return ResponseEntity.ok(courseService.findAll());
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(courseService.findById(id));
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void saveCourse(@RequestBody Course course) {
		
		courseService.save(course);	
	}
	
	@GetMapping("/search-students/{idCourse}")
	public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse) {
		
		return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
	}
}
