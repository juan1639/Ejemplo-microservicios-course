package com.microservice.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private StudentClient studentClient;

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

	@Override
	public StudentsByCourseResponse findStudentsByIdCourse(Long idCourse) {
		//	CONSULTAR EL COURSE
		Course course = courseRepo.findById(idCourse).orElse(new Course());
		
		//	OBTENER LOS ESTUDIANTES
		List<StudentDTO> studentDtoList = studentClient.findAllStudentsByCourse(idCourse);
		
		return StudentsByCourseResponse.builder()
				.courseName(course.getName())
				.teacher(course.getTeacher())
				.studentDtoList(studentDtoList)
				.build();
	}
}
