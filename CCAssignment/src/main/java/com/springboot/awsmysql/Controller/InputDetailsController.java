package com.springboot.awsmysql.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.awsmysql.Entity.InputDetails;
import com.springboot.awsmysql.Entity.OutputDetails;
import com.springboot.awsmysql.Service.InputDetailsService;
import com.springboot.awsmysql.Service.OutputDetailsService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class InputDetailsController {
	

	@Autowired
	private InputDetailsService inputDetailsService;
	
	@Autowired
	private OutputDetailsService outputDetailsService;
	private static final Logger logger = LogManager.getLogger(InputDetailsController.class);
		
		@RequestMapping(value ="/getAllInputputDetails",method = RequestMethod.GET) //Endpoint to get all the details from input_table.
		public Collection<InputDetails> getAllInputDetails()
		{
			logger.info("Inside  getAllInputDetails()");
			return inputDetailsService.getAllInputDetails();
		}

		@RequestMapping(value ="/getAllOutputDetails",method = RequestMethod.GET) //Endpoint to get all the details from input_table.
		public Collection<OutputDetails> getAllOutputDetails()
		{
			logger.info("Inside getAllOutputDetails() ");
			return outputDetailsService.getAllOutputDetails();
		}
		
		@RequestMapping(value ="/InsertOutputDetails",method = RequestMethod.GET) //Endpoint to get all the details from input_table.
		public void insertOutputDetails()
		{
			logger.info("Inside insertOutputDetails() ");
			outputDetailsService.insertOutputDetails();
		}
}
