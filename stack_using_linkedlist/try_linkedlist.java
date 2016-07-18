class tryll{
	public static void main(String args[]){
		linkedlist ll = new linkedlist(7);
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(44,2);
		ll.add(4);
		ll.printll();
		ll.replace(77,3);
		ll.printll();
		ll.delete(2);
		ll.printll();
	}
}
