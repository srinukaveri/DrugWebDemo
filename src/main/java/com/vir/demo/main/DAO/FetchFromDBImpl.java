package com.vir.demo.main.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.vir.demo.main.Entity.Emdrugs;

@Repository
public class FetchFromDBImpl {
	
	@PersistenceContext
	private EntityManager entity;

	public List<String> getAll(){
		List<String> list = null;
		try{
			String selectSql = " from Emdrugs";
			Query  qry =  entity.createQuery(selectSql);
			List<Emdrugs> list1 = qry.getResultList();
			list = new ArrayList<String>();
			for(Emdrugs em : list1){
				list.add(em.getName());
			}
		}catch(Exception exe){
			exe.printStackTrace();
		}
		return list;
	}
}
