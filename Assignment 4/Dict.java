import java.io.*;
import java.util.*; 
import java.lang.*;

public class Dict{
	node[] storage;
	public int size;
	private static final int MaxSize = 100003;    //100003 is a prime number and greater than 2^16, hence i chose this as array MaxSize
	private static final int factor = 128;
	
	public Dict(){
		storage = new node[MaxSize];
		size = 0;
	}
	
	public static int hash(String key){
		long hash_value=0;
		
		for(char ch: key.toCharArray()){
			hash_value*=factor;hash_value%=MaxSize;
			hash_value+=(int)ch;hash_value%=MaxSize;
		}
		
		return (int)hash_value;
	}
	
	int findpos1(String key){
		int ret_pos = hash(key);
		int offset = 1;
		
		while(storage[ret_pos]!=null){
			ret_pos += offset;
			ret_pos %= MaxSize;
			offset += 2;
			offset %= MaxSize;
		}
		
		return ret_pos;
	}
	
	int findpos2(String key){
		int ret_pos = hash(key);
		int offset = 1;
		
		while(storage[ret_pos] != null && storage[ret_pos].compare(key) != 0){
			ret_pos += offset;
			ret_pos %= MaxSize;
			offset += 2;
			offset %= MaxSize;
		}
		if(storage[ret_pos] == null)ret_pos = -1;
		
		return ret_pos;
	}
	
	public void put(String key,int value){
		if(size >= MaxSize){
			// Not enough storage
			return;
		}
		
		int pos = findpos1(key);
		storage[pos] = new node(key,value);
	}
	
	public int get(String key){
		int pos = findpos2(key);
		if(pos == -1){
			//doesn't exist
			return -1;
		}
		return storage[pos].getval();
	}
	
	public boolean containsKey(String key){
		int pos = findpos2(key);
		if(pos == -1){
			return false;
		}
		return true;
	}
}

class node{
	int value;
	String key;
	boolean occupied;
	
	node(String key,int value){
		this.value = value;
		this.key = key;
	}
	
	void set(String key,int value){
		this.value = value;
		this.key = key;
	}
	
	int compare(String str){
		return str.compareTo(this.key);
	}
	
	int getval(){
		return this.value;
	}
	
}