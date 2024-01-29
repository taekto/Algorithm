import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] num;
    static int k;
    static char[] count;
    static StringBuilder sb = new StringBuilder();
    static long min = Long.MAX_VALUE;
    static long max = Long.MIN_VALUE;
    static boolean[] visited;

    static void func(int depth) {
        if(depth == k+1) {
            String s = "";
            for(int i=0;i<k+1;i++) {
                s += String.valueOf(num[i]);
            }
            min = Math.min(min, Long.parseLong(s));
            max = Math.max(max, Long.parseLong(s));
            return;
        }

        for(int i=0;i<10;i++) {
            if(depth == 0 && !visited[i]) {
                num[depth] = i;
                visited[i] = true;
                func(depth+1);
                num[depth] = 0;
                visited[i] = false;
            }
            else {
                if(!visited[i]) {
                    if(count[depth-1] == '>' && num[depth-1] > i) {
                        num[depth] = i;
                        visited[i] = true;
                        func(depth+1);
                        num[depth] = 0;
                        visited[i] = false;
                    }
                    if(count[depth-1] == '<' && num[depth-1] < i) {
                        num[depth] = i;
                        visited[i] = true;
                        func(depth+1);
                        num[depth] = 0;
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        num = new int[k+1];
        count = new char[k];
        visited = new boolean[10];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<k;i++) {
            count[i] = st.nextToken().charAt(0);
        }

        func(0);

        String resultMax = "";
        String resultMin = "";

        if(String.valueOf(max).length() != k+1) {
            resultMax = "0" + String.valueOf(max);
        }
        else {
            resultMax = String.valueOf(max);
        }


        if(String.valueOf(min).length() != k+1) {
            resultMin = "0" + String.valueOf(min);
        }
        else {
            resultMin = String.valueOf(min);
        }

        System.out.println(resultMax);
        System.out.println(resultMin);

    }
}