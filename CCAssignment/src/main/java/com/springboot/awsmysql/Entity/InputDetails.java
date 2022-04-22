package com.springboot.awsmysql.Entity;

//pojo for input details table
public class InputDetails {

	private int id;
	private String input_string;
	
	public InputDetails(int id, String input_string) {
		super();
		this.id = id;
		this.input_string = input_string;
	}
	
	public InputDetails()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInput_string() {
		return input_string;
	}

	public void setInput_string(String input_string) {
		this.input_string = input_string;
	}

	@Override
	public String toString() {
		return "InputDetails [id=" + id + ", input_string=" + input_string + "]";
	}
	
	
	
}
