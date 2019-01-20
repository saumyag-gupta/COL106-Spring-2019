import java.util.*;

public class TowerOfHanoi{
	
	static int remain_pole(int start_pos,int end_pos){
		return (6-start_pos-end_pos);
	}
	
	public static void toh_with_recursion(int num_disks, int start_pos, int end_pos){
		
		if(start_pos == end_pos){
			return;
		}
		
		if(num_disks == 1){
			System.out.println(String.valueOf(start_pos)+" -> "+String.valueOf(end_pos));
		}
		else{
			int extra_pos = remain_pole(start_pos,end_pos);
			toh_with_recursion(num_disks-1,start_pos,extra_pos);
			toh_with_recursion(1,start_pos,end_pos);
			toh_with_recursion(num_disks-1,extra_pos,end_pos);
		}
	}
	
	public static class execute{
		int num,start,end;
		
		execute(int num_disks, int start_pos, int end_pos){
			num = num_disks;
			start = start_pos;
			end = end_pos;
		}
		
		void set(int num_disks, int start_pos, int end_pos){
			num = num_disks;
			start = start_pos;
			end = end_pos;
		}
	}
	
	public static void toh_without_recursion(int num_disks, int start_pos, int end_pos){
		
		if(start_pos == end_pos){
			return;
		}
		
		MyStack<execute> call = new MyStack<execute>();
		
		execute statement = new execute(num_disks,start_pos,end_pos);
		call.push(statement);
		
		while(!call.empty()){
			statement = call.pop();
			
			num_disks = statement.num;
			start_pos = statement.start;
			end_pos = statement.end;
			
			if(num_disks!=1){
				
				int extra_pos = remain_pole(start_pos,end_pos);
				
				execute statement3 = new execute(num_disks-1,extra_pos,end_pos);
				call.push(statement3);
				execute statement2 = new execute(1,start_pos,end_pos);
				call.push(statement2);
				execute statement1 = new execute(num_disks-1,start_pos,extra_pos);
				call.push(statement1);
				
			}
			else{
				System.out.println(String.valueOf(start_pos)+" -> "+String.valueOf(end_pos));
			}
		}	
	}
}