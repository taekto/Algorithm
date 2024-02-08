import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] sorted_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted_arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = sorted_arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted_arr);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int rank = 0;
        for(int i=0;i<N;i++) {
            if(!hashMap.containsKey(sorted_arr[i])) {
                hashMap.put(sorted_arr[i], rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(hashMap.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}