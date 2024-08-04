class BrowserHistory {
    class Node{
        Node next;
        Node prev;
        String data;
        Node(String data){
            this.data = data;
        }
    }
    Node head;
    Node tail;
    int size;

    public BrowserHistory(String homepage) {
        Node newNode = new Node(homepage);
        head = newNode;
        tail = newNode;
        size = 1;
    }
    
    public void visit(String url) {
        tail.next=  null;
        size = size(head);
        Node nd = new Node(url);
        tail.next = nd;
        nd.prev = tail;
        tail = tail.next;
        size++;
    }
    
    public String back(int steps) {
        if(steps >= size){
            tail = head;
            return head.data;
        }

        while(steps -- >0 && tail.prev != null){
            tail = tail.prev;
        }
        return tail.data;
    }
    
    public String forward(int steps) {
        while(steps --> 0 && tail.next != null){
            tail = tail.next;
        }
        return tail.data;
    }

    public int size(Node head){
        if(head == null){
            return 0;
            
        }
        Node temp = head;
        int size= 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */