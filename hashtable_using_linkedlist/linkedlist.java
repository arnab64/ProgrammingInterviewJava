public class linkedlist{
	
	private Node head;
	private int size;
	
	public linkedlist(){
		System.out.println("Linkedlist initialized!");
		head = null;
		size = 0;
	}
	
	public void add(int data){
		Node temp = new Node(data);
		Node curr = head;
		if(head==null)
			head = temp;
		else{
			while(curr.getnext()!=null){
				curr = curr.getnext();
			}
			curr.setnext(temp);
		}
		this.size++;
	}
	
	public void add(int data, int index){
		Node temp = new Node(data);
		Node curr = head;
		if(index==0){
			temp.setnext(head);
			this.head = temp;
		}
		else{
			for(int i=1;i<index;i++){
				curr = curr.getnext();
			}
			temp.setnext(curr.getnext());
			curr.setnext(temp);
		}
		this.size++;
	}
	
	public void delete(int index){
		Node curr = head;
		Node nxt, nxnxt;
		for(int i=0; i<index-1; i++){
			curr = curr.getnext();
		}
		nxt = curr.getnext();
		nxnxt = nxt.getnext();
		curr.setnext(nxnxt);
		this.size--;
	}
	
	public int delete_return(int index){
		Node curr = head;
		Node nxt, nxnxt;
		if(index!=0){
			for(int i=0; i<index-1; i++){
				curr = curr.getnext();
			}
			nxt = curr.getnext();
			nxnxt = nxt.getnext();
			curr.setnext(nxnxt);
			this.size--;
			return nxt.getdata();			
		}
		else{
			int ix = curr.getdata();
			head = null;
			size = 0;
			return ix;
		}
	}
	
	public void replace(int data, int index){
		Node curr = head;
		for (int i = 0; i < index; i++){
			curr = curr.getnext();
		}
		curr.setdata(data);
	}

	public void printll(){
		Node curr = head;
		System.out.println();
		if (head==null)
			System.out.println("Linked list is EMPTY!");
		else{
			System.out.print("HEAD");
			while(curr.getnext()!=null){
				System.out.print(" --> " + curr.getdata());
				curr = curr.getnext();
			}
			System.out.print(" --> " + curr.getdata());
			System.out.println(" --> NULL");
		}
		//System.out.println("size = " + this.getsize());
	}
	
	public int getsize(){
		return this.size;
	}
}
