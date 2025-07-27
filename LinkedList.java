public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // creat new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // 2) newNodes next --> head
        newNode.next = head;// link

        // step-3;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;// link

        tail = newNode;

    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int Search(int key) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == key) {
                return i;
            } else {
                temp = temp.next;
            }
        }
        return -1;
        // we can also use
        // Node temp = head;
        // int i = 0;
        // while(temp != null){
        // if (temp.data == key) {
        // return i;
        // }else{
        // temp = temp.next;
        // i++;
        // }
        // }
        // return -1;
    }

    public int helpfunc(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int idx = helpfunc(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int RecSearch(int key) {
        return helpfunc(head, key);
    }

    public void Reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Find and remove nth node from end
    public void remove_nth_from_end(int n) {
        // find size of LinkedList
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        // if we want to remove nth element form end, and size is also equel to n, so
        // basically we are removing head,
        if (n == sz) {
            head = head.next;
            return;
        }
        // find the previous element of nth one, so we can point previous. next --->
        // current's next, next;
        int i = 1;
        Node prev = head;
        while (i < sz - n) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // check palindrome
    // i) find middle
    public Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        // base case
        if (head == null || head.next == null) {
            return true;
        }
        // i) find middle
        Node mid = findMiddle(head);
        // ii) reverse the 2nd half
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev; // this will be head of second half

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public  void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static boolean iscycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2

            // if this satisfied it means cycle exist...
            if (slow == fast) {
                return true;
            }
        }
        // this means our list is in linear manner
        return false;
    }
    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        // find the point where joint occer
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // make final node as null
        prev.next = null;
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
        // insted of using this we will use methods.

        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.add(2, 3);
        // ll.print();

        // System.out.println(ll.size);

        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();

        // System.out.println(ll.RecSearch(5));

        // ll.Reverse();
        // ll.print();

        // ll.remove_nth_from_end(3);
        // ll.print();

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print();

        // System.out.println(ll.isPalindrome());

    //     head = new Node(1);
    //     Node temp = new Node(2);
    //     head.next = temp;
    //     head.next.next = new Node(3);
    //     head.next.next.next = temp;
    //    System.out.println(iscycle());
    //    removeCycle();
    //    System.out.println(iscycle());
        
        

    }
}
