class twostack{
	int stck[]; 
	int left,right;
	int max;
	
	twostack(int nos){
		max = nos;
		stck = new int[nos];
		left = -1;
		right = nos;
	}
	
	void push_left(int item){
		if (left==right-1)
			System.out.println("Cannot push "+item+", Stack is full!");
		else{
			stck[++left] = item;
			System.out.println("pushed:"+item+" / left:"+left);
		}
	}
	
	void push_right(int item){
		if (left==right-1)
			System.out.println("Cannot push "+item+", Stack is full!");
		else{
			stck[--right] = item;
			System.out.println("pushed:"+item+" / right:"+right);
		}
	}
	
	int pop_left(){
		if(left<0){
			System.out.println("Stack underflow!");
			return -1;
		}
		else{
			int itx = stck[left--];
			System.out.println("popped:"+itx+" / left:"+left);
			return itx;
		}
	}
	
	int pop_right(){
		if(right>max-1){
			System.out.println("Stack underflow!");
			return -1;
		}
		else{
			int itx = stck[right++];
			System.out.println("popped:"+itx+" / right:"+right);
			return itx;
		}
	}	
	
	void display(){
		//stck[0]=67;
		for(int y=0;y<max-1;y++){
			System.out.print(stck[y]);
			System.out.print(".");
		}
		System.out.println(stck[max-1]);
	}
}

class teststack{
	public static void main(String args[]){
	twostack ts = new twostack(6);
	ts.push_left(23);
	ts.push_right(46);
	ts.push_left(33);
	ts.push_right(78);
	ts.push_left(123);
	ts.push_right(146);
	ts.push_left(233);
	ts.display();
	ts.pop_right();
	//ts.display();
	ts.pop_right();
	ts.pop_right();
	ts.pop_right();
	ts.push_right(426);
	ts.display();
	}
}