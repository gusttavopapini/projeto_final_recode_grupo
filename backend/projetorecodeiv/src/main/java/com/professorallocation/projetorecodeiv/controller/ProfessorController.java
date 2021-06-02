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

import com.professorallocation.projetorecodeiv.entity.Professor;
import com.professorallocation.projetorecodeiv.service.ProfessorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Professors"})
@RestController
@RequestMapping(path = "/professors", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProfessorController {

private ProfessorService professorService;
	
	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}
	
	@ApiOperation(value = "Create professor")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Professor successfully created!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Professor> create(@RequestBody Professor professor) {
		try {
			Professor professor2 = professorService.create(professor);
			return new ResponseEntity<>(professor2, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
	
	@ApiOperation(value = "Update professor")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Professor successfully updated!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
		@ApiResponse(code = 404, message = "Professor not found!")
	})
	@PutMapping(path = "/{professor_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Professor> update(@PathVariable(name = "professor_id") Long professorId,
											@RequestBody Professor professor) {
		professor.setId(professorId);
		try {
		Professor professor2 = professorService.update(professor);
			if(professor2 == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(professor2, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}		
	}

	@ApiOperation(value = "Find professors")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Professor(s) found!")
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Professor>> findAll(@RequestParam(name = "name", required = false) String name) {
		List<Professor> professors = professorService.findAll(name);
		return new ResponseEntity<> (professors, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find professor by ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Professor found!"),
		@ApiResponse(code = 404, message = "Professor not found!")
	})
	@GetMapping(path = "/{professor_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Professor> findById(@PathVariable(name = "professor_id") Long professorId) {
		Professor professor = professorService.findById(professorId);
		if(professor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(professor, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Delete professor by ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Professor successfully deleted!")
	})
	@DeleteMapping(path = "/{professor_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable (name = "professor_id") Long professorId) {
		professorService.deleteById(professorId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Delete all professors")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Professors successfully deleted!")
	})
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		professorService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
