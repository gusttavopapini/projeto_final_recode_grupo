package com.project.professorallocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.professorallocation.entity.Department;
import com.project.professorallocation.entity.Professor;

public class ProfessorRepositoryTest {
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Test
	public void findAll() {
		List<Professor> professors = professorRepository.findAll();
		System.out.println(professors);
	}
	
	@Test
	public void findById() {
		
		Long id = 1L;	
		Optional<Professor> professorOptional = professorRepository.findById(id);
		Professor professor = professorOptional.orElse(null);
		System.out.println(professor);
	}
	
	@Test
	public void saveCreate() {
		
		Professor p = new Professor();
		Department d = new Department();
		d.setId(3L);
		p.setName("João da Silva");
		p.setCpf("025.025.025-02");
		p.setDepartment(d);
		Professor professor = professorRepository.save(p);
		System.out.println(professor);	
	}
	
	@Test
	public void saveUpdate() {
		
		Professor p = new Professor();
		Department d = new Department();
		d.setId(3L);
		p.setId(5L);
		p.setName("João da Silva");
		p.setCpf("025.025.025-02");
		p.setDepartment(d);
		Professor professor = professorRepository.save(p);
		System.out.println(professor);	
	}
	
	@Test
	public void delete() {
		
		Long id = 5L;		
		professorRepository.deleteById(id);	
	}
	
	@Test
	public void deleteAll() {
				
		professorRepository.deleteAllInBatch();	
	}
}
