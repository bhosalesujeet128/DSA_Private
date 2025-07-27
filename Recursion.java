public class Recursion {
    //1) print the n to 1 natural numbar in increasing order
    public static void DecOrder(int n){
        if (n == 1) {
            System.out.print(1+" ");
            return;
        }
        System.out.print(n+" ");
        DecOrder(n-1);
    }

    //2) print the n to 1 natural numbar in increasing order
     public static void IncOrder(int n){
        if (n == 1) {
            System.out.print(1+" ");
            return;
        }
        IncOrder(n-1);
        System.out.print(n+" ");
    }

    //3) calculate the factorial 
    public static int Fact(int n){
        if (n == 0) {
            return 1;
        }
    //    int fnm1 = Fact(n-1);
    //    int fn = n * fnm1; // 5*24
    int fn = n * Fact(n-1);
       return fn;
    }

    //4) calculate the sum of first n natural number
    public static int Sum(int n){
        if (n == 1) {
            return 1;
        }
        // int sum = n + Sum(n-1);
        // return sum;
        return n + Sum(n-1);
    }

    //5) find the nth tearm in fibonachi series 
    public static int fib(int n){
        if (n == 0 || n == 1) {
            return n;
        }
        int ans = fib(n-1) + fib(n-2);
        return ans;
    }

    //6) check if array is sorted or not...
    public static boolean isSorted(int arr[], int i){
        if (i == arr.length-1) {
            return true;
        }
        if (arr[i]>arr[i+1]) {
            return false;
        }
       return isSorted(arr, i+1);
    }

    //7) check the first occarance of number in array
    // in this first we compare and if not found then goes to i++
    public static int First(int arr[], int i, int key){
        if (i  == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return First(arr, i+1, key);
    }
    //8) check the Last occarance of number in array
    // in this fist we went to last element by isfound and then compare with key.
    public static int Last(int arr[], int i, int key){
        if (i  == arr.length) {
            return -1;
        }
        int isfound = Last(arr, i+1, key); // this will gives value -1 at the end and will pass ahead.
        if (isfound == -1 && arr[i] == key) {
            return i;
        }// now is found is -1 always so it will true, 
        //only thing is to check key with ith element if found then return i else return -1(isfound)
        return isfound;
    }
    //9) print x to the power n(x^n)hint--->(2^10)-->(2*2^9)--->(2*2*2^8)....
    public static int power(int x, int n){
        if (n==0) {
            return 1;
        }
        return x*power(x, n-1);
    }
    //10) optimal way of power:-->(2^10)-->(2^5*2^5)-->(x^n/2)*(x^n/2)...
    //if odd just do (2^7)-->(2*2^3*2^3)
    public static int powerOp(int x, int n){
        if (n == 0) {
            return 1;
        }
        int power = powerOp(x, n/2)*powerOp(x, n/2);
        if (n % 2 != 0) {
            power = x * power;
        }
        return power;
    }

    // 11)Given a "2 x n" Floar and tiles of size "2 x 1", count the number of ways to tile the given board
    // using the 2 x 1 tiles.(A tile can either be placed horizontally or vertically. )
    public static int tilling(int n){
        //base case
        if (n==0 || n==1) {
            return 1;
        }
        //vertical choice
        int fnm1 = tilling(n-1);
        //horizontal choice
        int fnm2 = tilling(n-2);
        int total_ways = fnm1 + fnm2;
        return total_ways;

    }

    // 12) Remove duplicate in strings(appnnacollege)-->(apncoleg)
    public static void Remove_Duplicate(String str, StringBuilder newstr, boolean arr[], int i){
        if (i == str.length()) {
            System.out.println(newstr);
            return;
        }
        char currentchar = str.charAt(i);
        if (arr[currentchar-'a'] == true) {
            Remove_Duplicate(str, newstr, arr, i+1);
        }else{
            arr[currentchar - 'a'] = true;
            Remove_Duplicate(str, newstr.append(currentchar), arr, i+1);
        }
    }

    // 13) Given n friends, each one can remain single or can be paired up with some other friend.
    // Each friend can be paired only once. 
    //Find out the total number of ways in which friends can remain single or can be paired up.
    public static int Friends(int n){
        if (n == 1 || n == 2) {
            return n;
        }
        // choise- single
        int fnm1 = Friends(n-1);
        // choise-pair
        int fnm2 = Friends(n-2);
        int pair = ((n-1) * fnm2);
        int tota_pair = fnm1 + pair;
        return tota_pair;

    }
    // 14) Print all binary strings of size N without consecutive ones(11 not allowed 10100 like this allowed).
    public static void Binary_string(int n,int lastplace ,String str){
        if (n == 0) {
            System.out.println(str);
            return;
        }
        Binary_string(n-1, 0, str+"0");
        {
            if (lastplace == 0) {
                Binary_string(n-1, 1, str+"1");
            }
        }
    }
  


    
    public static void main(String[] args) {
        //int n = 6;
        //DecOrder(10);
        //IncOrder(n);
        //System.out.println(Fact(n));
        //System.out.println(Sum(n));
        //System.out.println(fib(n));

        // int arr[] =  {1,2,3,4,5};
        // System.out.println(isSorted(arr, 0));

        // int arr[] = {8,3,6,9,5,2,3,9};
        // int key = 9;
        // //System.out.println(First(arr, 0, key));
        // System.out.println(Last(arr, 0, key));

        // int x = 2;
        // int n = 3;
        // System.out.println(powerOp(x, n));

         System.out.println(tilling(5));
        
        // String str = "appnnacollege";
        // Remove_Duplicate(str, new StringBuilder(""), new boolean[26], 0);

        // System.out.println(Friends(5));

        // Binary_string(3, 0, "");
        

        

    }
}
