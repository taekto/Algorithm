import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String[] arr = s.substring(1, s.length()-1).split(",");

            LinkedList<Integer> q = new LinkedList<>();

            Boolean isLeft = true;
            Boolean flag = false;
            int count = 0;
            for(int i=0;i<n;i++) {
                q.add(Integer.parseInt(arr[i]));
            }

            for(int i=0;i<p.length();i++) {
                String command = String.valueOf(p.charAt(i));
                if(command.equals("R")) {
                    if(isLeft == true) {
                        isLeft = false;
                    }
                    else {
                        isLeft = true;
                    }
                }
                else {
                    if(q.isEmpty()) {
                        flag = true;
                    }
                    else {
                        if(isLeft == true) {

                            q.pollFirst();

                        }
                        else {
                            q.pollLast();
                        }
                        count++;
                    }
                }
            }


            if(flag) {
                sb.append("error").append("\n");
            }
            else {
                sb.append("[");
                if(isLeft) {
                    while(!q.isEmpty()) {
                        if(q.size() == 1) {
                            sb.append(q.pollFirst());
                            break;
                        }
                        sb.append(q.pollFirst()).append(",");
                    }
                }
                else {
                    while(!q.isEmpty()) {
                        if(q.size() == 1) {
                            sb.append(q.pollLast());
                            break;
                        }
                        sb.append(q.pollLast()).append(",");
                    }
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}