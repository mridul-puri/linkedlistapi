package com.moengage.interview.linkedlistapi.response;

public class GetPopResponse {
	String name;
	int birthyear;
	
	public GetPopResponse(String name, int birthyear)
	{
		this.name = name;
		this.birthyear = birthyear;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getBirthYear()
	{
		return this.birthyear;
	}
}

