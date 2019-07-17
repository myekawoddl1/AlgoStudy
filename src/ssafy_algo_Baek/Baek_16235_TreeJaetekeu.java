package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Baek_16235_TreeJaetekeu {
    static class Tree implements Comparable<Tree> {
        int y, x, age;
        public Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    static class Map{
        int energy = 0;

        public Map(int energy) {
            this.energy = energy;
        }
    }
    static int dx[] = {0,0,1,1,-1,-1,1,-1};
    static int dy[] = {1,-1,1,-1,1,-1,0,0};
    static int N, M, K;
    static int arr[][];
    static ArrayList<Tree> trees;
    static ArrayList<Tree> deadTrees;
    static Map map[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        map = new Map[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = new Map(5);
            }
        }

        trees = new ArrayList<>();
        deadTrees = new ArrayList<>();
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(r, c, age));
        }

        for(int i = 1; i <= K && trees.size() != 0; i++){
            spring();
            summer();
            fall();
            winter();
        }
        System.out.println(trees.size());
    }

    private static void winter() {
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                map[i][j].energy += arr[i][j];
            }
        }
    }

    private static void fall() {
        int treeC = trees.size();
        for(int t = 0; t < treeC; t++){
            Tree tree = trees.get(t);
            if (tree.age % 5 == 0){
                for(int i = 0; i < 8; i++){
                    int nx = tree.x + dx[i];
                    int ny = tree.y + dy[i];
                    if(nx < 1 || nx > N || ny < 1 || ny > N) continue;
                    trees.add(new Tree(nx, ny, 1));
                }
            }
        }

    }

    private static void summer() {
        for(int t = 0; t < deadTrees.size(); t++){
            Tree tree = deadTrees.get(t);
            map[tree.y][tree.x].energy += tree.age/2;
        }
        deadTrees.clear();
    }

    private static void spring() {
        Collections.sort(trees);
        int age = 0;
        for(int t = 0; t < trees.size(); t++){
            Tree tree = trees.get(t);
            age = tree.age;
            if(age <= map[tree.y][tree.x].energy){
                map[tree.y][tree.x].energy -= age;
                trees.get(t).age++;
                continue;
            }
            deadTrees.add(tree);
            trees.remove(t);
            t--;
        }

    }
}
