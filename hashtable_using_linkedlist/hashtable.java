class hashtable{
	private int siz;				//number of rows in the hash table
	private linkedlist[] hashtab;
	
	public hashtable(int siz){		//constructor
		this.siz = siz;
		hashtab = new linkedlist[siz];
		for (int y=0;y<siz;y++){
			hashtab[y] = new linkedlist();
		}
		System.out.println("Hashtable Initialized!");
	}
	
	public int hashfunc(int itx){
		int a = itx%10;
		return a;
	}
	
	public void add(int elem){
		System.out.println("To add to hashtable,"+elem);
		int key = hashfunc(elem);
		System.out.println("Hashfunction returned,"+key);
		hashtab[key].add(elem);
	}
	
	public void printhashtable(){
		for(int x=0;x<this.siz;x++){
			hashtab[x].printll();
		}
	}
}