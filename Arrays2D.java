public class Arrays2D {
    /**
     * @param arr
     */
    public static void SpiralMatrix(int arr[][]) {
        int sr = 0;
        int sc = 0;
        int er = arr.length - 1;
        int ec = arr[0].length - 1;

        while (sr <= er && sc <= ec) {
            // top
            for (int j = sc; j <= ec; j++) {
                System.out.println(arr[sr][j]);
            }
            // left
            for (int i = sr + 1; i <= er; i++) {

                System.out.println(arr[i][ec]);
            }
            // bottom
            for (int j = ec - 1; j >= sc; j--) {
                if (sr == er) {
                    break;
                }
                System.out.println(arr[er][j]);
            }
            // right
            for (int i = er - 1; i >= sr + 1; i--) {
                if (sc == ec) {
                    break;
                }
                System.out.println(arr[i][sc]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }

    }

    public static int Digonal_sum(int arr[][]) {
        int sum = 0;
        // for(int i=0; i<arr.length; i++){
        // for(int j=0; j<arr[0].length; j++){
        // if (i == j) {
        // sum += arr[i][j];
        // }else if (i + j == arr.length-1) {
        // sum += arr[i][j];
        // }
        // }
        // }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            if (i != arr.length - 1 - i) {
                sum += arr[i][arr.length - 1 - i];
            }
        }
        return sum;
    }

    public static void Search(int arr[][], int key) {
        int row = 0;
        int col = arr.length-1;
        while (row<arr.length && col>=0) {
            if (arr[row][col] == key) {
            System.out.println("("+row+","+col+")");
            return ;
        }else if (key > arr[row][col]) {
            row ++;
        }else{
            col--;
        }
        }
        System.out.println("key not found");
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int key = 112;

        // for(int i=0; i<arr.length; i++){
        // for(int j=0; j<arr[0].length; j++){
        // System.out.println(arr[i][j]);
        // }
        // }

        // SpiralMatrix(arr);
        // System.out.println(Digonal_sum(arr));
        Search(arr, key);
    }
}
