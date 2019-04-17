import java.util.*;
import java.io.*;

class Node{
	int s,e;
	Node[] bacche;
	Node papa;
	boolean isleaf;
	int suffix;
	
	Node(){
		bacche = new Node[128];
		s=-1;
		e=-1;
		isleaf = false;
		suffix = -1;
	}
	
	int size(){
		if(s == -1) return 0;
		return e-s+1;
	}
}