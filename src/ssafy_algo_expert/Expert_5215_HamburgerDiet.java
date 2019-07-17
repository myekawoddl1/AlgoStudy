package ssafy_algo_expert;

import java.util.Scanner;

public class Expert_5215_HamburgerDiet {
    static int T, TCount = 0, N, L, cal, sum, max = 0, count = 0;;
    static int material[][] = new int [10001][2];
    static int arr[] = new int [10001];
    static boolean vi[] = new boolean[10001];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while(TCount < T) {
            N = sc.nextInt();
            L = sc.nextInt();
            cal = 0;
            max = 0;
            
            for(int i = 0; i< N; i ++) {
                arr[i] = i;
                for(int j = 0; j < 2; j ++) {
                    material[i][j] = sc.nextInt();
                }
            }

            // 순열 구현
            //int arr[] = {0,1,2,3,4};
            
            for(int i = 0; i < N; i++) {
                DFS(i);
            }

            //System.out.println(count);


            TCount++;
            System.out.println("#" + TCount + " " + max);
        }
    }
    
    static void DFS(int here) {
    	sum += material[here][0];
        cal += material[here][1];
        if(cal > L) {
        	sum -= material[here][0];
            cal -= material[here][1];
            return;
        }
        
        vi[here] = true;
        
        for (int i = here; i < N; i++) {
            if (vi[i] == false) {
                DFS(i);
            }
            max = max < sum ? sum : max;
        }
        sum -= material[here][0];
        cal -= material[here][1];
        vi[here]= false;
    }

/*
    static void permutation(int[] arr, int depth, int n, int k) {
        if (depth == k) {
            printPermutation(arr, k);
            return;
        }
        // System.out.println();
        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permutation(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
        //System.out.println();

    }

    static void printPermutation(int[] arr, int k) {
        int sum = 0;
        int cal = 0;
        
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        
        
        for (int i = 0; i < k; i++) {
            cal += material[arr[i]][1];
            System.out.print("실시간 cal = " +  cal);
            if(cal > L) break;
            sum += material[arr[i]][0];
            System.out.println("\t실시간 sum = " +  sum);
        }
        System.out.println("max = " + max + " sum = " + sum);
        max = max < sum ? sum : max;
    }

    static void swap(int[] arr, int i, int j) {
        int temp;

        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/
}