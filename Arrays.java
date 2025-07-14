public class Arrays {

    public static int Linear_search(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // print largest in string
    public static int Largest(int arr[]) {
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static void Second_largest(int arr[]){
        if (arr.length<2) {
            System.out.println("need at least 2 element in array");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if (arr[i]>first) {
                second = first;
                first = arr[i];
            }else if(arr[i]>second && arr[i]!=first){
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE) {
            System.out.println("all the element in array are same");
        }else{
            System.out.println("second largest number in arry is :"+second);
        }
        
    }

    public static int Binary_search(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }
            if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Just print in reverst
    public static void Reverse(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    // actully reverse an array
    public static void Reverse_swip(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swap arr[start] and arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }

    // print pairs of given array -->(2,4)(2,6)(2,8)(2,10)(4,6)(4,8)...
    public static void Pairs(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void Subarrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k]);
                }
                System.out.println();
            }

        }
        System.out.println();
    }

    public static void MaxSubarrSum(int arr[]) {
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currentsum = 0;
                for (int k = i; k <= j; k++) {
                    currentsum += arr[k];
                }
                System.out.println(currentsum);
                if (maxsum < currentsum) {
                    maxsum = currentsum;
                }
            }
        }
        System.out.println("maxsum is :" + maxsum);
    }

    public static void MaxSubarrSumPrefixArr(int arr[]) {
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                currentsum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                System.out.println(currentsum);
                if (maxsum < currentsum) {
                    maxsum = currentsum;
                }
            }
        }
        System.out.println("maxsum is :" + maxsum);
    }

    public static void Kadan(int arr[]) {
        int currentsum = 0;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currentsum += arr[i];
            if (currentsum < 0) {
                currentsum = 0;
            }
            System.out.println(currentsum);
            if (maxsum < currentsum) {
                maxsum = currentsum;
            }

        }
        System.out.println(maxsum);
    }

    public static int TrappingRainwater(int hight[]) {
        int n = hight.length;

        // left boundry-max(hight[i],lb[i-1])
        int leftmax[] = new int[n];
        leftmax[0] = hight[0];
        for (int i=1; i<n; i++) {
            leftmax[i] = Math.max(hight[i], leftmax[i-1]);
        }

        // right boundrymax(hight[i],rb[i+1])
        int rightmax[] = new int[n];
        rightmax[n-1] = hight[n-1];
        for (int i=n-2; i>=0; i--) {
            rightmax[i] = Math.max(hight[i], rightmax[i+1]);
        }

        int trappedwater = 0;
        for (int i=0; i<n; i++) {
            // water level = min(left boundry, right boundry)
            int water_level = Math.min(leftmax[i], rightmax[i]);
            // trapped water = water level - hight
            trappedwater += water_level - hight[i];
        }
        return trappedwater;
    }

    public static int buyandsellstocks(int price[]){
        int buyprice = price[0];
        int maxprofit = 0;

        for(int i=1; i<price.length; i++){
            if (buyprice < price[i]) {
                int profit =price[i] - buyprice ;
                maxprofit = Math.max(maxprofit, profit);
            }else{
                buyprice = price[i];
            }
        }

        return maxprofit;
    }
    public static void main(String[] args) {
        // int arr[] = {2,4,6,8,10};
        // int key = 53;
        // System.out.println("key is at index : "+Linear_search(arr, key));
        // System.out.println("largest number in arr is : "+Largest(arr));
        // System.out.println("key is at index : "+Binary_search(arr, key));

        // Reverse(arr);
        // Reverse_swip(arr);
        // for(int i = 0; i<arr.length; i++){
        // System.out.print(arr[i]+" ");
        // }

        // Pairs(arr);
        // Subarrays(arr);

        // MaxSubarrSum(arr);
        // MaxSubarrSumPrefixArr(arr);
        // Kadan(arr);

        // int hight[] = {4,2,0,6,3,2,5};
        // System.out.println(TrappingRainwater(hight));

        // int price[] = {7,1,5,3,6,4};
        // System.out.println(buyandsellstocks(price));

        int arr[]={10,5,8,20,6,20,9};
        Second_largest(arr);
       
    }
}
