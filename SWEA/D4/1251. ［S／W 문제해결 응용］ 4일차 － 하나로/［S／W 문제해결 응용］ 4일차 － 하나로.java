import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

    private double distance;
    private int nodeA;
    private int nodeB;

    public Edge(double distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public double getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

    // 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class Solution {
	public static int[][] location;
	public static double plus;
	public static int N;
	public static int[] arr;
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
		// 테스트케이스 T
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// 섬의 갯수 N
			N = sc.nextInt();
			// 각 섬들의 x좌표, y좌표 
			parent = new int[N+1];
			for(int i=1;i<=N;i++) {
				parent[i] = i;
			}
			location = new int[N+1][2];
			for(int i=1;i<=N;i++) {
				location[i][0] = sc.nextInt();
			}
			for(int i=1;i<=N;i++) {
				location[i][1] = sc.nextInt();
			}
			// 가중치 plus
			plus = sc.nextDouble();
			List<Edge> edges = new ArrayList<>();
			for(int i=1;i<=N-1;i++) {
				for(int j=i+1;j<=N;j++) {
					int a = i;
					int b = j;
					double distance = Math.pow(Math.abs(location[a][0]-location[b][0]), 2) + Math.pow(Math.abs(location[a][1]-location[b][1]), 2);
					edges.add(new Edge(distance, a, b));
				}
			}
			edges.sort(null);
			double cost = 0;
			for(int i=0;i<edges.size();i++) {
				int a = edges.get(i).getNodeA();
				int b = edges.get(i).getNodeB();
				double distance = edges.get(i).getDistance();
	            if (findParent(a) != findParent(b)) {
	                unionParent(a, b);
	                cost += distance;
	            }
			}
			cost = Math.round(cost*plus);
			System.out.println("#"+tc+" "+(long) cost);
		}
	}
}
