public class DoublelyLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head; // link front
        head.prev = newnode; // link back
        head = newnode; // update node to new added element
    }

    public void addLast(int data){
        Node newnNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnNode;
            return;
        }
        tail.next = newnNode;
        newnNode.prev = tail;
        tail = newnNode;
    }

    public int removeFirst(){
        if (head == null || head.next == null) {
            System.out.println("empty");
            size = 0;
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }
    public int removeLast(){
        if (head == null || head.next == null) {
            System.out.println("empty");
            return Integer.MIN_VALUE;
        }
        // we have to find previous;
        Node prev = head;
        for(int i=0; i<size-2; i++){
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail.prev = prev;
        tail = prev;
        size--;
        return val;
        
    }
    
    public void print(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data +"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublelyLL dll = new DoublelyLL();

        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        dll.print();
        // dll.removeFirst();
        // dll.print();
        dll.removeLast();
        dll.print();
        System.out.println(size);
        
    }
}
