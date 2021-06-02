package com.professorallocation.projetorecodeiv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.professorallocation.projetorecodeiv.entity.Course;
import com.professorallocation.projetorecodeiv.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Courses"})
@RestController
@RequestMapping(path = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

	private CourseService courseService;
	
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@ApiOperation(value = "Create course")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Course successfully created!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Course> create(@RequestBody Course course) {
		try {
			Course course2 = courseService.create(course);
			return new ResponseEntity<>(course2, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
	
	@ApiOperation(value = "Update course")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Course successfully updated!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
		@ApiResponse(code = 404, message = "Course not found!")
	})
	@PutMapping(path = "/{course_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> update(@PathVariable(name = "course_id") Long courseId,
											@RequestBody Course course) {
		course.setId(courseId);
		try {
			Course course2 = courseService.update(course);
			if(course2 == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(course2, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}		
	}

	@ApiOperation(value = "Find courses")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Course(s) found!")
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Course>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Course> courses = courseService.findAll(name);
		return new ResponseEntity<> (courses, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find course by ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Course found!"),
		@ApiResponse(code = 404, message = "Course not found!")
	})
	@GetMapping(path = "/{course_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Course> findById(@PathVariable(name = "course_id") Long courseId) {
		Course course = courseService.findById(courseId);
		if(course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Delete course by ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Course successfully deleted!")
	})
	@DeleteMapping(path = "/{course_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable (name = "course_id") Long courseId) {
		courseService.deleteById(courseId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Delete all departments")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Departments successfully deleted!")
	})
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		courseService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
