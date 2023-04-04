import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static int N,W,H;
	public static int[][] arr;
	public static int[][] temp;
	public static int[] block;
	public static boolean[][] visited;
	public static int result = Integer.MAX_VALUE;
	
	public static class Node {
		private int y;
		private int x;
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	
	public static void dfs(int count) {
		if(count == N) {
			// block 이라는 배열에는 중복이 허용된 순열로 벽돌의 가로 값이 저장되어 있음
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			
			int score = 0;
			
			for(int i=0;i<N;i++) {
				bfs(i);
				blockSort();
			}
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(temp[i][j] != 0) score++;
				}
			}
			result = Math.min(score, result);
			
			
			return;
		}
		
		for(int i=0;i<W;i++) {
			block[count] = i;
			dfs(count+1);
		}
	}
	
	// 벽돌 깨는 메서드 작성하자
	public static void bfs(int blocknum) {
		int score = 0;
		visited = new boolean[H][W];
		Queue<Node> q = new LinkedList<>();
		
		for(int i=0;i<H;i++) {
			if(temp[i][block[blocknum]] != 0) {
				q.offer(new Node(i,block[blocknum]));
				visited[i][block[blocknum]] = true;
				break;
			}
		}
		// bfs
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int y = cur.getY();
			int x = cur.getX();
			int blockscore = temp[y][x];
			score += blockscore;
			temp[y][x] = 0;
			// 세로로 자기자신의 score만큼 탐색
			for(int i=-blockscore+1;i<=blockscore-1;i++) {
				// 0일때는 고려 x
				if(i == 0) continue;
				// 벗어나면 고려 x
				if(y+i < 0 || y+i >= H) continue;
				// visited이 false일때만 작동
				if(!visited[y+i][x]) {
					visited[y+i][x] = true;
					q.offer(new Node(y+i,x));
				}
			}
			// 가로도 마찬가지로
			for(int i=-blockscore+1;i<=blockscore-1;i++) {
				if(i == 0) continue;
				if(x+i < 0 || x+i >= W) continue;
				if(!visited[y][x+i]) {
					visited[y][x+i] = true;
					q.offer(new Node(y,x+i));
				}
			}
		}
	}
	
	// 벽돌이 부서진 후 공백 없이 정렬하는 메서드 작성하자! 
	public static void blockSort() {
		int[][] changearr = new int[H][W];
		
		for(int i=0;i<W;i++) {
			int idx = H-1;
			for(int j=H-1;j>=0;j--) {
				if(temp[j][i] != 0) {
					changearr[idx][i] = temp[j][i];
					idx--;
				}
			}
		}
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				temp[i][j] = changearr[i][j];
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			// N개의 벽돌 , 가로 W, 세로 H
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			arr = new int[H][W];
			temp = new int[H][W];
			block = new int[N];
			// arr 입력받기
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			dfs(0);
			
			System.out.println("#"+tc+" "+result);
			result = Integer.MAX_VALUE;
			
		}
	}
}