import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
		}
		list.sort(null);
		long resulttime = Integer.MAX_VALUE;
		long resultheight = 0;
		
		for(int i=list.get(0);i<=list.get(list.size()-1);i++) {
			long time = 0;
			long blockcount = B;
			
			for(int j=0;j<N*M;j++) {
				int a = list.get(j);
				if(a-i>0) {
					time += Math.abs(a-i)*2;
					blockcount += Math.abs(a-i);
				}
				else if(i == a) {
					
				}
				else if(a-i<0){
					time += Math.abs(a-i);
					blockcount -= Math.abs(a-i);
				}

			}
			if(blockcount < 0) break;
			
			if(time <= resulttime && blockcount >= 0) {
				resulttime = Math.min(resulttime, time);
				resultheight = Math.max(i, resultheight);
			}
		}
		System.out.println(resulttime+" "+resultheight);
			
			
			
			
		
	}
}