import java.util.*;

public class ArrayLists {

    // 1) max number in array list.
    public static void Max(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            // if (max<list.get(i)) {
            // max = list.get(i);
            // }
            max = Math.max(max, list.get(i));
        }
        System.out.println(max);
    }

    // 2) swap number at index1 with index3;
    public static void Sawp(ArrayList<Integer> list, int idx1, int ixd2) {
        int temp = list.get(idx1); // value at index will store in temp
        list.set(idx1, list.get(ixd2)); // will set value at index 2 at index1;
        list.set(ixd2, temp); // will set value of temp at inde2;
    }

    // 4) a] For given n lines on x-axis, use 2 lines to form a container such
    // that it holds maximum water. ---> O(n^2)
    public static int container(ArrayList<Integer> hight) {
        int totalwater = 0;
        for (int i = 0; i < hight.size(); i++) {
            for (int j = i + 1; j < hight.size(); j++) {
                int h = Math.min(hight.get(i), hight.get(j));
                int w = j - i;
                int currentwater = h * w;
                totalwater = Math.max(totalwater, currentwater);
            }
        }
        return totalwater;
    }

    // 4)b) optimised O(n)---> 2pointer approch
    public static int container_op(ArrayList<Integer> hight) {
        int totalwater = 0;
        int LP = 0;
        int RP = hight.size() - 1;
        while (LP < RP) {
            int h = Math.min(hight.get(LP), hight.get(RP));
            int w = RP - LP;
            int currentwater = h * w;
            totalwater = Math.max(totalwater, currentwater);

            if (hight.get(LP) < hight.get(RP)) {
                LP++;
            } else {
                RP--;
            }
        }
        return totalwater;
    }
 // 5) a)Find if any pair in sorted array has a target sum--> brut force O(n^2)
    public static void Pair_sum_1(ArrayList<Integer> list, int target){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
               if (list.get(i) + list.get(j) == target) {
                    System.out.println("pair is : ("+ list.get(i)+"," + list.get(j)+")");
                    return;
               }
            }
        }
        System.out.println("no pair found");
    }
    //  5)b) 2 pointer approch whith O(n)
    public static void Pair_sum_1OP(ArrayList<Integer> list, int target){
        int lp = 0;
        int rp = list.size()-1;

        while (lp<rp) {
            if (list.get(lp) + list.get(rp) == target) {
                System.out.println("pair is : ("+ list.get(lp)+"," + list.get(rp)+")");
                return; 
            }else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            }else{
                rp--;
            }
        }
        System.out.println("not found");
        return;
    }

     // 6) Find if any pair in sorted and rotated array has a target sum
     public static void Pair_sum_2(ArrayList<Integer> list, int target){
        int bp = -1;
        for(int i=0; i<list.size(); i++){
            if (list.get(i) > list.get(i+1)) {
                bp = i;
                break;
            }
        }
        int rp = bp;
        int lp = bp+1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                System.out.println("pair is : ("+ list.get(lp)+"," + list.get(rp)+")");
                return; 
            }else if (list.get(lp) + list.get(rp) < target) {
                lp = (lp+1)%list.size();  //(lp+1)%n
            }else{
                rp = (list.size()+rp-1)%list.size();  //(n+rp-1)%n
            }
        }
        System.out.println("not found");
        return;
     }
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(6);
        // list.add(3);
        // list.add(4);

        // Max(list);
        // Sawp(list, 1, 3);
        // ------------------------------------------------------------------------

        // 3) for forming and printing 2D array like structure
        // ArrayList<ArrayList<Integer>> newList = new ArrayList<>();

        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for(int i=1; i<=5; i++){
        // list1.add(i*1);
        // list2.add(i*2);
        // list3.add(i*3);
        // }
        // newList.add(list1);
        // newList.add(list2);
        // newList.add(list3);
        // System.out.println(newList);

        // for(int i=0; i<newList.size(); i++){
        // ArrayList<Integer> currentarray = newList.get(i);
        // for(int j=0; j<currentarray.size(); j++){
        // System.out.print(currentarray.get(j) +" ");
        // }
        // System.out.println();
        // }
        // --------------------------------------------------------------------------

        // // 4)For given n lines on x-axis, use 2 lines to form a container such
        // // that it holds maximum water. height = [1,8,6,2,5,4,8,3,7]

        // ArrayList<Integer> hight = new ArrayList<>();
        // hight.add(1);
        // hight.add(8);
        // hight.add(6);
        // hight.add(2);
        // hight.add(5);
        // hight.add(4);
        // hight.add(8);
        // hight.add(3);
        // hight.add(7);

        // System.out.println(container_op(hight));
        // --------------------------------------------------------------------------

        // 5) Find if any pair in sorted array has a target sum
        // ArrayList<Integer> list = new ArrayList<>();

        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // list.add(6);

        // int target=1;
        // Pair_sum_1(list, target);
        // Pair_sum_1OP(list, target);

         // --------------------------------------------------------------------------
        // 6) Find if any pair in sorted and rotated array has a target sum
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        Pair_sum_2(list,17);

    }

}