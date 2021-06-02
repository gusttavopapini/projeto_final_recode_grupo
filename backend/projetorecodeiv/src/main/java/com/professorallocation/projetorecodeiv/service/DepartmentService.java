package com.professorallocation.projetorecodeiv.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.professorallocation.projetorecodeiv.entity.Department;
import com.professorallocation.projetorecodeiv.repository.DepartmentRepository;

@Service
public class DepartmentService {

private DepartmentRepository departmentRepository;
	
	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	
	public Department create(Department department) throws DataIntegrityViolationException {
		department.setId(null);
		return save(department);
	}
	
	
	public Department update(Department department) throws DataIntegrityViolationException {
		if(departmentRepository.existsById(department.getId())) {
			return save(department);
		}else {
			return null;
		}
	}
	
	
	public List<Department> findAll(String name) {
		if(name == null) {
			return departmentRepository.findAll();
		}else {
			return departmentRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	
	public Department findById(Long departmentId) {
		return departmentRepository.findById(departmentId).orElse(null);
	}
	
	
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}
	
	
	public void deleteById(Long departmentId) {
		if(departmentId != null && departmentRepository.existsById(departmentId)) {
			departmentRepository.deleteById(departmentId);
		}		
	}
	
	
	private Department save(Department department) throws DataIntegrityViolationException {
			return departmentRepository.save(department);
	}
}
