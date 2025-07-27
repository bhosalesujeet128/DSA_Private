import java.util.*;

public class StackA {
    // implemention using arraylist
    // static class StackB {
    //     static ArrayList<Integer> list = new ArrayList<>();

    //     // isempty
    //     public static boolean isempty() {
    //         return list.size() == 0;
    //     }

    //     // push--> add
    //     public static void Push(int data) {
    //         list.add(data);
    //     }

    //     // pop--> remove
    //     public static int Pop() {
    //         if (isempty()) {
    //             return -1;
    //         }
    //         int top = list.get(list.size() - 1);
    //         list.remove(list.size() - 1);
    //         return top;
    //     }

    //     // peak-->watch
    //     public static int peak() {
    //         if (isempty()) {
    //             return -1;
    //         }
    //         return list.get(list.size() - 1);
    //     }
    // }

    // implemention using linkedlist
    // static class Node {
    //     int data;
    //     Node next;

    //     public Node(int data) {
    //         this.data = data;
    //         this.next = next;
    //     }

    // }

    // static class StackC {
    //     static Node head = null;

    //     // isempty
    //     public static boolean isempty() {
    //         return head == null;
    //     }

    //     // push
    //     public static void push(int data) {
    //         Node newNode = new Node(data);

    //         if (isempty()) {
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;
    //     }

    //     // pop
    //     public static int pop() {
    //         if (isempty()) {
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }

    //     // peak
    //     public static int peak() {
    //         if (isempty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }

    public static void main(String[] args) {
        //1) implemention of arraylist
        // StackB s = new StackB();
        // s.Push(1);
        // s.Push(2);
        // s.Push(3);
        // s.Push(4);
        // // ! (not) operator reverses the result.
        // // s.isempty() becomes true, and !s.isempty() becomes false, so the loop stops.
        // while (!s.isempty()) {
        //     System.out.println(s.peak());
        //     s.Pop();
        // }

        //2) implemention of linkedlist
        // StackC ss = new StackC();
        // ss.push(1);
        // ss.push(2);
        // ss.push(3);
        // ss.push(4);
        // ss.push(5);
        // while (!ss.isempty()) {
        //     System.out.println(ss.peak());
        //     ss.pop();
        // }

        // 3) implemention using java Frame work
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        
    }
}
