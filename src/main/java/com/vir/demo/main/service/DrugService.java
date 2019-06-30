package com.vir.demo.main.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vir.demo.main.DAO.FetchFromDBImpl;
import com.vir.demo.main.Entity.Emdrugs;

@Service
@Transactional
public class FetchFromDBService {
	
	@Autowired
	private FetchFromDBImpl fetchFromDBImpl;
	
	
	public List<String> getDrugInfo(){
		return fetchFromDBImpl.getAll();
	}

}
