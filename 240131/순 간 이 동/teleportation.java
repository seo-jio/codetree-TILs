import java.io.*;
import java.util.*;

public class Main {
    static int[] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[4];

        for(int i=0; i<4; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int first = Math.abs(nums[0] - nums[1]);
        int second = Math.abs(nums[0] - nums[2]) + Math.abs(nums[3] - nums[2]);
        int third = Math.abs(nums[0] - nums[3]) + Math.abs(nums[2] - nums[1]);

        int min = Math.min(first, second);
        System.out.println(Math.min(min, third));
    }
}