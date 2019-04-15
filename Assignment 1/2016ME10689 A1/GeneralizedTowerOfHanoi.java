import java.util.*;

public class GeneralizedTowerOfHanoi{
	
	// Code that has been taken as it is from TowerOfHanoi.java
	
	static int remain_pole(int start_pos,int end_pos){
		return (6-start_pos-end_pos);
	}
	
	public static void toh_with_recursion(int num_disks, int start_pos, int end_pos){
		
		if(start_pos == end_pos){
			return;
		}
		
		if(num_disks == 1){
			System.out.println(String.valueOf(start_pos)+" "+String.valueOf(end_pos));
		}
		else{
			int extra_pos = remain_pole(start_pos,end_pos);
			toh_with_recursion(num_disks-1,start_pos,extra_pos);
			toh_with_recursion(1,start_pos,end_pos);
			toh_with_recursion(num_disks-1,extra_pos,end_pos);
		}
	}
	
	static class execute{
		int num,start,end;
		
		execute(int num_disks, int start_pos, int end_pos){
			num = num_disks;
			start = start_pos;
			end = end_pos;
		}
	}
	
	// Actual code for GeneralizedTowerOfHanoi
	
	public static void gtoh_with_recursion(int num_disks, int start_pos, int r, int b){
		int end_pos;
		if(num_disks % 2 == 0)
			end_pos = r;
		else
			end_pos = b;
		
		if(start_pos == end_pos){
			if(num_disks > 1)
				gtoh_with_recursion(num_disks-1,start_pos,r,b);
			else return;
		}	
		else if(num_disks == 1){
			toh_with_recursion(1,start_pos,end_pos);
		}
		else{
			int extra_pos = remain_pole(start_pos,end_pos);
			toh_with_recursion(num_disks-1,start_pos,extra_pos);
			toh_with_recursion(1,start_pos,end_pos);
			gtoh_with_recursion(num_disks-1,extra_pos,r,b);
		}
	}
	
	public static void gtoh_without_recursion(int num_disks, int start_pos,  int r, int b){
		
		MyStack<execute> call = new MyStack<execute>();
		
		int end_pos,extra_pos;
		
		while(num_disks > 0){
		
			if(num_disks % 2 == 0)
				end_pos = r;
			else
				end_pos = b;
		
			if(start_pos == end_pos){
				num_disks--;
				continue;
			}
			extra_pos = remain_pole(start_pos,end_pos);
			
			execute statement = new execute(1,start_pos,end_pos);
			call.push(statement);
			
			if(num_disks>1){
				statement = new execute(num_disks-1,start_pos,extra_pos);
				call.push(statement);
			}
			
			while(!call.empty()){
				statement = call.pop();
				
				int nums = statement.num;
				start_pos = statement.start;
				end_pos = statement.end;
				extra_pos = remain_pole(start_pos,end_pos);
				
				if(nums != 1){
					execute statement3 = new execute(nums-1,extra_pos,end_pos);
					call.push(statement3);
					execute statement2 = new execute(1,start_pos,end_pos);
					call.push(statement2);
					execute statement1 = new execute(nums-1,start_pos,extra_pos);
					call.push(statement1);
				}
				else{
					System.out.println(String.valueOf(start_pos)+" "+String.valueOf(end_pos));
				}
			}
			start_pos = extra_pos;
			num_disks--;
		}
	}
}