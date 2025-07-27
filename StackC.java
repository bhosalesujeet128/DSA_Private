import java.util.*;

public class StackC {

    public static boolean isvalid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                if (s.peek() == '(' && ch == ')' || s.peek() == '[' && ch == ']' || s.peek() == '{' && ch == '}') {
                    s.pop();
                }else{
                    return false;
                }

            }
        }
        if (s.isEmpty()) {
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; //duplicate found
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
    }
    public static void MaxArea(int hight[]){
        int maxarea = 0;
        int nml[] = new int[hight.length];
        int nmr[] = new int[hight.length];
        
        //  next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i=hight.length-1 ; i>=0 ; i--){
            while (!s.isEmpty() && hight[s.peek()] >= hight[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nmr[i] = hight.length;
            }else{
               nmr[i] = s.peek(); // just index
            }
            s.push(i);
        }
        // next smaller left
        s = new Stack<>();
        for(int i=0 ; i<hight.length ; i++){
            while (!s.isEmpty() && hight[ s.peek()]>= hight[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nml[i] = -1;
            }else{
               nml[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<hight.length; i++){
            int h = hight[i];
            int w = nmr[i]-nml[i]-1;
            int currarea = h*w;
            maxarea = Math.max(maxarea, currarea);
        }
        System.out.println("maxarea is : " +maxarea);
    }
    public static void main(String[] args) {
        // String str = "({[]})";
        // System.out.println(isvalid(str));

        // String str1 = "((a+b))"; // True--> duplice
        // String str2 = "(((a+b)+c)+d)"; //false-->not duplicate
        // System.out.println(isDuplicate(str1));
        // System.out.println(isDuplicate(str2));

        int hight[] =  {2,1,5,6,2,3};
        MaxArea(hight);

    }
}
