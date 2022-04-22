package com.springboot.awsmysql.Dao;

import java.util.Collection;
import java.util.List;

import com.springboot.awsmysql.Entity.InputDetails;
import com.springboot.awsmysql.Entity.OutputDetails;

//Dao for output details 
public interface OutPutDetailsDao {

	Collection<OutputDetails> getAllOutputDetails();
	
	public void insertOutputDetails();

}
