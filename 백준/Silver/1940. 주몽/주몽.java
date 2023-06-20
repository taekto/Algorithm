import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 재료의 갯수 N, 갑옷을 만드는데 필요한 수M
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				int a = arr[i]+arr[j];
				if(a == M) {
					count++;
				}
			}
		}
		System.out.println(count);
		
		
	}
}