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

import com.professorallocation.projetorecodeiv.entity.Department;
import com.professorallocation.projetorecodeiv.service.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Departments"})
@RestController
@RequestMapping(path = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

	private DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@ApiOperation(value = "Create department")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Department successfully created!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Department> create(@RequestBody Department department) {
		try {
			Department department2 = departmentService.create(department);
			return new ResponseEntity<>(department2, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
	
	@ApiOperation(value = "Update department")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Department successfully updated!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
		@ApiResponse(code = 404, message = "Department not found!")
	})
	@PutMapping(path = "/{department_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Department> update(@PathVariable(name = "department_id") Long departmentId,
											@RequestBody Department department) {
		department.setId(departmentId);
		try {
			Department department2 = departmentService.update(department);
			if(department2 == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(department2, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}		
	}

	@ApiOperation(value = "Find departments")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Department(s) found!")
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Department>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Department> departments = departmentService.findAll(name);
		return new ResponseEntity<> (departments, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find department by ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Department found!"),
		@ApiResponse(code = 404, message = "Department not found!")
	})
	@GetMapping(path = "/{department_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Department> findById(@PathVariable(name = "department_id") Long departmentId) {
		Department department = departmentService.findById(departmentId);
		if(department == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(department, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Delete department by ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Department successfully deleted!")
	})
	@DeleteMapping(path = "/{department_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable (name = "department_id") Long departmentId) {
		departmentService.deleteById(departmentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Delete all departments")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Departments successfully deleted!")
	})
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		departmentService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
