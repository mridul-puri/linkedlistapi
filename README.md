LINKED LIST API (Java)

This is a web based application that exposes the following API endpoints for carrying out Linked List operations :

1) Create: To create a Linked List.
2) Push: Add object to end of existing Linked List.
3) Pop: Remove last object of the given Linked List.
4) Remove: Delete the provided object form the given Linked List, if it exists.
5) List: Show the complete Linked List.
6) Reverse: Show the Linked List in reverse order.(Tail becomes new Head and Head becomes new Tail)
7) Delete: Destroy the given Linked List completely.

- This is a Maven project written in Java using Spring Boot framework.
- Appropriate error handling has been taken care of.

The APIs can be used as per the examples below :-

----------------------------------------
CREATE API : POST /api/link
	REQUEST body JSON 
	{
		name: 'John',
		birthyear: 1981
	}
	
	RESPONSE 
	{
		meta: {
			id: 101,
			length: 1
		},
		object: [{
			id: 1,
			name: 'John',
			birthyear: 1981,
			next: null
		}]
	}
----------------------------------------
PUSH API : PUT /api/link/101
	REQUEST body JSON 
	{
		name: 'Doe',
		birthyear: 1982
	}
	
	RESPONSE 
	{
		meta: {
			id: 101,
			length: 2
		},
		object: [{
			id: 1,
			name: 'John',
			birthyear: 1981,
			next: 2
		}, {
			id: 2,
			name: 'Doe',
			birthyear: 1982,
			next: null
		}]
	}
----------------------------------------
POP API : GET /api/link/pop/101
	RESPONSE 
	{
		name: 'Lorem',
		birthyear: 1912,
	}
----------------------------------------
REMOVE API : POST /api/link/remove/101
	REQUEST body JSON 
	{
		name: 'John',
		birthyear: 1981
	}
	
	RESPONSE 
	{
		meta: {
			id: 101,
			length: 1
		},
		object: [{
			id: 2,
			name: 'Doe',
			birthyear: 1982,
			next: null
		}]
	}
----------------------------------------
LIST API : GET /api/link/101
	RESPONSE 
	{
		meta: {
			id: 101,
			length: 1
		},
		object: [{
			id: 1,
			name: 'John',
			birthyear: 1981,
			next: null
		}]
	}
----------------------------------------
REVERSE API : GET /api/link/reverse/101
	RESPONSE 
	{
		meta: {
			id: 101,
			length: 3
		},
		object: [{
			id: 2,
			name: 'Doe',
			birthyear: 1982,
			next: null
		}, {
			id: 4,
			name: 'Suma',
			birthyear: 1921,
			next: 2
		}]
	}
----------------------------------------
DELETE API : DELETE /api/link/101
	RESPONSE status code 204, with empty response object.
----------------------------------------

