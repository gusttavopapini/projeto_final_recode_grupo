package com.professorallocation.projetorecodeiv.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.professorallocation.projetorecodeiv.entity.Allocation;
import com.professorallocation.projetorecodeiv.entity.Course;
import com.professorallocation.projetorecodeiv.entity.Professor;
import com.professorallocation.projetorecodeiv.repository.AllocationRepository;

@Service
public class AllocationService {

	private final ProfessorService professorService;
    private final CourseService courseService;
	private final AllocationRepository allocationRepository;
	
	public AllocationService(AllocationRepository allocationRepository, ProfessorService professorService, CourseService courseService) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorService = professorService;
		this.courseService = courseService;
	}
	
	
	public Allocation create(Allocation allocation) throws DataIntegrityViolationException {
		allocation.setId(null);
		return save(allocation);
	}

	
	public Allocation update(Allocation allocation) throws DataIntegrityViolationException {
		if(allocationRepository.existsById(allocation.getId()));
		return save(allocation);
	}
	
	
	public List<Allocation> findAll() {
		return allocationRepository.findAll();
	}
	
	
	public Allocation findById(Long id) {
		return allocationRepository.findById(id).orElse(null);
	}
	
	
	public void deleteAll() {
		allocationRepository.deleteAllInBatch();
	}
	
	
	public void deleteById(Long allocationId) {
		if(allocationId != null && allocationRepository.existsById(allocationId)) {
			allocationRepository.deleteById(allocationId);
		}		
	}
	
	private Allocation save(Allocation allocation) throws DataIntegrityViolationException {
            if(!hasCollision(allocation)) {
                allocation = allocationRepository.save(allocation);   
                
                Professor p = allocation.getProfessor();
                p = professorService.findById(p.getId());
                allocation.setProfessor(p);  
                
                Course c = allocation.getCourse();
                c = courseService.findById(c.getId());
                allocation.setCourse(c);                
            } return allocation; 
    }

	
    private boolean hasCollision(Allocation newA) {
        boolean hasCollision = false;
        List<Allocation> currentAllocs = allocationRepository.findByProfessorId(newA.getProfessor().getId());
        for(Allocation currentA : currentAllocs) {
            hasCollision = hasCollision(currentA, newA);
            if (hasCollision) {
                break;
            }
        }
        return hasCollision;
    }

    
    private boolean hasCollision(Allocation currentA, Allocation newA) {
        return !currentA.getId().equals(newA.getId())
                && currentA.getDays() == newA.getDays()
                && currentA.getStart_hour().compareTo(newA.getEnd_hour()) < 0
                && newA.getStart_hour().compareTo(currentA.getEnd_hour()) < 0;
    }
}
