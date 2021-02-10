package com.datastructure.dll;

public class DLL {
	public Node head;
    public Node tail;
    public int size = 0;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
    public void push(Node newNode) {
        // if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            size++;
            return;
        }
        
        // first find the lastNode in the list
        // then, set the lastNode's next to be the newNode;
        // then, we have to set the previous of the lastNode to the lastNode that we found previously.
        // finally, set the list's tail to be the node that we have added
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
        size++;
    }
    
    public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
    // This method prints the values of the nodes from the tail to the head
    public void printValuesBackward() {
    	Node current = this.tail;
    	while(current != null) {
    		System.out.println(current.value);
    		current = current.previous;
    	}
    }
    
    // This method removes the last node of our DLL and returns it.
    public Node pop() {
    	Node ret = this.tail;
    	Node current = ret.previous;
    	this.tail = current;
    	this.tail.next = null;
    	System.out.println(ret.value + " is removed");
    	return ret;
    }
    
    //This method returns a boolean whether the value in the argument is in the list or not. 
    //Return true if the value exists, else, return false.
    public boolean contains(Integer value) {
    	Node current = this.head;
    	while(current.next != null) {
    		if(current.value == value) {
    			System.out.println("DLL contains " + value);
    			return true;
    		}
    		current = current.next;
    	}
    	System.out.println("DLL does not contain " + value);
    	return false;
    }
    //Returns the number of nodes in the list
    public int size() {
    	System.out.println("The DLL size is " + this.size);
    	return this.size;
    }
    
    //Inserts a node at a specific index. 
    //For example, let's say that we have 3 nodes in our list. 
    //If we call insertAt(newNode, 1), the newNode should be inserted right after the head. (head is index 0)
    public void insertAt(Node newNode, int index) {
    	if(index > size || index < 0) {
    		throw new IllegalArgumentException("cannot insert, index invalid");
    	}
    	Node cur = this.head;  	
    	for (int i = 0; i < index; i++) {
    		cur = cur.next;
    	}
    	newNode.next = cur;
    	cur.previous.next = newNode;
    	size ++;
    }
    //This method removes a node at an index. 
    //For example, let's say that we have 3 nodes in our list. 
    //If we call removeAt(1), the middle node is removed. (head is index 0)
    public void removeAt(int index) {
    	if(index > size || index < 0) {
    		throw new IllegalArgumentException("cannot remove, index invalid");
    	}
    	Node cur = this.head;
    	for(int i = 0; i < index; i++) {
    		cur = cur.next;
    	}
    	if(index == 0) {
    		this.head = cur.next;
    		size--;
    	} else {
    		Node ret = cur;
    		Node pre = cur.previous;
    		pre.next = ret;
    		cur = null;
    		size--;
    	}
    }
    //This method returns a boolean whether the node is a palindrome or not. 
    //Return true if it is a palindrome, else, return false
    public boolean isPalindrome() {
    	Node h = this.head;
    	Node t = this.tail;
    	for (int i = 0; i < size/2; i ++) {
    		if(h != t) {
    			System.out.println("DLL is not palindrome");
    			return false;
    		}
    		h = h.next;
    		t = t.previous;
    	}
    	System.out.println("DLL is palindrom");
    	return true;
    }
    	
}
