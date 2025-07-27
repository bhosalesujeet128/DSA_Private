
import java.util.*;
import java.util.Arrays;

public class GreedyAlgo {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }

    }

    public static void main(String[] args) {

        // 1)Activity selection
        // first write program for sorted one, and make changes for unsorted.
        // int start[] = {1,3,0,5,8,5};
        // int end[] = {2,4,6,7,9,9};
        // // sorting
        // int activity[][]=new int[start.length][3];
        // for(int i=0; i<start.length; i++){
        // activity[i][0]= i;
        // activity[i][1]=start[i];
        // activity[i][2]=end[i];
        // }
        // int maxactivity = 0;
        // Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));
        // // 1 activity
        // ArrayList<Integer> al = new ArrayList<>();
        // maxactivity = 1;
        // al.add(activity[0][0]);
        // int lastactivity = activity[0][2];

        // for(int i=1; i<end.length; i++){
        // if (activity[i][1] >= lastactivity) {
        // maxactivity++;
        // al.add(activity[i][0]);
        // lastactivity = activity[i][2];

        // }
        // }
        // System.out.println(maxactivity);
        // for(int i=0; i<al.size(); i++){
        // System.out.print("A"+al.get(i)+" ");
        // }

        // ---------------------------------------------------------------------------------
        // 2) Fraction knapsack
        // int val[] = { 60, 100, 120 };
        // int weight[] = { 10, 20, 30 };
        // int w = 50;

        // // make 2d array to sort ratio(val/weight);
        // double ratio[][] = new double[val.length][2];
        // for (int i = 0; i < val.length; i++) {
        // ratio[i][0] = i;
        // ratio[i][1] = val[i] / (double) weight[i];
        // }
        // Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // int capacity = w;
        // int finalval = 0;
        // for (int i = ratio.length - 1; i >= 0; i--) {
        // int idx = (int)ratio[i][0];
        // if (capacity >= weight[idx]) {
        // finalval+=val[idx];
        // capacity -= weight[idx];
        // }else{
        // finalval += (ratio[i][1]*capacity);
        // capacity = 0;
        // break;
        // }
        // }
        // System.out.println("final val = " + finalval);

        // ---------------------------------------------------------------------------------
        // 3) Minimum absolute difference;
        // int A[] = { 4, 1, 8, 7 };
        // int B[] = { 2, 3, 6, 5 };

        // Arrays.sort(A);
        // Arrays.sort(B);

        // int mindiff = 0;
        // for (int i = 0; i < A.length; i++) {
        // {
        // mindiff += Math.abs(A[i] - B[i]);
        // }
        // }
        // System.out.println(mindiff);

        // ---------------------------------------------------------------------------------
        // // 4) Max Length chain of pairs
        // int pair[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        // Arrays.sort(pair, Comparator.comparingDouble(o -> o[1]));

        // int MaxLength = 1;

        // int lastend = pair[0][1];
        // for (int i = 1; i < pair.length; i++) {

        // if (pair[i][0] >= lastend) {
        // MaxLength++;
        // lastend = pair[i][1];
        // }
        // }
        // System.out.println(MaxLength);

        // ---------------------------------------------------------------------------------
        // 5) Indian coin
        // int coin[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        // int amount = 590;

        // ArrayList<Integer> coinsused = new ArrayList<>();
        // int no_coin = 0;
        // for (int i = coin.length - 1; i >= 0; i--) {
        // if (coin[i] <= amount) {
        // while (coin[i] <= amount) {
        // no_coin = no_coin + 1;
        // coinsused.add(coin[i]);
        // amount = amount - coin[i];
        // }
        // }
        // }
        // System.out.println(no_coin);
        // for (int i = 0; i < coinsused.size(); i++) {
        // System.out.print(coinsused.get(i) + " ");
        // }
        // --------------------------------------------------------------
        // Job secquencing problem
        // int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        // ArrayList<Job> jobs = new ArrayList<>();

        // for (int i = 0; i < jobInfo.length; i++) {
        // jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        // }

        // Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);
        // // decending order of profit

        // ArrayList<Integer> seq = new ArrayList<>();
        // int time = 0;
        // for(int i=0; i<jobs.size(); i++){
        // Job curr = jobs.get(i);
        // if (curr.deadline > time) {
        // seq.add(curr.id);
        // time++;
        // }

        // }
        // System.out.println("max jobs = "+seq.size());
        // for(int i=0; i<seq.size(); i++){
        // System.out.print(seq.get(i)+" ");
        // }
        // System.out.println();
        // --------------------------------------------------------------
        // Chocola problem
        int n = 4, m = 6;
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0; // tack cuts,
        int hp = 1, vp = 1; // track pices
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costHor[h] <= costVer[v]) {
                cost += costVer[v] * hp;
                vp++;
                v++;
            } else {
                cost += costHor[h] * vp;
                hp++;
                h++;
            }
        }
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        System.out.println("min cost of cuts " +cost);
    }
}
