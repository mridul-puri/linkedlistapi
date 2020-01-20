package com.moengage.interview.linkedlistapi.model;

import com.moengage.interview.linkedlistapi.model.ListNode;

public class LinkedList {
	static int inc = 100;
	int length = 0;
	int id;
	ListNode head;
	int nodeId = 0;
	
	public LinkedList()
	{
		++inc;
		++length;
		this.id = inc;
		this.nodeId = 0;
	}
	
	public int getID()
	{
		return this.id;
	}
	
	public ListNode getHead()
	{
		return this.head;
	}
	
	public void setHead(ListNode node)
	{
		this.head = node;
	}
	
	public int getLength()
	{
		return this.length;
	}
	
	public void create(ListNode node)
	{
		this.head = node;
		node.setID(1);
		this.nodeId += 1;
	}
	
	public void pushAtEnd(ListNode node)
	{
		if(this.head == null)
			{
				this.head = node;
				node.setID(1);
			}
		else {
			ListNode tmp = this.head;
			while(tmp.next != null)
			{
				tmp = tmp.next;
			}
			tmp.setNext(node);
		}
		this.length += 1;
		this.nodeId += 1;
		node.setID(this.nodeId);
	}
	
	public ListNode pop()
	{
		if(this.head == null)
			return null;
		ListNode p = this.head;
		ListNode q = null;
		ListNode next = p.getNext();
		if(next == null)
		{
			this.head = null;
			this.length -= 1;
			return p;
		}
		while((next = p.getNext()) != null)
		{
			q = p;
			p = next;
		}
		q.setNext(null);
		this.length -= 1;
		return p;
	}
	
	public void remove(String name, int birthyear)
	{
		if(this.head == null)
			return;
		
		ListNode q = head;
		ListNode p = null;
		while(q != null)
		{
			if(q.getName().equalsIgnoreCase(name) && q.getBirthYear() == birthyear)
			{
				if(p == null)
				{
					p = q;
					q = p.getNext();
					this.setHead(q);
				}
				else {
					p.setNext(q.getNext());
					q = p.getNext();
				}
				this.length -= 1;
			}
			else {
				p = q;
				q = q.getNext();
			}
		} 
	}
	
	public ListNode reverse(ListNode head)
	{
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr!=null)
		{
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
