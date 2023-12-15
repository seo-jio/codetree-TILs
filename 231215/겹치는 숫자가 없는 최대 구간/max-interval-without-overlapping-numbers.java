import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cntArr = new int[100001];

        int maxLen = Integer.MIN_VALUE;
        int right = 0;
        for(int left=0; left<N; left++) {
            while(right < N) {
                if(cntArr[arr[right]] != 0) {
                    break;
                }

                cntArr[arr[right]]++;
                right++;
            }

            // System.out.println("left : " + left + ", right : " + right);
            maxLen = Math.max(maxLen, right - left);
            cntArr[arr[left]]--;
        }

        System.out.println(maxLen);
    }
}