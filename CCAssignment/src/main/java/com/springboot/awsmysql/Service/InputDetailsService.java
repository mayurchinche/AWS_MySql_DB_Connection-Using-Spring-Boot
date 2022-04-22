package com.springboot.awsmysql.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.awsmysql.Dao.InputDetailsDao;
import com.springboot.awsmysql.Entity.InputDetails;

@Service//service for managing input details.
public class InputDetailsService {

	@Autowired
	@Qualifier("mysql")
	public InputDetailsDao inputDetailsDao;
	
	public Collection<InputDetails> getAllInputDetails()
	{
		
		return this.inputDetailsDao.getAllInputDetails();
	}
	
	
}
