package com.springboot.awsmysql.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.awsmysql.Dao.InputDetailsDao;
import com.springboot.awsmysql.Dao.OutPutDetailsDao;
import com.springboot.awsmysql.Entity.InputDetails;
import com.springboot.awsmysql.Entity.OutputDetails;
//service for managing output details.
@Service
public class OutputDetailsService {
	@Autowired
	@Qualifier("mysql1")
	public OutPutDetailsDao outPutDetailsDao;
	
	public Collection<OutputDetails>getAllOutputDetails()
	{
		
		return this.outPutDetailsDao.getAllOutputDetails();
	}
	
	public void insertOutputDetails()
	{
		outPutDetailsDao.insertOutputDetails();
	}
	
}
