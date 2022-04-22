package com.springboot.awsmysql.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import com.springboot.awsmysql.Service.InputDetailsService;

//Repository for performing operations for final output 
@Repository("mysql1")
public class MysqlOutputDetailsDao implements OutPutDetailsDao{
	
	@Autowired
	private InputDetailsService inputDetailsService;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; //Using jdbcTemplate for DB connection and execution of queries.

	private static final Logger logger = LogManager.getLogger(MysqlOutputDetailsDao.class);
	
	
	@Override
	public Collection<OutputDetails> getAllOutputDetails() {
		
		logger.info("Inside  getAllOutputDetails():- ");
		
		final String sql = "SELECT id,Count,Final_ouput,NameWithTimeStamp FROM Mayur_Chinche_java_output"; //Query to get all the input_strings.
		
			List<OutputDetails> query = jdbcTemplate.query(sql, new RowMapper<OutputDetails>() {

			@Override
			public OutputDetails mapRow(ResultSet rs, int i ) throws SQLException {
				
				OutputDetails outputDetails = new OutputDetails();
				outputDetails.setId(rs.getInt("id"));
				outputDetails.setCount(rs.getInt("Count"));
				outputDetails.setFinal_ouput(rs.getString("Final_ouput"));
				outputDetails.setNameWithTimeStamp(rs.getString("NameWithTimeStamp"));
				return outputDetails;
			}
			
		});
			logger.info("Database connection established");
			logger.info("Input Details are :-");
			for(OutputDetails i :query)
			{
				logger.info(i.toString());
			}
			
		return query;

	}

	@Override
	public void insertOutputDetails() {
		
		logger.info("Inside insertOutputDetails():-");
		
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
		
		OutputDetails outputDetails = new OutputDetails();
		
		for(int i=0;i<query.size();i++)
		{
  		
			String str=query.get(i).getInput_string(); //input_string on which operations to be performed.
			
			Stack<Character> stack = new Stack<Character>(); 
		
			str=str.replace(" ", "");
		
			int count=0; //Counting number of intermediate steps for final output
			
			char lastPop='\0';	//to keep the last popped element
			
			char []ch =new char[str.length()];
		
			ch=str.toCharArray();
		
			System.out.println("Preparing stack");
		
			for(int i1=0;i1<ch.length;i1++)
			{
			
				if(stack.isEmpty()) 
				{
					
					if(lastPop==ch[i])
					{
						continue;
					}
					
					stack.push(ch[i]);
				
					if(stack.peek()==lastPop)
						{
						stack.pop();
						}
				}
			
				else if(stack.peek()!=ch[i1] && lastPop !=ch[i1]) 
				{
					stack.push(ch[i1]);
					lastPop='\0';
				}
				
				else if(stack.peek()==ch[i1])
				{
					lastPop=stack.pop();
					
					count++;
				}
				
			
		}
		
		StringBuilder finaloutput = new StringBuilder();//As we are using stack and want to reverse the string which String won't allow using String string builder
		
		while(!stack.isEmpty())
		{
			finaloutput.append(stack.pop());
			
		}
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		  
		String nameWithTimeStamp="Mayur_Chinche"+timestamp.toString();

		outputDetails.setId(query.get(i).getId());
		outputDetails.setCount(count);
		outputDetails.setFinal_ouput(finaloutput.reverse().toString());
		outputDetails.setNameWithTimeStamp(nameWithTimeStamp);
		
		int  final_id =outputDetails.getId();
		int final_count=outputDetails.getCount();
		String final_output_string=outputDetails.getFinal_ouput();
	    String final_nameWithTimeStamp=outputDetails.getNameWithTimeStamp();
	   
	    //Inserting details into final_ouput table.
	    jdbcTemplate.update("INSERT INTO Mayur_Chinche_java_output(id,Count,Final_ouput,NameWithTimeStamp) VALUES(?,?,?,?)",final_id,final_count,final_output_string,final_nameWithTimeStamp );
		
	    logger.info("Performed operation on input details and inserted data in final_output table:-" +final_id+" "+final_count+" "+final_output_string+" "+final_nameWithTimeStamp +"\n");
		
	    
	    System.out.println(outputDetails.getId() + " "+outputDetails.getCount() + " "+outputDetails.getFinal_ouput()+" "+outputDetails.getNameWithTimeStamp());
		
		
		}

		
	}
	
	


	
}
