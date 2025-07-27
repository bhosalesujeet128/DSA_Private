public class LLP2 {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = next;
        }

    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mearg(Node head1, Node head2) {
        Node newMearg = new Node(-1);
        Node temp = newMearg;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
        }
        while (head2 != null) {
             temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
        }
        return newMearg.next; // this will be our final op, which will point to accurate sorted list...
    }

    public Node meargsort(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // call mearg for left and right head
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = meargsort(head);
        Node newRight = meargsort(rightHead);
        // mearg
        return mearg(newLeft, newRight);
    }

    public void zigzak(){
        // i) find mid 
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // Reverse  the right half 
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        Node left = head;
        Node right = prev;
        Node nextLeft;
        Node nextRight;

        while (left != null && right != null) {
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }
    public static void main(String[] args) {
        LLP2 ll = new LLP2();

        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        // ll.head =  ll.meargsort(ll.head);
        ll.zigzak();
        ll.print();
    }
}
