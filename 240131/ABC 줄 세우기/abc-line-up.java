import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] chars = br.readLine().split(" ");

        int cnt = 0;
        for(int i=0; i<chars.length - 1; i++) {
            if(chars[i].compareTo(chars[i+1]) > 0) {
                cnt++;
            }
        }

        if(cnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(cnt + 1);
        }
    }
}