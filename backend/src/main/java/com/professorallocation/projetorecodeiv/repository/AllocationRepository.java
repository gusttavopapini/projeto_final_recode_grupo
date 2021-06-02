package com.professorallocation.projetorecodeiv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorallocation.projetorecodeiv.entity.Allocation;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

	List<Allocation> findByProfessorId(Long profId);
}
