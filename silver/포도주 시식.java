import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[N+1];
		int sp[] = new int[N+1];
		for(int i=0;i<N;i++)
		    dp[i] = Integer.parseInt(br.readLine());
		
		sp[0] = dp[0];
		sp[1] = dp[1]+dp[0];
		sp[2] = Math.max(Math.max(dp[0] + dp[1], sp[1]), dp[0]+dp[2]);
		for(int i=3;i<N;i++)
		{
		    sp[i] = Math.max(Math.max(sp[i-1], sp[i-2]+dp[i]),sp[i-3]+dp[i-1]+dp[i]);
		}
		System.out.println(sp[N-1]);
	}
}
