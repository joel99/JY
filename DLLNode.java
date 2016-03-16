//2016 - 03 - 16
public class DLLNode{
    private String val;
    private DLLNode next;
    private DLLNode prev;

    public DLLNode(String val){
	this.val = val;
    }
    public DLLNode(String val, DLLNode prev, DLLNode next){
	this.val = val;
	this.link = link;
    }
    public String getVal(){
	return val;
    }
    public String setVal(String newVal){
	String temp = val;
	val = newVal;
	return temp; 
    }
    public DLLNode getNext(){
	return next;
    }
    public DLLNode setNext(DLLNode newLink){
	DLLNode temp = next;
	next = newLink;
	return temp;
    }

    public DLLNode getPrev(){
	return prev;
    }
    public DLLNode setPrev(DLLNode newLink){
	DLLNode temp = prev;
	prev = newLink;
	return temp;
    }
}
