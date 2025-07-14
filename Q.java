public class Q {

    public static int tilling(int n){
        if (n == 0 || n==1) {
            return 1;
        }
        // if placed vertical
        int f1 = tilling(n-1);
        // if placed horizontal
       int f2 = tilling(n-2);

      int total_ways = f1+f2;
        return total_ways;
    }

    public static String Remove(boolean arr[], String str, StringBuilder sb){
        for(int i=0; i<str.length(); i++){
            if (arr[str.charAt(i)-'a'] == true) {
                sb.append("");
            } else {
                arr[str.charAt(i)-'a'] = true;
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static int Friends(int n){
        if (n ==1 || n==2) {
            return n;
        }
        //choice single
        int f1 = Friends(n-1);
        // choice pair
        int f2 =(n-1)*Friends(n-2);

        // total
        int total = f1 + f2;
        return total;
    }

    public static void BubbleSort(int arr[]){
        int n=arr.length;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void SelectionSort(int arr[]){
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            int minpos = i;
            for(int j=i+1; j<n; j++){
                if (arr[minpos] >  arr[j]) {
                    minpos = j;
                }
            }
            int temp = arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;
        }
    }

     public static void Print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       
        // String str = "aapnaacoollagee";
        // System.out.println(Remove(new boolean[26], str, new StringBuilder("")));

        int arr[] = {5,4,1,3,2};
        Print(arr);
        SelectionSort(arr);
        Print(arr);
        

    }
}
