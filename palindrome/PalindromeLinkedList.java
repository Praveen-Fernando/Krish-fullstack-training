public class PalindromeLinkedList{
	
	//Node of the singly linked list    
    class Node{
    	
        char data;    
        Node next;    
            
        public Node(char data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    int size = 0;
    Node firstNode = null; //first node of the singly linked list    
    Node lastNode = null; //last node of the singly linked list   
        
    //add a new node to the list    
    public void addNode(char data) {     
        Node node = new Node(data);    
        if(firstNode == null) {    
        	firstNode = node;   
        }    
        else {    
        	lastNode.next = node; 
        }  
        lastNode = node;  
        size++;
    }    
    
    public Node getPreviousNode(Node node){
        Node current = node;
        Node prevNode = null, nextNode = null;

        while(current != null){
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        return prevNode;
    }
    
    public boolean isPalindrome() {
    	Node current = firstNode;  
    	int middle = 0;
    	
    	// define middle position
    	if(size % 2 == 0) {
    		middle = size/2;
    	}else {
    		middle = (size+1)/2;
    	}
    	
    	// set current node to middle
    	for(int i = 1; i < middle; i++){
            current = current.next;
        }
    	
    	Node prevNode = getPreviousNode(current.next);

        while(firstNode != null && prevNode != null){
            if(!(firstNode.data==prevNode.data)){
                return false;
            }
            firstNode = firstNode.next;
            prevNode = prevNode.next;
        }
    	
    	return true;	
    }

	public static void main(String[] args) {
		
		PalindromeLinkedList list = new PalindromeLinkedList();
      
		list.addNode('P');    
		list.addNode('R');    
		list.addNode('A');    
		list.addNode('V');
		list.addNode('E');    
		list.addNode('E');    
		list.addNode('N');      
		    
		if (list.isPalindrome()) {
			System.out.println("LinkedList is Palindrome");
		}else {
			System.out.println("LinkedList is not Palindrome");
		}

	}

}