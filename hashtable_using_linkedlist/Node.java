public class Node{
	Node next;
	int data;
	
	public Node(int data){
		this(data,null);
	}
	
	public Node(int data, Node next){
		this.next = next;
		this.data = data;
	}
	
	public void setdata(int el){
		this.data = el;
	}
	
	public void setnext(Node nextnode){
		this.next = nextnode;
	}
	
	public int getdata(){
		return this.data;
	} 
	
	public Node getnext(){
		return this.next;
	}
}