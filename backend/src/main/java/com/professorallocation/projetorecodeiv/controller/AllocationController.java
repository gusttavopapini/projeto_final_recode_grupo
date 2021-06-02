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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.professorallocation.projetorecodeiv.entity.Allocation;
import com.professorallocation.projetorecodeiv.service.AllocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = {"Allocations"})
@RestController
@RequestMapping(path = "/allocations", produces = MediaType.APPLICATION_JSON_VALUE)
public class AllocationController {

	private AllocationService allocationService;
	
	public AllocationController(AllocationService allocationService) {
		this.allocationService = allocationService;
	}
	
	@ApiOperation(value = "Create allocation")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Allocation successfully created!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
	})
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Allocation> create(@RequestBody Allocation allocation) {
		try {
			Allocation allocation2 = allocationService.create(allocation);
			return new ResponseEntity<>(allocation2, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}
	}
	
	@ApiOperation(value = "Update allocation")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Allocation successfully updated!"),
		@ApiResponse(code = 400, message = "Wrong data inserted!"),
		@ApiResponse(code = 404, message = "Allocation not found!")
	})
	@PutMapping(path = "/{allocation_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Allocation> update(@PathVariable(name = "allocation_id") Long allocationId,
											 @RequestBody Allocation allocation) {
		allocation.setId(allocationId);
		try {
			Allocation allocation2 = allocationService.update(allocation);
			if(allocation2 == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<>(allocation2, HttpStatus.OK);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
		}		
	}

	@ApiOperation(value = "Find allocations")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Allocation(s) found!")
	})
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Allocation>> findAll() {
		List<Allocation> allocations = allocationService.findAll();
		return new ResponseEntity<> (allocations, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find allocation by ID")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Allocation found!"),
		@ApiResponse(code = 404, message = "Allocation not found!")
	})
	@GetMapping(path = "/{allocation_id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Allocation> findById(@PathVariable(name = "allocation_id") Long allocationId) {
		Allocation allocation = allocationService.findById(allocationId);
		if(allocation == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(allocation, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Delete allocation by ID")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Allocation successfully deleted!")
	})
	@DeleteMapping(path = "/{allocation_id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteById(@PathVariable (name = "allocation_id") Long allocationId) {
		allocationService.deleteById(allocationId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "Delete all allocations")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Allocations successfully deleted!")
	})
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> deleteAll() {
		allocationService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
