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
