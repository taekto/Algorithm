import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	 // 수의 갯수 N
    	int N = Integer.parseInt(st.nextToken());
    	// 구해야 하는 횟수 M
    	int M = Integer.parseInt(st.nextToken());
    	
    	// 그냥 숫자 
    	int[] arr = new int[N];
    	// 구간합 숫자
    	int[] sumarr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		
    		if(i == 0) {
    			sumarr[i] = arr[0];
    		}
    		else {
    			sumarr[i] = sumarr[i-1]+arr[i];
    		}
    	}
    	
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine());
    		int start = Integer.parseInt(st.nextToken());
    		int end = Integer.parseInt(st.nextToken());
    		if(start == 1) {
    			System.out.println(sumarr[end-1]);
    		}
    		else {
    			System.out.println(sumarr[end-1]-sumarr[start-2]);
    		}
    	}
    	
    	
    	
    }
}