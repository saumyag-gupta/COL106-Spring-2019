
public class MyStack<E>{
	
	LL<E> list = new LL<E>();

	public void push(E item) {
		list.insert(item);
	}
	
	public E pop(){
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
	node next;
	
	node(E Data,node Next){
		data = Data;
		next = Next;
	}
	
	node(){
		this(null,null);
	}
}

class LL<E>{
	
	node<E> head;
	
	LL(node head){
		this.head = head;
	}
	
	LL(){
		this(null);
	}
	
	void insert(E element){
		node<E> curr = new node<E>(element,this.head);
		this.head = curr;
	}
	
	E delete(){
		if(this.head == null){
			return null;
		}
		else{
			E ret = head.data;
			head = head.next;
			return ret;
		}
	}
	
	void traverse(){
		node ptr = head;
		while(ptr != null){
			System.out.print((ptr.data).toString()+" -> ");
			ptr=ptr.next;
		}
		
		System.out.print("end");
		System.out.println();
	}
}