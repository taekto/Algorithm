import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static List<List<Integer>> graph;
    public static int[] indegree;
    public static int V, E;
    
    public static void topologySort() {
    	List<Integer> result = new ArrayList<>();
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i=1;i<=V;i++) {
    		if(indegree[i] == 0) {
    			q.offer(i);
    		}
    	}
    	
    	while(!q.isEmpty()) {
    		int now = q.poll();
    		result.add(now);
    		
    		for(int i=0;i<graph.get(now).size();i++) {
    			indegree[graph.get(now).get(i)] -= 1;
    			if(indegree[graph.get(now).get(i)] == 0) {
    				q.offer(graph.get(now).get(i));
    			}
    		}
    	}
    	
    	for(int i=0;i<result.size();i++) {
    		System.out.print(result.get(i)+" ");
    	}
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테케는 10번
		for(int tc=1;tc<=10;tc++) {
			// 정점의 갯수 V, 간선의 갯수 E
			V = sc.nextInt();
			E = sc.nextInt();
			
			graph = new ArrayList<>();
			indegree = new int[100001];
			for(int i=0;i<=V;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<E;i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph.get(a).add(b);
				indegree[b] +=1;
			}
			System.out.print("#"+tc+" ");
			topologySort();
			System.out.println();
			
		}
	}
}