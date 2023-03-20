import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;



public class Main {

    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static int[] visited = new int[300001];

    
    public static void bfs(int start) {
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(start);
    	visited[start] = 0;
    	
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		for(int i=0;i<graph.get(x).size();i++) {
    			int y = graph.get(x).get(i);
    			if(visited[y] == 0 && y != start) {
    				q.offer(y);
    				visited[y] = visited[x] + 1;
    			}
    		}
    	}
    }
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int K = sc.nextInt();
    	int X = sc.nextInt();
    	
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
    	
    	for(int i=0;i<M;i++) {
    		int A = sc.nextInt();
    		int B = sc.nextInt();
    		graph.get(A).add(B);
    	}
    	
    	bfs(X);
    	
    	List<Integer> list = new ArrayList<>();
    	
    	for(int i=1;i<=N;i++) {
    		if(visited[i] == K) {
    			list.add(i);
    		}
    	}
    	
    	if(list.isEmpty()) {
    		System.out.println(-1);
    	} else {
    		for(int j=0;j<list.size();j++) {
    			System.out.println(list.get(j));
    		}
    	}
	}
}
