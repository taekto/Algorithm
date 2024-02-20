import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<>();
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                hashSet.add(a);
            }
            else if(command.equals("check")) {
                int a = Integer.parseInt(st.nextToken());
                if(hashSet.contains(a)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(command.equals("remove")) {
                int a = Integer.parseInt(st.nextToken());
                if(hashSet.contains(a)) {
                    hashSet.remove(a);
                }
            }
            else if(command.equals("toggle")) {
                int a = Integer.parseInt(st.nextToken());
                if(hashSet.contains(a)) {
                    hashSet.remove(a);
                }
                else {
                    hashSet.add(a);
                }
            }
            else if(command.equals("all")) {
                hashSet.removeAll(hashSet);
                for(int j=1;j<=20;j++) {
                    hashSet.add(j);
                }
            }
            else {
                hashSet.removeAll(hashSet);
            }
        }
        System.out.print(sb.toString());
    }
}