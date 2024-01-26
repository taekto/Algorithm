import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    static boolean binarySearch(int target) {
        int st = 0;
        int ed = N-1;
        while(st <= ed) {
            int mid = (st+ed)/2;
            if(arr[mid] < target) st = mid+1;
            else if(arr[mid] > target) ed = mid-1;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            int a = Integer.parseInt(st.nextToken());
            if(binarySearch(a)) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }
}