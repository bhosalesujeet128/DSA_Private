public class BasicSortingAlgo {
    // 1) BubbleSort --> 
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

    // 2) Selection sortion  --> select the smallest and move it to front...
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

    // 3) Insertion sorting --> imagine as plasing cards
    public static void InsertionSort(int arr[]){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;

            while (prev>=0 && arr[prev]>arr[curr]) {
                arr[prev+1]=arr[prev];
                prev--;
            }

            arr[prev+1]=arr[curr];
        }
    }

    // 4) Counting sort --> use only if element in aary is not to large
    public static void CountingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            largest = Math.max(largest, arr[i]);
        }
        // largest = 7;

        int count[] =new int[largest+1];
        // initialize --> count = [0, 0, 0, 0, 0, 0, 0, 0]
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }
        // count becomes -->count = [0, 2, 1, 2, 2, 0, 0, 1]
        int j=0;
        for(int i=0; i<count.length; i++){
            while (count[i]>0) {
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
        // final sorted arr = [1, 1, 2, 3, 3, 4, 4, 7]
    }
    // print function
     public static void Print(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int arr[] = {5,4,1,3,2};
        System.out.println("After Sorting");
        
        // BubbleSort(arr);
        // Print(arr);

        // SelectionSort(arr);
        // Print(arr);

        // InsertionSort(arr);
        // Print(arr);
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        CountingSort(arr);
        Print(arr);
    }
}
