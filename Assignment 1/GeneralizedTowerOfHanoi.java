import java.util.*;

public class GeneralizedTowerOfHanoi{
	
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
			TowerOfHanoi.toh_with_recursion(1,start_pos,end_pos);
		}
		else{
			int extra_pos = TowerOfHanoi.remain_pole(start_pos,end_pos);
			TowerOfHanoi.toh_with_recursion(num_disks-1,start_pos,extra_pos);
			TowerOfHanoi.toh_with_recursion(1,start_pos,end_pos);
			gtoh_with_recursion(num_disks-1,extra_pos,r,b);
		}
	}
	
	public static void gtoh_without_recursion(int num_disks, int start_pos,  int r, int b){
		
		MyStack<TowerOfHanoi.execute> call = new MyStack<TowerOfHanoi.execute>();
		
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
			extra_pos = TowerOfHanoi.remain_pole(start_pos,end_pos);
			
			TowerOfHanoi.execute statement = new TowerOfHanoi.execute(1,start_pos,end_pos);
			call.push(statement);
			
			if(num_disks>1){
				statement = new TowerOfHanoi.execute(num_disks-1,start_pos,extra_pos);
				call.push(statement);
			}
			//System.out.println(num_disks);
			
			while(!call.empty()){
				statement = call.pop();
				
				int nums = statement.num;
				start_pos = statement.start;
				end_pos = statement.end;
				extra_pos = TowerOfHanoi.remain_pole(start_pos,end_pos);
				
				if(nums != 1){
					TowerOfHanoi.execute statement3 = new TowerOfHanoi.execute(nums-1,extra_pos,end_pos);
					call.push(statement3);
					TowerOfHanoi.execute statement2 = new TowerOfHanoi.execute(1,start_pos,end_pos);
					call.push(statement2);
					TowerOfHanoi.execute statement1 = new TowerOfHanoi.execute(nums-1,start_pos,extra_pos);
					call.push(statement1);
				}
				else{
					System.out.println(String.valueOf(start_pos)+" -> "+String.valueOf(end_pos));
				}
			}
			start_pos = extra_pos;
			num_disks--;
		}
	}
}