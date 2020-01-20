package com.moengage.interview.linkedlistapi.response;

public class ResponseMeta {
	int id;
	int length;
	
	public ResponseMeta(int id,int length)
	{
		this.id = id;
		this.length = length;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public int getLength()
	{
		return this.length;
	}
}
