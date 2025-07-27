import java.util.*;
import java.util.LinkedList;

public class QueueB {

    static class QueueA {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void First_non_repeating(String str) {
        int arr[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            q.add(ch);
            arr[ch - 'a']++;
            while (!q.isEmpty() && arr[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();

    }

    public static void Interleave(Queue<Integer> q) {
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firsthalf.add(q.remove());
        }
        while (!firsthalf.isEmpty()) {
            q.add(firsthalf.remove());
            q.add(q.remove());
        }
    }
    public static void Reverse(Queue<Integer> q ){
        Stack<Integer> s = new Stack<>();
       while (!q.isEmpty()) {
         s.push(q.remove());
       }
       while (!s.isEmpty()) {
        q.add(s.pop());
       }
    }
    public static void main(String[] args) {
        // Queue q = new Queue();

        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        // System.out.println(q.peek());
        // q.remove();
        // }

        // -------------------------------------------------------------
        // String str = "aabccxb";
        // First_non_repeating(str);

        // -------------------------------------------------------------
        // Queue<Integer> q = new LinkedList<>();

        // q.add(1);
        // q.add(2);
        // q.add(3);
        // q.add(4);
        // q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);

        // Interleave(q);

        // while (!q.isEmpty()) {
        // System.out.print(q.remove()+ " ");
        // }
        // System.out.println();
        // -------------------------------------------------------------

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
     Reverse(q);
         while (!q.isEmpty()) {
        System.out.print(q.remove()+ " ");
        }
        System.out.println();
    }
}
