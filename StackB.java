import java.util.*;

public class StackB {
    public static void PushBottem(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        PushBottem(s, data);
        s.push(top);
    }

    public static String ReverseStr(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx != str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while (!s.isEmpty()) {
            char ch = s.pop();
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void ReverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        ReverseStack(s);
        PushBottem(s, top);

    }

    public static void stockSpan(int stock[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stock.length; i++){
            int currPrice = stock[i];
            while (!s.isEmpty() && currPrice>=stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i]=i+1;
            }else{
                int prevHigh = s.peek();
                span[i]= i - prevHigh;

            }
            s.push(i);
        }
    }    

    public static void main(String[] args) {

        // PushBottem
        // Stack<Integer> s = new Stack<>();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // PushBottem(s, 4);
        // while (!s.isEmpty()) {
        // System.out.println(s.pop());
        // }

        // reverse string
        // String str = "sujeet";
        // System.out.println(ReverseStr(str));

        // reverse stack
        // Stack<Integer> s = new Stack<>();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // ReverseStack(s);

        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        //4) StockSpan

        // int stock[] = {100,80,60,70,60,80,100};
        // int span[] = new int[stock.length];
        // stockSpan(stock, span);

        // for(int i=0; i<span.length; i++){
        //     System.out.println(span[i] +" ");
        // }

        // 5 Next greater Right side
        int arr[]={2,1,5,6,2,3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];
        
        for(int i=arr.length-1; i>=0; i--){
            // i)while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // ii)if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }

            // iii)nextgreater
            s.push(i);
        }
        for(int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i] +" ");
        }
        System.out.println();



    }
}
