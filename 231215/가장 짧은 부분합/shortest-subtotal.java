import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n, s;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        String[] temp = br.readLine().split(" ");
        
        int minLen = Integer.MAX_VALUE;
        int right = 0;
        int sum = 0;

        for(int left=0; left<n; left++) {
            while(right < n && sum < s) {
                sum += Integer.parseInt(temp[right++]);
            }

            if(right == n && sum < s) {
                break;
            }

            minLen = Integer.min(minLen, right - left);
            // System.out.println("length : " + (right - left) + ", sum : " + sum);
            sum -= Integer.parseInt(temp[left]);
        }
        
        minLen = (minLen == Integer.MAX_VALUE) ? -1 : minLen;
        System.out.println(minLen);
    }
}