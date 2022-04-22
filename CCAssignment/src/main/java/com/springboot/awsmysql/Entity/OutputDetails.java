package com.springboot.awsmysql.Entity;

import org.springframework.stereotype.Component;

//pojo for output details table
public class OutputDetails {

	private int id;
	private String final_ouput;
	private int count;
	private String nameWithTimeStamp;
	
	public OutputDetails()
	{
		
	}

	public OutputDetails(int id, String final_ouput, int count, String nameWithTimeStamp) {
		super();
		this.id = id;
		this.final_ouput = final_ouput;
		this.count = count;
		this.nameWithTimeStamp = nameWithTimeStamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFinal_ouput() {
		return final_ouput;
	}

	public void setFinal_ouput(String final_ouput) {
		this.final_ouput = final_ouput;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNameWithTimeStamp() {
		return nameWithTimeStamp;
	}

	public void setNameWithTimeStamp(String nameWithTimeStamp) {
		this.nameWithTimeStamp = nameWithTimeStamp;
	}

	@Override
	public String toString() {
		return "OutputDetails [id=" + id + ", final_ouput=" + final_ouput + ", count=" + count + ", nameWithTimeStamp="
				+ nameWithTimeStamp + "]";
	}
	
	
	
	
}
