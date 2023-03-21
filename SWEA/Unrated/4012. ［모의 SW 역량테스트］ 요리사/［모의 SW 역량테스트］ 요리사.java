import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static int N;
    public static int[][] arr;
    public static boolean[] visited;
    public static int result = Integer.MAX_VALUE;
    public static int[] cookxy;
    
    
    
    public static void dfs(int count, int idx) {
        if(count == N/2) {
        	int result1 = 0;
        	int result2 = 0;
        	
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			if(i == j) continue;
        			if(visited[i] && visited[j]) {
        				result1 += arr[i][j];
        			}
        			else if(!visited[i] && !visited[j]) {
        				result2 += arr[i][j];
        			}
        		}
        	}
        	

//        	System.out.println(list1);
//        	System.out.println(list2);
        	result = Math.min(result, Math.abs(result1-result2));
        	
//            System.out.println(Arrays.toString(visited));
            return;
        }
        
        for(int i=idx;i<N;i++) {
        	visited[i] = true;
        	dfs(count+1,i+1);
        	visited[i] = false;
        }
        return;
        
    }
    
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테케 T
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
            N = sc.nextInt();
            arr = new int[N][N];
            visited = new boolean[N];
            cookxy = new int[N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            dfs(0,0);
            
            
            System.out.println("#"+tc+" "+result);
            result = Integer.MAX_VALUE;
            
        }
    }
    
    
}