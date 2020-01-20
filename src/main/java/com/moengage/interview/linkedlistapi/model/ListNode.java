package com.moengage.interview.linkedlistapi.model;

public class ListNode {
	int id;
	String name;
	int birthyear;
	ListNode next;
	
	public ListNode(String name, int birthyear)
	{
		this.name = name;
		this.birthyear = birthyear;
		this.next = null;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int setBirthYear(int birthyear)
	{
		int count = 0;
		while(birthyear != 0)
        {
			birthyear /= 10;
            ++count;
        }
		if(count != 4)
			return -1;
		else
		{
			this.birthyear = birthyear;
			return 0;
		}
	}
	
	public void setNext(ListNode node)
	{
		this.next = node;
	}
	
	public void setID(int id)
	{
		this.id = id;
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
	
	public ListNode getNext()
	{
		return this.next;
	}
}
