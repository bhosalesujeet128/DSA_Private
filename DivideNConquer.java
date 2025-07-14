public class DivideNConquer {
    //  1) MargSort
    public static void meargsort(int arr[], int si, int ei) {
        if (si>=ei) {
            return;
        }
        int mid = si + (ei-si)/2;
        meargsort(arr, si, mid);
        meargsort(arr, mid+1, ei);

        mearg(arr, si, mid, ei);
    }
    public static void mearg(int arr[], int si, int mid, int  ei){
        int temp[] = new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while (i<=mid && j<=ei) {
            if (arr[i]<arr[j]) {
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        while (i<=mid) {
            temp[k++]=arr[i++];
        }

        while (j<=ei) {
            temp[k++]=arr[j++];
        }

        for(k=0,i=si; k<temp.length; k++,i++){
            arr[i]=temp[k];
        }
    }
    // print function.
    public static void Print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //  2) QuickSort.
    public static void Quicksort(int arr[], int si, int ei){
         if (si>=ei) {
            return;
        }
        int pind = Partision(arr, si, ei);
        Quicksort(arr, si, pind-1);
        Quicksort(arr, pind+1, ei);
    }
    
    public static int Partision(int arr[], int si, int ei){
        int pivoit = arr[ei];
        int i = si-1;

        for(int j=si; j<ei; j++){
            if (arr[j] < pivoit) {
                i++;
                int temp = arr[j];
                arr[j]  = arr [i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivoit;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    // 3) search the key in sorted and rotated array...
    public static int Search(int arr[], int taret, int si, int ei){
        if (si>ei) {
            return -1;
        }

        int mid = si + (ei-si)/2;

        if (arr[mid] == taret) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {
            // case a: left part L1
            if (arr[si] <= taret && taret <= arr[mid]) {
                return Search(arr, taret, si, mid-1);
            }
            // case b: right part of L1
            else{
                return Search(arr, taret, mid+1, ei);
            }
        }
        
        else{
            // case c: left part if L2
            if (arr[mid] <= taret && taret<= arr[ei]) {
                return Search(arr, taret, mid+1, ei);
            }
            // case d : right part of L2
            else{
                return Search(arr, taret, si, mid-1);
            }
        }
        
    }
    public static void main(String[] args) {
        // int arr[] = { 6, 3, 9, 5, 2, 8 };
        // meargsort(arr, 0, arr.length-1);
        // Quicksort(arr, 0, arr.length-1);
        //  Print(arr);

        // int arr[]={4,5,6,7,0,1,2};
        // int taret =22;
        // int ind = Search(arr, taret, 0, arr.length-1);
        // System.out.println(ind);
    }
}