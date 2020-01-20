package com.moengage.interview.linkedlistapi.response;

public class ResponseObject {

	int id;
	String name;
	int birthyear;
	Integer next;
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setBirthYear(int birthyear)
	{
		this.birthyear = birthyear;
	}
	
	public void setNext(Integer next)
	{
		this.next = next;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getBirthYear()
	{
		return this.birthyear;
	}
	
	public Integer getNext()
	{
		return this.next;
	}
	
}
