package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Expert_1231_InorderTraversal {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb;// = new StringBuilder();

		for(int testCase = 0; testCase < 10; testCase++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			arr = new int[N + 1];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				sb.append(st.nextToken());
			}
			Tree tree = new Tree();
			tree.makeTree(sb.toString(), N);
			System.out.print("#" + (testCase + 1) + " ");
			tree.printTreeByInOrder();
		}
	}
	
	static class Tree {
		private TreeNode root;
		StringBuilder sb = new StringBuilder();

		public void makeTree(String str, int N) {
			Queue<TreeNode> que = new LinkedList();
			char c;
			TreeNode node = null;
			for(int i = N - 1; i >= 0; i--) {
				c = str.charAt(i);
				node = new TreeNode(c);
				if(N > (i + 1)*2) {
					node.right = que.poll();
				}
				if(N >= (i + 1)*2) {
					node.left = que.poll();
				}
				que.offer(node);
			}
			root = que.poll();
		}
		
		public void printTreeByInOrder() {
			printTreeByInOrder(root);
			System.out.println(sb);
		}

		private void printTreeByInOrder(TreeNode node) { // LCR
			if(node != null) {
				printTreeByInOrder(node.left);
				sb.append(node.data);
				printTreeByInOrder(node.right);
			}
		}
	}


	static class TreeNode {
		Object data;
		TreeNode left, right;
		public TreeNode() {
			super();
		}
		public TreeNode(Object data) {
			super();
			this.data = data;
		}
	}
}
