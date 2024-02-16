import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Student implements Comparable<Student>{
        String name;
        int hanguk;
        int english;
        int math;

        public Student(String name, int hanguk, int english, int math) {
            this.name = name;
            this.hanguk = hanguk;
            this.math = math;
            this.english = english;
        }

        @Override
        public int compareTo(Student o) {
            if(this.hanguk<o.hanguk) return 1;
            else if(this.hanguk > o.hanguk) return -1;
            else {
                if(this.english<o.english) return -1;
                else if(this.english>o.english) return 1;
                else {
                    if(this.math<o.math) return 1;
                    else if(this.math>o.math) return -1;
                    else {
                        for(int i=0;i<Math.min(this.name.length(),o.name.length());i++) {
                            if(this.name.charAt(i) == o.name.charAt(i)) continue;
                            return (this.name.charAt(i)-o.name.charAt(i));
                        }
                    }
                }
            }
            return 0;
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int hanguk = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            list.add(new Student(name, hanguk,english , math));
        }

        Collections.sort(list);
        for(int i=0;i<N;i++) {
            Student cur = list.get(i);
//            System.out.println(cur.name+" "+cur.hanguk+" "+cur.english+" "+cur.math);
            System.out.println(cur.name);
        }
    }
}