class stack{
	int stck[]; 
	int tos;
	int max;
	
	stack(int nos){
		max = nos;
		stck = new int[nos];
		tos = -1;
	}
	
	boolean checkempty(){
		if(tos<0)
			return true;
		else
			return false;
	}
	
	boolean checkfull(){
		if (tos==max-1)
			return true;
		else
			return false;
	}
	
	boolean push(int item){
		if(checkfull())
			return false;
		else{
			stck[++tos] = item;
			return true;
		}
	}
	
	int pop(){
		if(checkempty()){
			//System.out.println("Cannot pop!");
			return -1;
		}
		else
			return stck[tos--];
	}
	
	void show(){
		int i;
		for(i=0;i<max-1;i++)
			System.out.print(stck[i]+".");
		System.out.println(stck[i]);
	}
}

class queuestack{
	stack s1;
	stack s2;
	int size;
	
	queuestack(int nox){
		size = nox;
		s1 = new stack(nox);
		s2 = new stack(nox);
		System.out.println("Initialized!");
	}
	
	void enqueue(int item){
		if(s1.push(item))
			System.out.println("Enqueued "+item);
		else
			System.out.println("Cannot enqueue!");
	}
	
	void display(){
		System.out.print("	Stack1_");
		s1.show();
		System.out.print("	Stack2_");
		s2.show();
	}
	
	int dequeue(){
		int d,el,fin;
		d = size;
		while(d>0){
			el = s1.pop();
			if(el!=-1)
				s2.push(el);
			d--;
		}
		fin = s2.pop();
		return fin;
	}
}

class tryqueuestack{
	public static void main(String args[]){
		queuestack qs = new queuestack(5);
		qs.enqueue(1);
		qs.enqueue(2);
		qs.enqueue(3);
		qs.enqueue(4);
		qs.enqueue(5);
		qs.enqueue(6);
		qs.display();
		//qs.enqueue(6);
		System.out.println("deq:"+qs.dequeue());
		//qs.display();
		System.out.println("deq:"+qs.dequeue());
		System.out.println("deq:"+qs.dequeue());
		System.out.println("deq:"+qs.dequeue());
		System.out.println("deq:"+qs.dequeue());
		System.out.println("deq:"+qs.dequeue());		
		qs.display();
	}
}