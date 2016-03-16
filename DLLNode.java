//Team JY - Joel Ye and Jennifer Yu
//APCS1 pd10
//HW14a -- On the DLL
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
	this.next = next;
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
    public DLLNode setNext(DLLNode newNext){
	DLLNode temp = next;
	next = newNext;
	return temp;
    }

    public DLLNode getPrev(){
	return prev;
    }
    public DLLNode setPrev(DLLNode newPrev){
	DLLNode temp = prev;
	prev = newPrev;
	return temp;
    }
}
