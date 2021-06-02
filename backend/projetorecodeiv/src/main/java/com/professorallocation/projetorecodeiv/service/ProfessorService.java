package com.professorallocation.projetorecodeiv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.professorallocation.projetorecodeiv.entity.Allocation;
import com.professorallocation.projetorecodeiv.entity.Department;
import com.professorallocation.projetorecodeiv.entity.Professor;
import com.professorallocation.projetorecodeiv.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private ProfessorRepository professorRepository;
	private DepartmentService departmentService;
	
	public ProfessorService(ProfessorRepository professorRepository, DepartmentService departmentService) {
		super();
		this.professorRepository = professorRepository;
		this.departmentService = departmentService;
	}
	
	
	public Professor create(Professor professor) throws DataIntegrityViolationException {
		professor.setId(null);
		return save(professor);
	}
	
	
	public Professor update(Professor professor) throws DataIntegrityViolationException {
		Long id = professor.getId();
		if(id == null) {
			return null;
		}
		if(!professorRepository.existsById(id)) {
			return null;
		} return save(professor);
	}
		
	
	public List<Professor> findAll(String name) {
		if(name == null) {
		return professorRepository.findAll();
		}else {
			return professorRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	
	public Professor findById(Long professorId) {
		return professorRepository.findById(professorId).orElse(null);
	}
	
	
	public void deleteAll() {
		professorRepository.deleteAllInBatch();
	}
	
	
	public void deleteById(Long professorId) {
		if(professorId != null && professorRepository.existsById(professorId)) {
			professorRepository.deleteById(professorId);
		}
	}
	
	
	private Professor save(Professor professor) throws DataIntegrityViolationException {
		professor = professorRepository.save(professor);
		Department d = professor.getDepartment();
		d = departmentService.findById(d.getId());
		professor.setDepartment(d);
		professor.setAllocations(new ArrayList<Allocation>());
		return professor;
	}
}
