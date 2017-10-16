package com.inspire11.etrak.service;

import com.inspire11.etrak.model.LookUpTables;

public interface LookUpService {

	public LookUpTables findByName(String name);
}
