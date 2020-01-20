package com.moengage.interview.linkedlistapi.service;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.moengage.interview.linkedlistapi.model.LinkedList;
import com.moengage.interview.linkedlistapi.model.ListNode;
import com.moengage.interview.linkedlistapi.response.GetPopResponse;
import com.moengage.interview.linkedlistapi.response.GetResponse;
import com.moengage.interview.linkedlistapi.response.ResponseMeta;
import com.moengage.interview.linkedlistapi.response.ResponseObject;

@Service
public class LinkedListService {
public static ConcurrentHashMap<Integer,LinkedList> listOfLinkedLists  = new ConcurrentHashMap<Integer,LinkedList>();
	
	public GetResponse create(String name, int birthyear)
	{
		ListNode node = new ListNode(name,birthyear);
		LinkedList list = new LinkedList();
		list.create(node);
		listOfLinkedLists.put(list.getID(),list);
		ResponseMeta respMeta = new ResponseMeta(list.getID(),list.getLength());
		return new GetResponse(respMeta,getListItems(list)); 
	}
	
	public GetResponse push(int listID, String name, int birthyear)
	{
		if(!listOfLinkedLists.containsKey(listID))
			return null;
		LinkedList list = listOfLinkedLists.get(listID);
		ListNode node = new ListNode(name,birthyear);
		list.pushAtEnd(node);
		ResponseMeta respMeta = new ResponseMeta(listID,list.getLength());
		return new GetResponse(respMeta,getListItems(list));
	}
	
	public GetPopResponse pop(int listID)
	{
		if(!listOfLinkedLists.containsKey(listID))
			return null;
		LinkedList list = listOfLinkedLists.get(listID);
		ListNode node = list.pop();
		if(node == null)
			return null;
		return new GetPopResponse(node.getName(),node.getBirthYear());
		
	}
	
	public GetResponse remove(int listID, String name, int birthyear)
	{
		if(!listOfLinkedLists.containsKey(listID))
			return null;
		LinkedList list = listOfLinkedLists.get(listID);
		list.remove(name,birthyear);
		ResponseMeta respMeta = new ResponseMeta(listID,list.getLength());
		return new GetResponse(respMeta,getListItems(list));
	}
	
	public GetResponse list(int listID)
	{
		if(!listOfLinkedLists.containsKey(listID))
			return null;
		LinkedList list = listOfLinkedLists.get(listID);
		ResponseMeta respMeta = new ResponseMeta(listID,list.getLength());
		return new GetResponse(respMeta,getListItems(list));
	}
	public GetResponse reverse(int listID)
	{
		if(!listOfLinkedLists.containsKey(listID))
			return null;
		LinkedList list = listOfLinkedLists.get(listID);
		ListNode node = list.reverse(list.getHead());
		list.setHead(node);
		ResponseMeta respMeta = new ResponseMeta(listID,list.getLength());
		return new GetResponse(respMeta,getListItems(list));	
	}
	
	public Object delete(int listID)
	{
		if(!listOfLinkedLists.containsKey(listID))
			return null;
		LinkedList deleted = listOfLinkedLists.remove(listID);
		if(deleted != null)
			return true;
		else
			return null;
	}
	
	public ArrayList<ResponseObject> getListItems(LinkedList list)
	{
		ArrayList<ResponseObject> arr = new ArrayList<ResponseObject>();
		ListNode temp = list.getHead();
		while(temp != null)
		{
			ResponseObject resObj = new ResponseObject();
			resObj.setID(temp.getID());
			resObj.setName(temp.getName());
			resObj.setBirthYear(temp.getBirthYear());
			if(temp.getNext() == null)
				resObj.setNext(null);
			else
				resObj.setNext(temp.getNext().getID());
			arr.add(resObj);
			temp = temp.getNext();
		}
		return arr;
	}
}
