package com.moengage.interview.linkedlistapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moengage.interview.linkedlistapi.model.ListNode;
import com.moengage.interview.linkedlistapi.response.GetPopResponse;
import com.moengage.interview.linkedlistapi.response.GetResponse;
import com.moengage.interview.linkedlistapi.service.LinkedListService;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Controller {
	
	@Autowired
	LinkedListService service;
	
	public Controller()
	{
		
	}
	
	@PostMapping("/api/link")
	public ResponseEntity<GetResponse> createAPI(@RequestBody ListNode body)
	{
		return new ResponseEntity<GetResponse>(service.create(body.getName(),body.getBirthYear()),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/link/{listID}", method = RequestMethod.PUT)
	public ResponseEntity pushAPI(@PathVariable int listID, @RequestBody ListNode body)
	{
		GetResponse res = service.push(listID, body.getName(), body.getBirthYear());
		if(res == null)
			return new ResponseEntity("Linked List with ID : "+listID+" not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("/api/link/pop/{listID}")
	public ResponseEntity popAPI(@PathVariable int listID)
	{
		Object res = service.pop(listID);
		if(res == null)
			return new ResponseEntity("Linked List with ID : "+listID+" not found or is Empty.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@PostMapping("/api/link/remove/{listID}")
	public ResponseEntity removeAPI(@PathVariable int listID, @RequestBody ListNode body)
	{
		GetResponse res = service.remove(listID, body.getName(), body.getBirthYear());
		if(res == null)
			return new ResponseEntity("Linked List with ID : "+listID+" not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("/api/link/{listID}")
	public ResponseEntity listAPI(@PathVariable int listID)
	{
		GetResponse res = service.list(listID);
		if(res == null)
			return new ResponseEntity("Linked List with ID : "+listID+" not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@GetMapping("/api/link/reverse/{listID}")
	public ResponseEntity reverseAPI(@PathVariable int listID)
	{
		GetResponse res = service.reverse(listID);
		if(res == null)
			return new ResponseEntity("Linked List with ID : "+listID+" not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/link/{listID}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteAPI(@PathVariable int listID)
	{
		Object res = service.delete(listID);
		if(res == null)
			return new ResponseEntity("Linked List with ID : "+listID+" not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
}
