import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int dp[] = new int[100001];
	    
	    dp[1] = 1;
	    for(int i=2;i<=N;i++){
	        int answer = 100001;
	        for(int j=1;j<=i/2;j++){
	            if (j *j == i){
	                answer = 1;
	                break;
	            }
	            answer = Math.min(answer,dp[j]+dp[i-j]);
	        }
	        dp[i] = answer;
	    }
	    System.out.println(dp[N]);
	}
}
