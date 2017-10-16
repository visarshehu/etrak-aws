package com.inspire11.etrak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspire11.etrak.model.LookUpTables;
import com.inspire11.etrak.repository.LookUpTablesRepository;

@Service("lookUpService")
public class LookUpServiceImpl implements LookUpService {
	
	@Autowired
	private LookUpTablesRepository lookupTables;

	public LookUpTables findByName(String name) {
		return lookupTables.findByName(name);
	};
}
