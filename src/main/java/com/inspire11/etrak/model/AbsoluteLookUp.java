package com.inspire11.etrak.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AbsoluteLookUp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "table_id")
	public LookUpTables lookup;

	private Integer value;
	private Integer score;

	

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LookUpTables getLookup() {
		return lookup;
	}

	public void setLookup(LookUpTables lookup) {
		this.lookup = lookup;
	}

}
