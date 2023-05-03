import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node implements Comparable<Node> {
	int strength;
	int num;
	public Node(int strength, int num) {
		super();
		this.strength = strength;
		this.num = num;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return o.strength - this.strength;
	}
	
	
	
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 T
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			// 문서의 갯수 N
			int N = sc.nextInt();
			// 궁금한 문서가 몇번째에 있는지 나타나는 수 M
			int M = sc.nextInt();
			
			Queue<Node> q = new LinkedList<>();
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			for(int i=0;i<N;i++) {
				int a = sc.nextInt();
				if(i == M) {
					q.add(new Node(a, -1));
					pq.add(new Node(a, -1));
				}
				else {
					q.add(new Node(a, 0));
					pq.add(new Node(a, 0));
				}
			}
			int count = 0;
			
			while(true) {
				int pqstrength = pq.peek().strength;
				int qstrength = q.peek().strength;
//				System.out.println(pqstrength);
				if(pqstrength == qstrength && q.peek().num == -1) {
					System.out.println(count+1);
					break;
				}
				
				if(pqstrength == qstrength && q.peek().num == 0) {
					pq.poll();
					q.poll();
					count++;
				}
				
				if(pqstrength != qstrength) {
					q.add(q.poll());
				}
			}
		}
	}
}