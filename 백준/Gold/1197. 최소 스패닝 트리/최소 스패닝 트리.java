import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	private int nodeA;
	private int nodeB;
	private int cost;
	public int getNodeA() {
		return nodeA;
	}
	public void setNodeA(int nodeA) {
		this.nodeA = nodeA;
	}
	public int getNodeB() {
		return nodeB;
	}
	public void setNodeB(int nodeB) {
		this.nodeB = nodeB;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Edge(int nodeA, int nodeB, int cost) {
		super();
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		if(this.cost < o.cost) return -1;
		return 1;
	}
	
	
}


public class Main {
	
	
	public static int[] parent;
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정점의 갯수, 간선의 갯수
		int V = sc.nextInt();
		int E = sc.nextInt();
		parent = new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
		List<Edge> edges = new ArrayList<>();
		
		// 간선의 갯수 만큼 반복
		for(int i=0;i<E;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edges.add(new Edge(a,b,cost));
		}
		edges.sort(null);
		int result = 0;
		for(int i=0;i<edges.size();i++) {
			int a = edges.get(i).getNodeA();
			int b = edges.get(i).getNodeB();
			int cost = edges.get(i).getCost();
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		System.out.println(result);
		
		
	}
}
