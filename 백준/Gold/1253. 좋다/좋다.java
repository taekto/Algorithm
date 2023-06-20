import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		int count = 0;
		


		for(int i=0;i<N;i++) {
			int start = 0;
			int end = N-1;
			int now = list.get(i);
			
			while(start != end) {
				int startnumber=list.get(start);
				int endnumber=list.get(end);
				if(startnumber+endnumber > now) {
					end--;
				}
				else if(startnumber+endnumber == now) {
					if(end == i) {
						end--;
						continue;
					}
					else if(start == i) {
						start++;
						continue;
					}
					else {
						count++;
						break;
					}
				}
				else if(startnumber+endnumber < now) {
					start++;
				}
			}
		}
		System.out.println(count);

		
	}
}