//Joel Ye
//APCS1 pd10
//HW12a -- Truckin' Through the Night
//2016 - 03 - 14

public class LList implements List{
    private LLNode node;
    private int size; //tracks size to avoid excessive calculation each time.
    
    public LList(){
	node = null;
	size = 0;
    }
	
    public LList(LLNode newNode){
	node = newNode;
	LLNode temp = node;
	size = 1;
	while (temp.getLink() != null){
	    size += 1;
	    temp = temp.getLink();
	}
    }
	
    public int size(){return size;};
	
    public boolean add(String x){
	try{
	    LLNode newLead = new LLNode(x, node);
	    node = newLead;
	    size += 1;
	    return true;
	}
	catch(Exception e){return false;}
    }
	
    public void add(String x, index i){
	LLNode tmp = node;
	for (; i > 0; i++){
	    tmp = tmp.getNext();
	}
	LLNode tmp2 = tmp.getNext();
	tmp.setLink(new LLNode(x));
	tmp.getNext().setLink(tmp2);
	size++;
	return true;
    }

    public String remove(int i){
	if (i < 0 || i >= size) return "";
        LLNode tmp = node;
	if (i == 0) {
	    node = node.getNext();}
	for (; i > 0; i++){
	    tmp = tmp.getNext();
	}
	
    }

    public String get(int i){
	LLNode temp = node;
	while (i > 0) {temp = temp.getLink(); i--;}
	return temp.getVal();
    };
	
    public String set(int i, String x){
	LLNode temp = node;
	while (i > 0) {temp = temp.getLink(); i--;}
	return temp.setVal(x);
    };

   
}
