class llstack{
	private int siz;
	private linkedlist ll;
	
	public llstack(int siz){		//constructor
		System.out.println("LL-Stack initialized!");
		ll = new linkedlist();
		this.siz = siz; 
	}
	
	public void push(int el){
		if(ll.getsize()==this.siz)
			System.out.println("Stack is FULL. Cannot push "+el);
		else 
			ll.add(el);
	}
	
	public int pop(){
		//System.out.println("SizeNow:"+ll.getsize());
		if(ll.getsize()==0){
			System.out.println("Stack is EMPTY.");
			return -1;
		}
		else{
			int x = ll.getsize();
			//System.out.println("LOL-SizeNow:"+ll.getsize());
			int y = ll.delete_return(x-1);
			return y;	
		}
	}
	
	public void display(){
		ll.printll();
	}
}