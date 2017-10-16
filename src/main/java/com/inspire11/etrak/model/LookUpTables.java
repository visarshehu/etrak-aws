package com.inspire11.etrak.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class LookUpTables {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "table_id")
	private Long id;	
	
	private String name;
	
	@OneToMany(mappedBy = "lookup", cascade = CascadeType.ALL)
	@JsonManagedReference  
	private List<AbsoluteLookUp> absoluteLookUp= new ArrayList<AbsoluteLookUp>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AbsoluteLookUp> getAbsoluteLookUp() {
		return absoluteLookUp;
	}

	public void setAbsoluteLookUp(List<AbsoluteLookUp> absoluteLookUp) {
		this.absoluteLookUp = absoluteLookUp;
	}

	
}
