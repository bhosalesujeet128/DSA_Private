public class BackTracking {

    // 1) given empty array first we have to print 1,2,3,4,5 and after it subtrant
    // (-2)
    // from each so finally array become -1,0,1,2,3
    public static void ChangeArr(int arr[], int index, int value) {
        if (index == arr.length) {
            Print(arr);// this will print arrey before (-2)
            return;
        }
        arr[index] = value;
        ChangeArr(arr, index + 1, value + 1);
        arr[index] = arr[index] - 2; // BackTracking Step, This will exicute after return statement.

    }

    // 2) Find subset of given String( ex. "abc" -->
    // "abc","ab,","ac","a","bc","b","c","null")
    public static void Subset(String str, int i, String ans) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // Yes choice
        Subset(str, i + 1, ans + str.charAt(i));
        // No choice
        Subset(str, i + 1, ans);
    }

    // 3) (n*n!)
    public static void Permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String Nerstr = str.substring(0, i) + str.substring(i + 1);
            Permutation(Nerstr, ans + curr);
        }
    }

    public static void Print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 4) Place N queens on an NxN chessboard such that no 2 queens can attack each other
    // its time com is O(n!)
    public static boolean N_Queens(char bord[][], int row) {
        if (row == bord.length) {
            count++;
            // PrintBord(bord);
            return true;
        }
        for (int j = 0; j < bord.length; j++) {
            if (issafe(bord, row, j)) {
                bord[row][j] = 'Q';
                if(N_Queens(bord, row + 1)){
                    return true;
                }
                bord[row][j] = 'x';
            }
        }
        return false;
    }
    public static boolean issafe(char bord[][], int row,int col){
        // vertical up
        for(int i=row-1; i>=0; i--){
            if (bord[i][col] == 'Q') {
                return false;
            }
        }

        // left up diagonal
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if (bord[i][j] == 'Q') {
                return false;
            }
        }

        // Right up diagonal
        for(int i=row-1,j=col+1; i>=0 && j<bord.length ; i--,j++){
            if (bord[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    public static void PrintBord(char bord[][]) {
        System.out.println("-----------------");
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord.length; j++) {
                System.out.print(bord[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int count = 0;

    // 5) Gridways (2^nm)
    public static int Gridways(int i, int j, int n, int m){
        if (i == n-1 && j ==m-1) {
            return 1; //condition for last cell
        }else if(i == n || j == m){
            return 0;
        }
        // right + down;
        return Gridways(i+1, j, n, m) + Gridways(i, j+1, n, m);

    }

    // 6) Gried ways in linear complexity  using mathematical formule
    // [(n-1)!+(m+1)!]/(n-1!)*(m-1)  ---> this will gives permutation ways 
    // let n=3,m=3 so in this case there are 2D(down)&2R(Right) total ways of p&c of this is our solution

    // 7)Sudoco
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        //base case
        if (row == 9 ) {
            return true;
        }
        // recursion
        int nextrow = row, nextcol=col+1;
        if(col+1==9){
            nextrow = row+1;
            nextcol = 0;
        }
        if (sudoku[row][col] !=0) {
            return sudokuSolver(sudoku, nextrow, nextcol);
        }
        for(int digit=1; digit<=9; digit++){
            if (isSafe_Sudoku(sudoku,row,col,digit)) {
                sudoku[row][col]=digit;
                if (sudokuSolver(sudoku, nextrow, nextcol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe_Sudoku(int sudoku[][],int row, int col, int digit){
        // is digit present in entire colume
        for(int j=0; j<9; j++){
            if (sudoku[row][j] == digit) {
                return false;
            }
        }
        // is digit present in entire row
        for(int i=0; i<9; i++){
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // is digit present in 3x3 grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void Print_suduko(int suduko[][]){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(suduko[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // int arr[] = new int[5];
        // ChangeArr(arr, 0, 1);
        // Print(arr);

        // String str = "abc";
        // // Subset(str, 0, "");
        // Permutation(str, "");

        // int n =3;
        // char bord[][] = new char[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         bord[i][j] = 'x';
        //     }
        // }
        // N_Queens(bord, 0);
        // System.out.println("Total ways to solve n_queen is :" +count);

        // if (N_Queens(bord, 0)) {
        //     System.out.println("solution is possible");
        //     PrintBord(bord);
        // }else{
        //     System.out.println("Solutin is not possible");
        // }

    //     int n=3,m=3;
    //    System.out.println( Gridways(0, 0, n, m));

    int sudoku[][]={ {0,0,8,0,0,0,0,0,0},
                     {4,9,0,1,5,7,0,0,2},
                     {0,0,3,0,0,4,1,9,0},
                     {1,8,5,0,6,0,0,2,0},
                     {0,0,0,0,2,0,0,6,0},
                     {9,6,0,4,0,5,3,0,0},
                     {0,3,0,0,7,2,0,0,4},
                     {0,4,9,0,3,0,0,5,7},
                     {8,2,7,0,0,9,0,1,3}};
    if (sudokuSolver(sudoku, 0, 0)) {
        System.out.println("solution exist");
        Print_suduko(sudoku);
    }else{
        System.out.println("suduko not exist");
    }
    }
}
