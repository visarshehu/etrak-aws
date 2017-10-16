package com.inspire11.etrak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inspire11.etrak.model.LookUpTables;



@Repository("lookupRepository")
public interface LookUpTablesRepository extends JpaRepository<LookUpTables,Long> {
 
	LookUpTables findByName(String name);
}
