import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 테케는 10번
		for(int tc=1;tc<=10;tc++) {
			
			// 정점의 총 수 N
			int N = Integer.parseInt(br.readLine());
			List<String> tree = new ArrayList<>();
			tree.add("\u0000");

			for(int i=0;i<N;i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				// root, alphabet, left, right
				String root = st.nextToken();
				String alphabet = st.nextToken();
				String left = "";
				String right = "";
				if(st.hasMoreTokens()) {
					left = st.nextToken();
				}
				if(st.hasMoreTokens()) {
					right = st.nextToken();
				}
				tree.add(alphabet);
				
			}
			System.out.print("#"+tc+" ");
			inorder(1, tree);
			System.out.println();
			
		}
	}
	public static void inorder(int a, List<String> list) {
		
		if(a <= list.size()-1) {
			
			inorder(a*2, list);
			System.out.print(list.get(a));
			inorder(a*2+1,list);
			
		}
	}
}
