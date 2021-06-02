package com.professorallocation.projetorecodeiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorallocation.projetorecodeiv.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	List<Professor> findByNameContainingIgnoreCase(String name);
}
