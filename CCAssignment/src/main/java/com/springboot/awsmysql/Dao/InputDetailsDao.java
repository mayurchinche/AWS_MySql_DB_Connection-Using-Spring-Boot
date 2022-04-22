package com.springboot.awsmysql.Dao;

import java.util.Collection;

import com.springboot.awsmysql.Entity.InputDetails;

//Dao of input details.
public interface InputDetailsDao {

	Collection<InputDetails> getAllInputDetails();

}