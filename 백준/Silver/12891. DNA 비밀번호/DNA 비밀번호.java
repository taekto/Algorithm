import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 문자열 길이 S, 부분문자열의 길이 P
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		String str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		int countA = Integer.parseInt(st.nextToken());
		int countC = Integer.parseInt(st.nextToken());
		int countG = Integer.parseInt(st.nextToken());
		int countT = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int start = 0;
		int end = P-1;
		
		int incountA = 0;
		int incountC = 0;
		int incountG = 0;
		int incountT = 0;

		for(int i=start;i<=end;i++) {
			char a = str.charAt(i);
			if(a == 'A') {
				incountA++;
			}
			else if(a == 'C') {
				incountC++;
			}
			else if(a == 'G') {
				incountG++;
			}
			else if(a == 'T') {
				incountT++;
			}
		}
		
		while(end != S) {

			if(incountA>=countA && incountC >= countC && incountG >= countG && incountT >= countT) {
				count++;
			}
			
			end++;
			if(end >= S) break;
			
			char a = str.charAt(start);
			char b = str.charAt(end);
			

			
			
			if(a == 'A') {
				incountA--;
			}
			else if(a == 'C') {
				incountC--;
			}
			else if(a == 'G') {
				incountG--;
			}
			else if(a == 'T') {
				incountT--;
			}
			if(b == 'A') {
				incountA++;
			}
			else if(b == 'C') {
				incountC++;
			}
			else if(b == 'G') {
				incountG++;
			}
			else if(b == 'T') {
				incountT++;
			}
			start++;
		}
		System.out.println(count);

		
		
	}
}