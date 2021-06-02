package com.professorallocation.projetorecodeiv.entity;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Allocation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Allocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "days", nullable = false)
	@Enumerated(EnumType.STRING)
	private DayOfWeek days;
	
	@Column(name = "start_hour", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date start_hour;
	
	@Column(name = "end_hour", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date end_hour;
	
	@JsonIgnoreProperties({"allocations"})
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;
	
	@JsonIgnoreProperties({"allocations"})
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;
}
