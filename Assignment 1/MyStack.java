import java.util.*;

public class MyStack<E>{
	
	LL<E> list = new LL<E>();

	public void push(E item) {
		list.insert(item);
	}
	
	public E pop() throws EmptyStackException{
		return list.delete();
	} 
	
	public E peek() {
		return list.head.data;
	}
	
	public boolean empty(){
		return (list.head == null);
	}
	
	public void display(){
		list.traverse();
	}
}

class node<E>{
	E data;
	node<E> next;
	
	node(E Data,node<E> Next){
		data = Data;
		next = Next;
	}
	
	node(){
		this(null,null);
	}
}

class LL<E>{
	
	node<E> head;
	
	LL(node<E> head){
		this.head = head;
	}
	
	LL(){
		this(null);
	}
	
	void insert(E element){
		node<E> curr = new node<E>(element,this.head);
		this.head = curr;
	}
	
	E delete() throws EmptyStackException{
		if(this.head == null){
			throw new EmptyStackException();
		}
		else{
			E ret = head.data;
			head = head.next;
			return ret;
		}
	}
	
	void traverse(){
		node<E> ptr = head;
		while(ptr != null){
			System.out.print((ptr.data).toString()+" -> ");
			ptr=ptr.next;
		}
		
		System.out.print("end");
		System.out.println();
	}
}