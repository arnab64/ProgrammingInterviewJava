class threestack{			
	int stck[]; 
	int left,right,mid,mid_left,mid_right;
	int max;
	
	threestack(int nos){
		max = nos;
		stck = new int[nos];
		left = -1;					//starting index of the top-of-stack for the left stack
		right = nos;				//starting index of the top-of-stack for the right stack
		mid = nos/2;
		mid_left = left-1;			//starting index of the left-of-stack for the middle stack
		mid_right = right+1;		//starting index of the right-of-stack for the middle stack
	}
	
	void push_left(int item){		//push to the left stack
		if (left==mid_left-1)
			System.out.println("Cannot push "+item+", Stack is full!");
		else{
			stck[++left] = item;
			//printinfo();
		}
	}
	
	void push_right(int item){		//push to the right stack
		if (mid_right==right-1)
			System.out.println("Cannot push "+item+", Stack is full!");
		else{
			stck[--right] = item;
			//printinfo();
		}
	}
	
	void push_mid(int item){		//push to the mid stack
		//System.out.println("PushMid called!");
		if(mid_left==-2 && mid_right==max+1 && (left>=mid||right<=mid)){
			System.out.println("No space to create mid stack!");
		}
		else if((mid_right==right-1)&&(left==mid_left-1)){
			System.out.println("Cannot push " + item + ". Middle Stack is full!");
		}
		else if(mid_left==-2 && mid_right==max+1){		//if the stack is empty
			mid_left = mid;
			mid_right = mid;
			stck[mid_left] = item;
			//printinfo();
		}
		else if(mid-mid_left>mid_right-mid){
			stck[incr_mid(2)] = item;					//stck[++mid_right] = item
			//printinfo();
		}
		else if(mid-mid_left==mid_right-mid){
			stck[decr_mid(1)] = item;					//stck[--mid_left] = item
			//printinfo();
		}
	}
	
	int pop_left(){				//pop from the left stack
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
	
	int pop_right(){			//pop from the right stack
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

	int decr_mid(int x){		//function to decrement boundaries of the middle stack	
		if(x==1){				//x=1 means the mid_left
			return --mid_left;				
		}
		else{					//x=2 means the mid_right
			if(mid == mid_right){
				mid_right = max+1;
				return max+1;
			}
			else
				return --mid_right;
		}
	}
	
	int incr_mid(int x){		//function to increment boundaries of the middle stack
		if(x==1){
			if(mid_left==mid){
				mid_left = -2;
				return -2;
			}
			else
				return ++mid_left;
		}
		else{
			return ++mid_right;
		}
	}
	
	int pop_mid(){					//pop from the middle stack
		if(mid_left==-2 && mid_right==max+1){					//if the midstack is empty`
			System.out.println("Cannot POP. The middle stack is empty!");
			return -1;
		}
		else if(mid==mid_left && mid==mid_right){				//if the mid stack has only one element
			int topop = stck[mid];
			stck[mid] = 0;
			decr_mid(2);
			incr_mid(1);
			//printinfo();
			return topop;
		}
		else if(mid-mid_left==mid_right-mid){				//if equal number of items on both side of the mid, pop the right one
			int topop = stck[mid_right];
			stck[mid_right]=0;
			decr_mid(2);									//mid_right--
			//printinfo();
			return topop;
		}
		else if(mid-mid_left>mid_right-mid){				//if left has more items, pop the left one
			int topop = stck[mid_left];
			stck[mid_left]=0;
			incr_mid(1);									//mid_left++;
			//printinfo();
			return topop;
		}
		else{
			return -1;
		}
	}
	
	void display(){					// display the contents of the whole array
		//stck[0]=67;
		for(int y=0;y<max-1;y++){
			System.out.print(stck[y]);
			System.out.print(".");
		}
		System.out.println(stck[max-1]);
	}
	
	void printinfo(){				//print vital information like left and right stack boundary, etc.
		System.out.println("left:"+left+", right:"+right+", mid_left:"+mid_left+", mid_right:"+mid_right);
	}
}

class teststack{					//use the class threestack
	public static void main(String args[]){
	threestack ts = new threestack(6);
	ts.push_left(23);
	ts.push_right(46);
	ts.push_left(98);
	ts.push_left(67);
	ts.push_left(67);
	ts.display();
	//ts.push_left(123);
	ts.push_mid(999);
	ts.push_mid(444);
	ts.pop_left();
	ts.pop_left();
	ts.pop_left();
	ts.push_mid(333);
	ts.push_mid(222);
	ts.push_mid(111);
	ts.push_left(198);
	ts.push_right(167);
	ts.display();
	ts.pop_mid();
	ts.display();
	ts.pop_mid();
	ts.display();
	ts.pop_mid();
	ts.display();
	ts.pop_mid();
	ts.display();
	}
}