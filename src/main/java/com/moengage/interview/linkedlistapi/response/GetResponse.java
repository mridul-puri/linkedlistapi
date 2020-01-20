package com.moengage.interview.linkedlistapi.response;

import java.util.ArrayList;

import com.moengage.interview.linkedlistapi.response.ResponseMeta;

public class GetResponse {
	ResponseMeta m;
	ArrayList<ResponseObject> arr;
	
	public GetResponse(ResponseMeta m,ArrayList<ResponseObject> arr)
	{
		this.m = m;
		this.arr = arr;
	}
	
	public ResponseMeta getMeta()
	{
		return this.m;
	}
	
	public ArrayList<ResponseObject> getObject()
	{
		return this.arr;
	}
}
