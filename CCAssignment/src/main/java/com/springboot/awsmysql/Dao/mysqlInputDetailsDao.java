package com.springboot.awsmysql.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.awsmysql.Controller.InputDetailsController;
import com.springboot.awsmysql.Entity.InputDetails;
import com.springboot.awsmysql.Entity.OutputDetails;

//Repository for performing operations on input details.
@Repository("mysql")
public class mysqlInputDetailsDao implements InputDetailsDao{
	
	private static final Logger logger = LogManager.getLogger(mysqlInputDetailsDao.class);
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate; //Using jdbcTemplate for DB connection and execution of queries.
	
		
	@Override
	public Collection<InputDetails> getAllInputDetails() {
		
		logger.info("Inside getAllInputDetails() ");
		
		final String sql = "SELECT id,input_string FROM input_details"; //Query to get all the input_strings.
		
		
		List<InputDetails> query = jdbcTemplate.query(sql, new RowMapper<InputDetails>() {

		
				
			@Override
			public InputDetails mapRow(ResultSet rs, int i ) throws SQLException {
				
				InputDetails inputDetails = new InputDetails();
				inputDetails.setId(rs.getInt("id"));
				inputDetails.setInput_string(rs.getString("input_string"));
				return inputDetails;
			}
			
		});
		logger.info("Database connection established");
		logger.info("Input Details are :-");
		for(InputDetails i :query)
		{
			logger.info(i.toString());
		}
		
		return query;
	}

	
}
