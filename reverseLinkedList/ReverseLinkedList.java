
public class ReverseLinkedList {  
	
    //Node of the singly linked list    
    class Node{
    	
        int data;    
        Node next;    
            
        public Node(int data) {    
            this.data = data;    
            this.next = null;    
        }    
    }    
     
    public Node firstNode = null; //first node of the singly linked list    
    public Node lastNode = null; //last node of the singly linked list   
        
    //add a new node to the list    
    public void addNode(int data) {     
        Node node = new Node(data);    
        if(firstNode == null) {    
        	firstNode = node;   
        }    
        else {    
        	lastNode.next = node; 
        }  
        lastNode = node;   
    }    
        
    //display nodes
    public void view() {    
        Node current = firstNode;    
            
        if(firstNode == null) {    
            System.out.println("List is empty");    
            return;    
        }   
        while(current != null) {
            System.out.print(current.data + " ");    
            current = current.next;    
        }    
        System.out.println();    
    }  
    
  //Reverse from end node to the first node
    public void reverseSingularList(){
        if(firstNode != null && lastNode != null){
            Node current = firstNode;
            Node previousNode = lastNode;
            Node nextNode = null;

            while(current != previousNode){
                previousNode.next = current;
                firstNode = current.next;
                lastNode = current;
                current.next = null;
                if (nextNode != null) {
                	lastNode.next = nextNode;
                }
                current = firstNode;
                nextNode = previousNode.next;
            }
        }
    }

        
    public static void main(String[] args) {    
            
        ReverseLinkedList list = new ReverseLinkedList();    
               
        list.addNode(1);    
        list.addNode(9);    
        list.addNode(9);    
        list.addNode(8);    
             
        System.out.println("Current Order : ");
        list.view();
        list.reverseSingularList();
        System.out.println("Reversed Order : ");
        list.view();
        
    }    
}    