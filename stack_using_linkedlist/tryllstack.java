class tryllstack{
	public static void main(String args[]){
		llstack lls = new llstack(5);
		lls.push(1);
		lls.push(2);
		lls.push(3);
		lls.push(4);
		lls.push(5);
		lls.push(6);
		lls.display();
		System.out.println("Popped : " + lls.pop());
		System.out.println("Popped : " + lls.pop());
		System.out.println("Popped : " + lls.pop());
		System.out.println("Popped : " + lls.pop());
		System.out.println("Popped : " + lls.pop());
		System.out.println("Popped : " + lls.pop());
		lls.display();
	}
}