package com.project.professorallocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")

public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void findAll() {
		List<Department> departments = departmentRepository.findAll();
		System.out.println(departments);
	}
	
	@Test
	public void findById() {
		
		Long id = 1L;	
		Optional<Department> departmentOptional = departmentRepository.findById(id);
		Department department = departmentOptional.orElse(null);
		System.out.println(department);
	}
	
	@Test
	public void saveCreate() {
		
		Department d = new Department();
		d.setName("Departamento de T.I.");
		Department department = departmentRepository.save(d);
		System.out.println(department);	
	}
	
	@Test
	public void saveUpdate() {
		
		Department d = new Department();
		d.setId(5L);
		d.setName("Departamento de Teste");
		Department department = departmentRepository.save(d);
		System.out.println(department);	
	}
	
	@Test
	public void delete() {
		
		Long id = 5L;		
		departmentRepository.deleteById(id);	
	}
	
	@Test
	public void deleteAll() {
				
		departmentRepository.deleteAllInBatch();	
	}

}
