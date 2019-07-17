package test;

import java.util.Scanner;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class Algo2 {

	static int[] bong;
	static int n;
	static int min = Integer.MAX_VALUE;
	static int[] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tCount = sc.nextInt();
		
		for(int t = 1; t <= tCount; t++) {
			int w = sc.nextInt();
			n = sc.nextInt();
			bong = new int[n];
			memo = new int[5001];
			
			for(int i = 0; i < n; i++) {
				bong[i] = sc.nextInt();
			}
			Arrays.sort(bong);
			bfs(w);
			if(min == Integer.MAX_VALUE) {
				System.out.printf("#%d %d\n", t, -1);
			}else {
				System.out.printf("#%d %d\n" ,t , min);
			}
			
		}
	}
	
	public static void bfs(int w) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(w, 0));
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			if(tmp.w == 0) {
				min = tmp.cnt;
				break;
			}
			if(tmp.w < 0) {
				continue;
			}
			if(memo[tmp.w] == 1) {
				continue;
			}
			for(int i = 0; i < n; i++) {
				q.offer(new Node(tmp.w-bong[i], tmp.cnt+1));
				memo[tmp.w] = 1;
			}
		}
	}
	
	public static class Node{
		int w;
		int cnt;
		public Node(int w, int cnt) {
			this.w = w;
			this.cnt = cnt;
		}
	}
}

