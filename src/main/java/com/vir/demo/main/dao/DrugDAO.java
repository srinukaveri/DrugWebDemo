package com.vir.demo.main.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vir.demo.main.constants.DrugConstants;
import com.vir.demo.main.constants.ErrorCodes;
import com.vir.demo.main.entity.UserLoginDetails;
import com.vir.demo.main.exception.LoginValidationException;

@Repository
public class DrugDAO {
	
	@PersistenceContext
	private EntityManager entity;

	public UserLoginDetails doLogin(String userName, String password){
		UserLoginDetails UserLoginDetails = null;
		try{
			String selectSQL = " from UserLoginDetails p  where p.userName =: userName";
			Query query = entity.createQuery(selectSQL);
			query.setParameter("userName", userName);
			UserLoginDetails = (UserLoginDetails) query.getSingleResult();
		}catch(NoResultException exe){
			throw new LoginValidationException(DrugConstants.IN_VALID_USER_ID, ErrorCodes.USER_ID_VALIDATION_ERROR_CODE);
		}
		return UserLoginDetails;
	}
	
}
