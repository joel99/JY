//Team Double Trouble - Joel Ye and Jennifer Yu
//APCS1 pd10
//HW15 -- Generically Speaking
//2016 - 03 - 17
public class LList<T> implements List{
    private DLLNode head;
    private DLLNode tail;
    private int size; //tracks size to avoid excessive calculation each time.
    
    public LList(){ //default constructor
	head = null;
	size = 0;
    }
        
    public int size(){return size;}; //size
	
    public boolean add(DLLNode blah){ //add
	try{
	    if (size == 0) {
		DLLNode newHead = new DLLNode (x, null, null);
		head = newHead; //new node is the new head
	    }
	    else {
		DLLNode newHead = new DLLNode(x); //create alias for new node
		newHead.setNext(head); //set next as the formerly-first node
		head.setPrev(newHead); //set formerly-first node's previous to new node
		head = newHead; //new node is the new head
	    }
	    size ++; //increment size
	    return true; //it worked!
	}
	catch(Exception e){return false;} //it didn't work...
    }

    public void add(int i, String x){ //add-at-index
	if ( i < 0 || i > size ) //index is in range
	    throw new IndexOutOfBoundsException();
	if (i == 0) {
	    add(x); 
	    return;} //if adding to front, use add
	DLLNode tmp = head; //set alias to the head
	for (; i > 0; i--) {tmp = tmp.getNext();} //for tmp node at index
	tmp.getPrev().setNext(new DLLNode(x)); //for tmp's previous' next, set next as new node
	tmp.getPrev().getNext().setNext(tmp); //for new node, set next as tmp
	tmp.setPrev(tmp.getPrev().getNext());
	size++; //increment size
    }	

    public String remove(int i){ //remove
	if ( i < 0 || i >= size ) //if not in range
	    throw new IndexOutOfBoundsException();
	size--;
	DLLNode temp = head; //set alias to the head
	if (i == 0) { //if removing first node
	    head = head.getNext(); //set next node as new head
	    head.setPrev(null); //cut it off from removed node
	    return temp.getVal();} //return alias of old head
	for (; i > 0; i--){ //if removing another node
	    temp = temp.getNext(); //set alias to node at index
	}
	String ret = temp.getVal(); //store first value
	temp.getPrev().setNext(temp.getNext()); //set prev node's next to next
	if (temp.getNext() != null)
	    temp.getNext().setPrev(temp.getPrev()); //set next node's prev to prev
	return ret; //return stored value
    }

    public T get(int i){
	DLLNode temp = head;
	while (i > 0) {temp = temp.getNext(); i--;}
	return temp.getVal();
    };
	
    public String set(int i, String x){
	DLLNode temp = head;
	while (i > 0) {temp = temp.getNext(); i--;}
	temp.setVal(x);
	return x;
    };

    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getVal() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }

    public static void main( String[] args ) {

	DLList james = new DLList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add(0,"whut");
	System.out.println( "...after add(0,whut): " );
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james );
	
	System.out.println( "size: " + james.size() );

	System.out.println( "...after remove last: " 
			    + james.remove( james.size()-1 ) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james );
    }//end main

}

/**
 //Team JY - Joel Ye and Jennifer Yu
 //APCS1 pd10
 //HW14a -- On the DLL
 //2016 - 03 - 16

 public class LList implements List{
 private DLLNode head;
 private int size; //tracks size to avoid excessive calculation each time.
    
 public LList(){
 head = null;
 size = 0;
 }
	
 public LList(DLLNode newNode){
 head = newNode;
 DLLNode temp = head;
 size = 1;
 while (temp.getNext() != null){
 size += 1;
 temp = temp.getNext();
 }
 }
	
 public int size(){return size;};
	
 public boolean add(String x){
 try{
 DLLNode newHead = new DLLNode(x);
 newLead.setNext(head);
 head.setPrev(newHead);
 head = newHead;
 size ++;
 return true;
 }
 catch(Exception e){return false;}
 }

 public void add(String x, int i){
 if ( i < 0 || i > size() )
 throw new IndexOutOfBoundsException();
 size++;
 if (i == 0) {add(x); return;}
 DLLNode tmp = head;
 for (; i > 0; i--) tmp = tmp.getLink();
 tmp.getPrev.setNext(new DLLNode(x));
 tmp.setPrev(tmp.getPrev().getNext());
 }	

 public String remove(int i){
 if ( i < 0 || i >= size() )
 throw new IndexOutOfBoundsException();
 size--;
 DLLNode temp = head;
 if (i == 0) {
 head = head.getNext();
 head.setPrev(null);
 return temp.getVal();}
 for (; i > 0; i--){
 temp = temp.getLink();
 }
 String ret = temp.getVal();
 temp.getPrev().setNext(temp.getNext());
 temp.getNext().setPrev(temp.getPrev());
 return ret;
 }

 public String get(int i){
 DLLNode temp = head;
 while (i > 0) {temp = temp.getNext(); i--;}
 return temp.getVal();
 };
	
 public String set(int i, String x){
 DLLNode temp = head;
 while (i > 0) {temp = temp.getNext(); i--;}
 return temp.setVal(x);
 };

   
 }
**/
