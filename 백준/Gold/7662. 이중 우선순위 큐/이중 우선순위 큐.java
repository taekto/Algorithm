import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> treeMap = new TreeMap<>();
            for(int j=0;j<k;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char a = st.nextToken().charAt(0);
                long b = Long.parseLong(st.nextToken());
                if(a == 'I') {
                    treeMap.put(b, treeMap.getOrDefault(b,0)+1);
                }
                else {
                    if(treeMap.isEmpty()) continue;
                    if(b == 1) {
                        b = treeMap.lastKey();
                    }
                    else if(b == -1) {
                        b = treeMap.firstKey();

                    }
                    if(treeMap.put(b, treeMap.get(b)-1) == 1) {
                        treeMap.remove(b);
                    }
                }
            }
            if(treeMap.isEmpty()) {
                System.out.println("EMPTY");
            }
            else {
                System.out.println(treeMap.lastKey()+" "+treeMap.firstKey());
            }
        }
    }
}