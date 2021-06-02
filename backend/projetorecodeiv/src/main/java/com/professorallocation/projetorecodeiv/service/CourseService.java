package com.professorallocation.projetorecodeiv.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.professorallocation.projetorecodeiv.entity.Course;
import com.professorallocation.projetorecodeiv.repository.CourseRepository;

@Service
public class CourseService {

private CourseRepository courseRepository;
	
	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}
	
	
	public Course create(Course course) throws DataIntegrityViolationException {
		course.setId(null);
		return save(course);
	}
	
	
	public Course update(Course course) throws DataIntegrityViolationException {
		if(courseRepository.existsById(course.getId())) {
			return save(course);			
		}else {
			return null;
		}
	}
	
	
	public List<Course> findAll(String name) {
		if(name == null) {
			return courseRepository.findAll();
		}else {
		return courseRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	
	public Course findById(Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}	
	
	
	public void deleteAll() {
		courseRepository.deleteAllInBatch();
	}
	
	
	public void deleteById(Long courseId) {
		if(courseId != null && courseRepository.existsById(courseId)) {
			courseRepository.deleteById(courseId);
		}
	}
	
	
	private Course save(Course course) throws DataIntegrityViolationException {
		return courseRepository.save(course);		
	}
}
